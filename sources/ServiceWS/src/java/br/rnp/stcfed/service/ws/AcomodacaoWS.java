/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rnp.stcfed.service.ws;

import br.rnp.stcfed.service.bean.AcomodacaoBean;
import br.rnp.stcfed.service.control.AcomodacaoArquivoControl;
import br.rnp.stcfed.service.control.AcomodacaoControl;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Andre Luiz
 */
@WebService()
public class AcomodacaoWS {

    AcomodacaoArquivoControl control = null;

    public AcomodacaoWS() throws ClassNotFoundException {
        this.control = new AcomodacaoArquivoControl();
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "inserirAcomodacao")
    public int inserirAcomodacao(@WebParam(name = "reserva")
    AcomodacaoBean aco) {
        try {
            return this.control.insert(aco);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarAcomodacao")
    public int editarAcomodacao(@WebParam(name = "reserva")
    AcomodacaoBean aco) {
        try {
            return this.control.update(aco);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "consultarPorIdAcomodacao")
    public AcomodacaoBean consultarPorIdAcomodacao(@WebParam(name = "id")
    int id) {
        try {
            return this.control.selectPorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarAcomodacao")
    public String deletarAcomodacao(@WebParam(name = "idAcomodacao")
    int id) {
        try {
            this.control.delete(id);
            return "OK";
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "consultarPorNomeAcomodacao")
    public List<AcomodacaoBean> consultarPorNomeAcomodacao(@WebParam(name = "nome")
    String nome) {
        try {
            return this.control.selectPorNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "selectAllAcomodacao")
    public List<AcomodacaoBean> selectAllAcomodacao() {
        try {
            //TODO write your implementation code here:
            return this.control.selectAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "olaAcomodacao")
    public String olaAcomodacao() {
        //TODO write your implementation code here:
        return "prazer";
    }

}
