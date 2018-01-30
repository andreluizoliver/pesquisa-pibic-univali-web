/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import bean.Login;
import control.RegistrationService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpResponse;
import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.SampleConsumer;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.MessageException;

/**
 *
 * @author Andre
 */
public class LoginMB implements Serializable {

    private Login login;

    /** Creates a new instance of LoginMB */
    public LoginMB() throws ConsumerException {
        System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do Reserva <<<<<<<<<<<<<<<<<<");
        login = new Login();
    }

    public String autenticar() {

        ExternalContext extCon = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) extCon.getSession(true);

        //II-III----------------Delegado à Open ID código-----------------------
        // 1. Realize a descoberta no identificador Fornecidos pelo Usuário
        DiscoveryInformation discoveryInformation = RegistrationService.performDiscoveryOnUserSuppliedIdentifier(login.getOpenid());
        //----------------------------------------------------------------------

        // Armazene os resultados disovery em sessão.
        session.setAttribute("discoveryInformation", discoveryInformation);

        //IV---------------------Crie o AuthRequest-----------------------------
        // 2. Criar o objeto openid4java AuthRequest que será usado para fazer a solicitação de autenticação
        AuthRequest authRequest = RegistrationService.createOpenIdAuthRequest(discoveryInformation, RegistrationService.getReturnToUrl());
        try {
            //--------------Agora pegue o AuthRequest e enviá-lo para o OP----------
            // 3. Redirecionar o navegador para o provedor OpenID
            extCon.redirect(authRequest.getDestinationUrl(true));
            //extCon.dispatch(authRequest.getDestinationUrl(true));
            //----------------------------------------------------------------------
        } catch (IOException ex) {
            Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        //----------------------------------------------------------------------

        return "index";

    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
