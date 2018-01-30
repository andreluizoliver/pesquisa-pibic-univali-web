package control;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.PageParameters;
import org.joda.time.YearMonthDay;
import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.InMemoryConsumerAssociationStore;
import org.openid4java.consumer.InMemoryNonceVerifier;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.MessageExtension;
import org.openid4java.message.ParameterList;
import org.openid4java.message.sreg.SRegMessage;
import org.openid4java.message.sreg.SRegRequest;
import org.openid4java.message.sreg.SRegResponse;

/**
 * Consolidates business logic from the UI code for Registration activities.
 * 
 * Most of this code modeled after ConsumerServlet, part of the openid4java 
 * sample code available at 
 * http://code.google.com/p/openid4java/wiki/SampleConsumer.
 * Some of this code was outright copied :->.
 * 
 * @author J Steven Perry
 * @author http://makotoconsulting.com
 *
 */
public class RegistrationService {
	private static final Logger log = Logger.getLogger(RegistrationService.class);

        DiscoveryInformation ret = null;
	
	/**
        * Realizar a descoberta de Usuário Fornecido identificador e retornar o
        * DiscoveryInformation objeto que resulta da associação com a
        * OP. Esta será provavelmente necessário pelo chamador (armazenada na sessão
        * Talvez?).
        *
        * Eu não estou entusiasmado com ConsumerManager ser estática, mas é
        * Openid4java muito importante para que o objeto a ser ConsumerManager
        * Mesma instância tudo através de uma conversa (descoberta, o pedido de autenticação,
        * Resposta auth), com o OP. Eu não curti terrivelmente profundamente, mas suspeito
        * Essa parte da troca de chaves ou o nonce usa o ConsumerManager de
        * Hash, ou alguma outra instância construção específica para fazer a sua coisa.
        *
        * @ Param userSuppliedIdentifier O usuário Fornecido identificador. Ela já pode
        * Deverá ser normalizado.
        *
        * @ Return DiscoveryInformation - O objeto resultante DisoveryInformation
        * Retornado por openid4java seguinte bem sucedida associação com o OP.
        */
	@SuppressWarnings("unchecked")
	public static DiscoveryInformation performDiscoveryOnUserSuppliedIdentifier(String userSuppliedIdentifier) {
		DiscoveryInformation ret = null;
		//
		ConsumerManager consumerManager = getConsumerManager();
		try {

		//II. DESCOBERTA-------Execute descobrir na Identificador Fornecidos pelo Usuário-------------
		List<DiscoveryInformation> discoveries = consumerManager.discover(userSuppliedIdentifier);
                //----------------------------------------------------------------------------------------
                
		//III. ASSOCIAÇÃO-------Passa as descobertas ao associar() método...---------------------------
		ret = consumerManager.associate(discoveries);
                //----------------------------------------------------------------------------------------


		} catch (DiscoveryException e) {
			String message = "Um erro ocorreu durante a descoberta!";
			log.error(message, e);
			throw new RuntimeException(message, e);
		}
		return ret;
	}
	/**
        * Criar uma solicitação de autenticação OpenID, usando o objeto DiscoveryInformation
        * retorno pela biblioteca openid4java.
        *
        * Este método também utiliza o simples registro de concessão de Extensão
        * a Terceira Parte (RP).
        *
        * @ param discoveryInformation DiscoveryInformation que deveria ter
        * sido previamente obtido a partir de uma chamada para
        * performDiscoveryOnUserSuppliedIdentifier ().
        *
        * @ param returnToUrl A URL para a qual o OP irá redirecionar uma vez que o
        * Chamada autenticação for concluída.
        *
        AuthRequest * @ return - um "bom-to-go" AuthRequest objeto embalado com todos os
        * tipos de guloseimas grande OpenID para o provedor de OpenID (OP). O chamador
        * deve ter este objeto e encaminhá-lo para o OP. Ou ligue para
        * processAuthRequest () - parte desta classe de serviço.
        */
	public static AuthRequest createOpenIdAuthRequest(DiscoveryInformation discoveryInformation, String returnToUrl) {
		AuthRequest ret = null;
		//
		try {
			//IV. AUTENTICAÇÃO----------Create the AuthRequest object---------------------------
			ret = getConsumerManager().authenticate(discoveryInformation, returnToUrl);
			// Create the Simple Registration Request
			SRegRequest sRegRequest = SRegRequest.createFetchRequest();
                        //----------------------------------------------------------------------------------
			sRegRequest.addAttribute("email", false);
			sRegRequest.addAttribute("fullname", false);
			sRegRequest.addAttribute("dob", false);
			sRegRequest.addAttribute("postcode", false);
                        //IV----------------------------------------------------------------------------------
			ret.addExtension(sRegRequest);
                        //----------------------------------------------------------------------------------
			
		} catch (Exception e) {
			String message = "Exception occurred while building AuthRequest object!";
                        ret = null;
			log.error(message, e);
			throw new RuntimeException(message, e);
                        
		}
		return ret;
	}
	
