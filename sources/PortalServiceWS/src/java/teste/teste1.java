/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import ws.AcomodacaoBean;
import control.AcomodacaoControl;
import control.ReservaControl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.DataUtil;
import ws.ReservaBean;
import ws.ServiceWSService;

/**
 *
 * @author Andre
 */
public class teste1 {

     public static void main(String arg[]) throws ClassNotFoundException, SQLException{

        ReservaBean res1 = new ReservaBean();
        res1.setEmail("juliana@gmail.com");
        res1.setIdReserva(3);
        res1.setNome("Juliana da luiz");
        res1.setNrPessoas(3);
        res1.setObs("obs luiz e ju");
        res1.setTelefone("1258-8521");

        ReservaBean res2 = new ReservaBean();
        res2.setEmail("manoel@gmail.com");
        res2.setIdReserva(5);
        res2.setNome("Manoel Luiz de Dutra");
        res2.setNrPessoas(5);
        res2.setObs("obs 7");
        res2.setTelefone("1235-8523");

        ReservaBean res3 = new ReservaBean();
        //res3.setEmail("juca@gmail.com");
        //res3.setIdReserva(78);
        res3.setNome("Joaquim da Silva");
        res3.setNrPessoas(45);
        //res3.setObs("todos da familia");
       // res3.setTelefone("1254-5213");
        //res3.setDtEntrada(DataUtil.dateToXMLGregorianCalendar(DataUtil.stringToDate("03/01/2010 02:01")));
        //res3.setDtSaida(DataUtil.dateToXMLGregorianCalendar(DataUtil.stringToDate("12/07/1999 10:08")));

        AcomodacaoControl rc = new AcomodacaoControl();
        //rc.inserir(res1);
        //rc.inserir(res2);
        /*ReservaBean res = rc.consultarPorId(6);
        System.out.println(res.getIdReserva());
        System.out.println(res.getNome());*/
        //List<AcomodacaoBean> lsReserva = new ArrayList<AcomodacaoBean>();
        //lsReserva = rc.consultarPorNome("Luiz");

       // int i = rc.inserir(res3);
        //System.out.println(i);
        List<AcomodacaoBean> lsReserva = rc.consultarPorNome("J");

        for(AcomodacaoBean res : lsReserva){

            System.out.println(res.getIdAcomodacao()+"-"+ res.getNmAcomodacao());
        }

        //Date dt = DataUtil.stringToDate("03/01/2010 02:01");
        //System.out.println(DataUtil.dateToString(dt));

        //AcomodacaoBean aco = rc.consultarPorId(2);
        //System.out.println(aco.getNmAcomodacao());



    }

}
