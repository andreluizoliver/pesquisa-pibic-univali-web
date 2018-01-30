/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import br.rnp.stcfed.service.bean.AcomodacaoBean;
import br.rnp.stcfed.service.bean.ReservaBean;
import br.rnp.stcfed.service.control.ReservaControl;
import br.rnp.stcfed.service.ws.AcomodacaoWS;
import br.rnp.stcfed.service.ws.ReservaWS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Teste1 {

    public static void main(String arg[]) throws ClassNotFoundException, SQLException{

        ReservaBean res = new ReservaBean();
        res.setEmail("00000@gmail.com");
        res.setIdReserva(1);
        res.setNome("Thais");
        res.setNrPessoas(3);
        res.setObs("obsThais");
        res.setTelefone("0000000");

        //ReservaControl rc = new ReservaControl();
        //rc.insert(res);

        AcomodacaoWS ws = new AcomodacaoWS();
        //ws.inserir(res);
        //ReservaBean res2 =
          //      ws.consultarPorId(6);
        
        //List<ReservaBean> lt =
                //ws.consultarPorNome("Faus");
          //      ws.selectAll();
        
        //int editar = ws.editar(res);

        //ws.deletar(6);
        List<AcomodacaoBean> list = new ArrayList<AcomodacaoBean>();
        list = ws.selectAllAcomodacao();

        for(AcomodacaoBean aco : list){
            System.out.println(aco.getNmAcomodacao());
        }

        //ReservaBean res2 = ws.consultarPorId(8);
        //System.out.println(res2.getDtEntrada());
        //System.out.println(res2.getDtSaida());


        //System.out.println("ok");



    }

}
