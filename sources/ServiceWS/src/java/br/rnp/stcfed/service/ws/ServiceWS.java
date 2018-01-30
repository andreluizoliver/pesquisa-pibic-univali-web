/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rnp.stcfed.service.ws;

import br.rnp.stcfed.service.bean.AcomodacaoBean;
import br.rnp.stcfed.service.bean.ReservaBean;
import br.rnp.stcfed.service.control.AcomodacaoArquivoControl;
import br.rnp.stcfed.service.control.AcomodacaoControl;
import br.rnp.stcfed.service.control.ReservaControl;
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
public class ServiceWS {

    ReservaControl controlReserva = null;
    AcomodacaoArquivoControl controlAcomodacao = null;


    public ServiceWS() throws ClassNotFoundException{
        this.controlReserva = new ReservaControl();
        this.controlAcomodacao = new AcomodacaoArquivoControl();
    }
    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "inserirReserva")
    public int inserirReserva(@WebParam(name = "reserva")
    ReservaBean res) {
        try {
            return this.controlReserva.insert(res);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "editarReserva")
    public int editarReserva(@WebParam(name = "reserva")
    ReservaBean reserva) {
        try {
            return this.controlReserva.update(reserva);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "consultarPorIdReserva")
    public ReservaBean consultarPorIdReserva(@WebParam(name = "id")
    int id) {
        try {
            return this.controlReserva.selectPorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "deletarReserva")
    public String deletarReserva(@WebParam(name = "id")
    int id) {
        try {
            this.controlReserva.delete(id);
            return "OK";
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "consultarPorNomeReserva")
    public List<ReservaBean> consultarPorNomeReserva(@WebParam(name = "nome")
    String nome) {
        try {
            return this.controlReserva.selectPorNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "selectAllReserva")
    public List<ReservaBean> selectAllReserva() {
        try {
            //TODO write your implementation code here:
            return this.controlReserva.selectAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "olaReserva")
    public String olaReserva() {
        //TODO write your implementation code here:
        return "prazer";
    }

    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "inserirAcomodacao")
    public int inserirAcomodacao(@WebParam(name = "reserva")
    AcomodacaoBean aco) {
        try {
            return this.controlAcomodacao.insert(aco);
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
            return this.controlAcomodacao.update(aco);
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
            return this.controlAcomodacao.selectPorId(id);
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
            this.controlAcomodacao.delete(id);
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
            return this.controlAcomodacao.selectPorNome(nome);
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
            return this.controlAcomodacao.selectAll();
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
