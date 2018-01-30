/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import ws.AcomodacaoBean;
import control.AcomodacaoControl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Andre
 */
public class AcomodacaoMB implements Serializable {

    private AcomodacaoBean acomodacao;
    private AcomodacaoControl acomodacaoControl;
    private List<AcomodacaoBean> listaAcomodacao;
    private List<SelectItem> itensAcomodacao;
    private String selecaoAcomodacao;

    public AcomodacaoMB() {
        System.out.println(" >>>>>>>>>>>>>>>>>>>> Contrutor do Acomodacao <<<<<<<<<<<<<<<<<<");
        acomodacao = new AcomodacaoBean();
        acomodacaoControl = new AcomodacaoControl();
        listaAcomodacao = acomodacaoControl.selectAll();
        //acomodacao = acomodacaoControl.consultarPorId(2);

    }

    public AcomodacaoBean getAcomodacao() {
        return acomodacao;
    }

    public List<SelectItem> getItensAcomodacao(){

         List<SelectItem> itens = new ArrayList<SelectItem>(listaAcomodacao.size());

         for(AcomodacaoBean p : listaAcomodacao){
         itens.add(new SelectItem(p.getNmAcomodacao(),p.getNmAcomodacao(),p.getDescricao(),true));
         }
         return itens;
    }

    public String buscarAcomodacao() {
        List<AcomodacaoBean> listAco = acomodacaoControl.consultarPorNome(acomodacao.getNmAcomodacao());
        if(listAco.size()>0){
            acomodacao = listAco.get(0);
        }
        return "acomodacao";
        //acomodacao = new AcomodacaoBean();
        //acomodacao = acomodacaoControl.consultarPorId(2);
    }



    public void setAcomodacao(AcomodacaoBean acomodacao) {
        this.acomodacao = acomodacao;
    }

    public AcomodacaoControl getAcomodacaoControl() {
        return acomodacaoControl;
    }

    public void setAcomodacaoControl(AcomodacaoControl acomodacaoControl) {
        this.acomodacaoControl = acomodacaoControl;
    }

    public List<AcomodacaoBean> getListaAcomodacao() {
        return listaAcomodacao;
    }

    public void setListaAcomodacao(List<AcomodacaoBean> listaAcomodacao) {
        this.listaAcomodacao = listaAcomodacao;
    }

    public void setItensAcomodacao(List<SelectItem> itensAcomodacao) {
        this.itensAcomodacao = itensAcomodacao;
    }

    public String getSelecaoAcomodacao() {
        return selecaoAcomodacao;
    }

    public void setSelecaoAcomodacao(String selecaoAcomodacao) {
        this.selecaoAcomodacao = selecaoAcomodacao;
    }


}
