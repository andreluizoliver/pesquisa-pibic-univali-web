/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.List;
import ws.ReservaBean;


/**
 *
 * @author Andre
 */
public class ReservaControl {

    public ReservaControl() {
    }

    private static int inserirReservaWS(ws.ReservaBean reserva) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.inserirReserva(reserva);
    }

    private static int editarReservaWS(ws.ReservaBean reserva) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.editarReserva(reserva);
    }

    private static ReservaBean consultarPorIdReservaWS(int id) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.consultarPorIdReserva(id);
    }

    private static String deletarReservaWS(int id) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.deletarReserva(id);
    }

    private static java.util.List<ws.ReservaBean> consultarPorNomeReservaWS(java.lang.String nome) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.consultarPorNomeReserva(nome);
    }

    private static java.util.List<ws.ReservaBean> selectAllReservaWS() {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.selectAllReserva();
    }

    private static String olaReservaWS() {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.olaReserva();
    }

    public int  inserir(ReservaBean res){
        return inserirReservaWS(res);
    }

    public int  editar(ReservaBean res){
        return editarReservaWS(res);
    }

    public ReservaBean consultarPorId(int id){
        return consultarPorIdReservaWS(id);
    }

    public String deletar(int id) {
        return deletarReservaWS(id);
    }

    public List<ReservaBean> consultarPorNome(String nome) {
        return consultarPorNomeReservaWS(nome);
    }

    public List<ReservaBean> selectAll() {
        return selectAllReservaWS();
    }

    public String Ola() {
        return olaReservaWS();
    }

}