	/**
	 * Processes the returned information from an authentication request
	 * from the OP.
	 * 
	 * @param discoveryInformation DiscoveryInformation that was created earlier
	 *  in the conversation (by openid4java). This will need to be verified with
	 *  openid4java to make sure everything went smoothly and there are no
	 *  possible problems. This object was probably stored in session and retrieved
	 *  for use in calling this method.
	 *  
	 * @param pageParameters PageParameters passed to the page handling the
	 *  return verificaion.
	 *  
	 * @param returnToUrl The "return to" URL that was passed to the OP. It must
	 *  match exactly, or openid4java will issue a verification failed message
	 *  in the logs.
	 *  
	 * @return RegistrationModel - null if there was a problem, or a RegistrationModel
	 *  object, with parameters filled in as compeletely as possible from the
	 *  information available from the OP. If you are using MyOpenID, most of the
	 *  time what is returned is from your "Default" profile, so if you need more 
	 *  information returned, make sure your Default profile is completely filled
	 *  out.
	 */
	public static RegistrationModel processReturn(DiscoveryInformation discoveryInformation, PageParameters pageParameters, String returnToUrl) {
		RegistrationModel ret = null;
		// Verify the Information returned from the OP
		/// This is required according to the spec
		ParameterList response = new ParameterList(pageParameters);
		try {
			VerificationResult verificationResult = getConsumerManager().verify(returnToUrl, response, discoveryInformation);
			Identifier verifiedIdentifier = verificationResult.getVerifiedId();
			if (verifiedIdentifier != null) {
				AuthSuccess authSuccess = (AuthSuccess)verificationResult.getAuthResponse();
				if (authSuccess.hasExtension(SRegMessage.OPENID_NS_SREG)) {
					MessageExtension extension = authSuccess.getExtension(SRegMessage.OPENID_NS_SREG);
					if (extension instanceof SRegResponse) {
						ret = new RegistrationModel();
						ret.setOpenId(verifiedIdentifier.getIdentifier());
						SRegResponse sRegResponse = (SRegResponse)extension;
						String value = sRegResponse.getAttributeValue("dob");
						if (value != null) {
						  ret.setDateOfBirth(new YearMonthDay(value).toDateMidnight().toDate());
						}
						value = sRegResponse.getAttributeValue("email");
						if (value != null) {
						  ret.setEmailAddress(value);
						}
						value = sRegResponse.getAttributeValue("fullname");
						if (value != null) {
						  ret.setFullName(value);
						}
						value = sRegResponse.getAttributeValue("postcode");
						if (value != null) {
						  ret.setZipCode(value);
						}
					}
				}
			}
		} catch (Exception e) {
			String message = "Exception occurred while verifying response!";
			log.error(message, e);
			throw new RuntimeException(message, e);
		}
		return ret;
	}

	private static ConsumerManager consumerManager;
	/**
	 * Retrieves an instance of the ConsumerManager object. It is static
	 * (see note in Class-level JavaDoc comments above) because openid4java
	 * likes it that way.
	 * 
	 * Note: if you are planning to debug the code, set the lifespan parameter
	 * of the InMemoryNonceVerifier high enough to outlive your debug cycle, or
	 * you may notice Nonce Verification errors. Depending on where you are
	 * debugging, this might pose an artificial problem for you (of your own
	 * making) that has nothing to do with either your code or openid4java.
	 * 
	 * @return ConsumerManager - The ConsumerManager object that handles
	 *  communication with the openid4java API.
	 */
	private static ConsumerManager getConsumerManager() {
		try {
			if (consumerManager == null) {
				consumerManager = new ConsumerManager();
				consumerManager.setAssociations(new InMemoryConsumerAssociationStore());
				consumerManager.setNonceVerifier(new InMemoryNonceVerifier(10000));
			}
		} catch (ConsumerException e) {
			String message = "Exception creating ConsumerManager!";
			log.error(message, e);
			throw new RuntimeException(message, e);
		}
		return consumerManager;
	}
  /**
   * Generates the returnToUrl parameter that is passed to the OP. The
   * User Agent (i.e., the browser) will be directed to this page following
   * authentication.
   * 
   * @param representedPage The RegistrationPage object whose cover is to be
   *  cracked open to get at the raw HttpServlet goodies inside.
   *  
   * @return String - the returnToUrl to be used for the authentication request.
   */
  public static String getReturnToUrl() {
    return "http://localhost:8282/PortalServiceWS/admin/reserva.faces";
  }
}
