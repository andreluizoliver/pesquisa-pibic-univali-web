/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import control.ReservaControl;
import java.util.ArrayList;
import java.util.List;
import ws.ReservaBean;

/**
 *
 * @author Andre Luiz
 */
public class teste2 {

    public static void main(String args[]){

        ReservaBean res1 = new ReservaBean();
        ReservaControl ctr = new ReservaControl();
        List<ReservaBean> lsReserva = new ArrayList<ReservaBean>();

        res1.setEmail("modjosimeri@gmail.com");
        res1.setIdReserva(18);
        res1.setNome("modJosimeri");
        res1.setNrPessoas(111);
        res1.setObs("modobsjosi");
        res1.setTelefone("1111-3831");
        res1.setDtEntrada("11/11/2011 11:45");
        res1.setDtSaida("22/11/2011 22:03");

        ReservaBean res2 = ctr.consultarPorId(12);
        if(res2!=null)
            lsReserva.add(res2);
        for(ReservaBean res : lsReserva){
            System.out.println(res.getIdReserva()+"-"+res.getNome()+"-"+res.getDtEntrada()+"-"+res.getDtSaida());
        }


    }

}
