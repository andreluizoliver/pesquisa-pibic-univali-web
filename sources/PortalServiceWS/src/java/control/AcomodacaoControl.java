/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.List;
import ws.AcomodacaoBean;

/**
 *
 * @author Andre Luiz
 */
public class AcomodacaoControl {

    private static int inserirAcomodacaoWS(ws.AcomodacaoBean reserva) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.inserirAcomodacao(reserva);
    }

    private static int editarAcomodacaoWS(ws.AcomodacaoBean reserva) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.editarAcomodacao(reserva);
    }

    private static AcomodacaoBean consultarPorIdAcomodacaoWS(int id) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.consultarPorIdAcomodacao(id);
    }

    private static String deletarAcomodacaoWS(int idAcomodacao) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.deletarAcomodacao(idAcomodacao);
    }

    private static java.util.List<ws.AcomodacaoBean> consultarPorNomeAcomodacaoWS(java.lang.String nome) {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.consultarPorNomeAcomodacao(nome);
    }

    private static java.util.List<ws.AcomodacaoBean> selectAllAcomodacaoWS() {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.selectAllAcomodacao();
    }

    private static String olaAcomodacaoWS() {
        ws.ServiceWSService service = new ws.ServiceWSService();
        ws.ServiceWS port = service.getServiceWSPort();
        return port.olaAcomodacao();
    }

    public int  inserir(AcomodacaoBean res){
        return inserirAcomodacaoWS(res);
    }

    public int  editar(AcomodacaoBean res){
        return editarAcomodacaoWS(res);
    }


    public AcomodacaoBean consultarPorId(int id){
        return consultarPorIdAcomodacaoWS(id);
    }


    public List<AcomodacaoBean> consultarPorNome(String nome) {
        return consultarPorNomeAcomodacaoWS(nome);
    }


    public List<ws.AcomodacaoBean> selectAll() {
        return selectAllAcomodacaoWS();
    }


    public String deletar(int id) {
        return deletarAcomodacaoWS(id);
    }


    public String Ola() {
        return olaAcomodacaoWS();
    }

}
