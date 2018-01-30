/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rnp.stcfed.service.ws;

import br.rnp.stcfed.service.bean.ReservaBean;
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
 * @author ANDRE
 */
@WebService()
public class ReservaWS {

    ReservaControl control = null;

    public ReservaWS() throws ClassNotFoundException{
        this.control = new ReservaControl();
    }
    /**
     * Operação de serviço web
     */
    @WebMethod(operationName = "inserirReserva")
    public int inserirReserva(@WebParam(name = "reserva")
    ReservaBean res) {
        try {
            return this.control.insert(res);
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
            return this.control.update(reserva);
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
            return this.control.selectPorId(id);
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
    @WebMethod(operationName = "consultarPorNomeReserva")
    public List<ReservaBean> consultarPorNomeReserva(@WebParam(name = "nome")
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
    @WebMethod(operationName = "selectAllReserva")
    public List<ReservaBean> selectAllReserva() {
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
    @WebMethod(operationName = "olaReserva")
    public String olaReserva() {
        //TODO write your implementation code here:
        return "prazer";
    }   

}
