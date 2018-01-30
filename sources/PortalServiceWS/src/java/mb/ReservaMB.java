/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import bean.Data;
import control.AcomodacaoControl;
import control.ReservaControl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import ws.AcomodacaoBean;
import util.DataUtil;
import ws.ReservaBean;

/**
 *
 * @author Andre
 */
public class ReservaMB implements Serializable {

    private static final long serialVersionUID = -333995781063775201L;
    private ReservaBean reserva;
    private ReservaControl reservaControl;
    private List<ReservaBean> listaReserva;
    private Data dataEntrada;
    private Data dataSaida;
    private Date dtEntrada;
    private Date dtSaida;


    private AcomodacaoControl acomodacaoControl;
    private List<AcomodacaoBean> listaAcomodacao;
    private List<SelectItem> itensAcomodacao;
    private String nomeAcomodacao;


    public ReservaMB(){
        System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do Reserva <<<<<<<<<<<<<<<<<<");
        reserva = new ReservaBean();
        reservaControl = new ReservaControl();
        acomodacaoControl = new AcomodacaoControl();
        listaReserva = reservaControl.selectAll();
        listaAcomodacao = acomodacaoControl.selectAll();
        dataEntrada = new Data();
        dataSaida = new Data();
    }

    public List<SelectItem> getItensAcomodacao(){

         List<SelectItem> itens = new ArrayList<SelectItem>(listaAcomodacao.size());

         for(AcomodacaoBean p : listaAcomodacao){
         itens.add(new SelectItem(p.getNmAcomodacao(),p.getNmAcomodacao(),p.getDescricao(),true));
         }
         return itens;
    }

    public String inserir(){
        List<AcomodacaoBean> listAco = acomodacaoControl.consultarPorNome(nomeAcomodacao);
        if(listAco.size()>0){
            reserva.setAcomodacao(listAco.get(0));
        }
        reserva.setDtEntrada(DataUtil.DataToStringView(dataEntrada));
        reserva.setDtSaida(DataUtil.DataToStringView(dataSaida));


        int id = reservaControl.inserir(reserva);
        reserva = new ReservaBean();
        dataEntrada = new Data();
        dataSaida = new Data();
        listaReserva = reservaControl.selectAll();
        if(id!=-1){
            System.out.println(" >>>>>>>>>>>>>>>>>>>> Reserva Inserida <<<<<<<<<<<<<<<<<<");
            return "index";
        }else{
            System.out.println(" >>>>>>>>>>>>>>>>>>>> ERRO - Reserva Não Inserida <<<<<<<<<<<<<<<<<<");
            return "index";
        }
    }
    /*
    public void editar(){
        if(this.reservaControl.editar(this.reserva)!=-1)
            System.out.println(" >>>>>>>>>>>>>>>>>>>> Reserva Editada <<<<<<<<<<<<<<<<<<");
        else
            System.out.println(" >>>>>>>>>>>>>>>>>>>> ERRO - Reserva Não Editada <<<<<<<<<<<<<<<<<<");
    }

    public void consultarPorId(){
        if(this.reservaControl.consultarPorId(this.reserva.getIdReserva())!=null)
            System.out.println(" >>>>>>>>>>>>>>>>>>>> Reserva OK <<<<<<<<<<<<<<<<<<");
        else
            System.out.println(" >>>>>>>>>>>>>>>>>>>> ERRO - Reserva Não Encontradas <<<<<<<<<<<<<<<<<<");
    }

    public void deletar(){
        if(this.reservaControl.deletar(this.reserva.getIdReserva())!=null)
            System.out.println(" >>>>>>>>>>>>>>>>>>>> Reserva Excluido <<<<<<<<<<<<<<<<<<");
        else
            System.out.println(" >>>>>>>>>>>>>>>>>>>> ERRO - Reserva Não Excluida <<<<<<<<<<<<<<<<<<");
    }

    public void consultarPorNome(String nome){
        this.lista = this.reservaControl.consultarPorNome(this.reserva.getNome());
        if(this.lista!=null)
            System.out.println(" >>>>>>>>>>>>>>>>>>>> Reserva OK <<<<<<<<<<<<<<<<<<");
        else
            System.out.println(" >>>>>>>>>>>>>>>>>>>> ERRO - Reserva Não Encontradas <<<<<<<<<<<<<<<<<<");

    }

    public void selectAll(){
        this.lista = this.reservaControl.selectAll();
        if(this.lista!=null)
            System.out.println(" >>>>>>>>>>>>>>>>>>>> Reserva OK <<<<<<<<<<<<<<<<<<");
        else
            System.out.println(" >>>>>>>>>>>>>>>>>>>> ERRO - Reserva Não Encontradas <<<<<<<<<<<<<<<<<<");

    }*/

    public ReservaBean getReserva() {
        return reserva;
    }

    public void setReserva(ReservaBean reserva) {
        this.reserva = reserva;
    }

    public List<ReservaBean> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<ReservaBean> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public ReservaControl getReservaControl() {
        return reservaControl;
    }

    public void setReservaControl(ReservaControl reservaControl) {
        this.reservaControl = reservaControl;
    }

    public Data getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Data dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Data getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Data dataSaida) {
        this.dataSaida = dataSaida;
    }

    public AcomodacaoControl getAcomodacaoControl() {
        return acomodacaoControl;
    }

    public void setAcomodacaoControl(AcomodacaoControl acomodacaoControl) {
        this.acomodacaoControl = acomodacaoControl;
    }

    public void setItensAcomodacao(List<SelectItem> itensAcomodacao) {
        this.itensAcomodacao = itensAcomodacao;
    }

    public List<AcomodacaoBean> getListaAcomodacao() {
        return listaAcomodacao;
    }

    public void setListaAcomodacao(List<AcomodacaoBean> listaAcomodacao) {
        this.listaAcomodacao = listaAcomodacao;
    }

    public String getNomeAcomodacao() {
        return nomeAcomodacao;
    }

    public void setNomeAcomodacao(String nomeAcomodacao) {
        this.nomeAcomodacao = nomeAcomodacao;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }



}
