/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rnp.stcfed.service.control;


import br.rnp.stcfed.service.bean.AcomodacaoBean;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre Luiz
 */
public class AcomodacaoArquivoControl {

    private ArrayList<AcomodacaoBean> acomList = new ArrayList<AcomodacaoBean>();

    public AcomodacaoArquivoControl() {

         acomList = new ArrayList<AcomodacaoBean>();
         
         AcomodacaoBean aco1 = new AcomodacaoBean(1, "Jupter", "Master", "N", "S", "N", "S", "N", "S", "N", "S");
         AcomodacaoBean aco2 = new AcomodacaoBean(2, "Marte", "Super", "S", "S", "N", "S", "N", "S", "N", "S");
         AcomodacaoBean aco3 = new AcomodacaoBean(3, "Lua", "Hiper", "N", "S", "S", "S", "N", "S", "N", "S");
         AcomodacaoBean aco4 = new AcomodacaoBean(4, "Sol", "hiper", "S", "S", "N", "S", "N", "S", "N", "S");
         AcomodacaoBean aco5 = new AcomodacaoBean(5, "Plutão", "Master", "N", "S", "S", "S", "N", "S", "S", "S");
        
        try {

            this.delete(aco1.getIdAcomodacao());
            this.delete(aco2.getIdAcomodacao());
            this.delete(aco3.getIdAcomodacao());
            this.delete(aco4.getIdAcomodacao());
            this.delete(aco5.getIdAcomodacao());

            this.insert(aco1);
            this.insert(aco2);
            this.insert(aco3);
            this.insert(aco4);
            this.insert(aco5);
        } catch (SQLException ex) {
            Logger.getLogger(AcomodacaoArquivoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) throws SQLException {

        lerDoArquivo();

        for (int i=0;i<acomList.size();i++) {
            if (acomList.get(i).getIdAcomodacao() == id) {
                acomList.remove(acomList.get(i));
            }
        }

        salvaEmArquivo();
    }

    public int insert(AcomodacaoBean acom) throws SQLException{

        int idAux = 1;

        lerDoArquivo();

        if (!acomList.isEmpty()) {
            idAux = acomList.get(acomList.size() - 1).getIdAcomodacao() + 1;
        }

        acom.setIdAcomodacao(idAux);

        acomList.add(acom);

        salvaEmArquivo();

        return idAux;


    }

    public ArrayList<AcomodacaoBean> selectAll() throws SQLException {

        lerDoArquivo();

        return acomList;
    }

    public AcomodacaoBean selectPorId(int id) throws SQLException{
        AcomodacaoBean aco = null;

        lerDoArquivo();

        for (AcomodacaoBean acom : acomList) {
            if (acom.getIdAcomodacao() == id) {
                return acom;
            }
        }

        return aco;
    }

    public ArrayList<AcomodacaoBean> selectPorNome(String descricao) throws SQLException {

        ArrayList<AcomodacaoBean> acoss = new ArrayList<AcomodacaoBean>();

        lerDoArquivo();

        for (AcomodacaoBean acom : acomList) {
            if (acom.getDescricao().equals(descricao)) {
                acoss.add(acom);
            }
        }

        return acoss;

    }

    public int update(AcomodacaoBean acom) throws SQLException {

        lerDoArquivo();

        for (int i = 0; i < acomList.size(); i++) {
            if (acomList.get(i).getIdAcomodacao() == acom.getIdAcomodacao()) {
                acomList.add(i, acom);
            }
        }

        salvaEmArquivo();
        
        return -1;
    }

    public int mostrar() throws SQLException {

        lerDoArquivo();

        for(AcomodacaoBean com : acomList){
            System.out.println("id-"+com.getIdAcomodacao()+"  Descricao:"+com.getDescricao());
        }

        return -1;
    }

    public void salvaEmArquivo() {
        try {
            FileOutputStream out = new FileOutputStream("acomLista.dad");
            ObjectOutputStream objectout = new ObjectOutputStream(out);
            objectout.writeObject(acomList);
            objectout.close();
            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void lerDoArquivo() {
        try {
            FileInputStream in = new FileInputStream("acomLista.dad");
            ObjectInputStream objectIn = new ObjectInputStream(in);
            acomList = (ArrayList<AcomodacaoBean>) objectIn.readObject();
            objectIn.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
//        AcomodacaoBean aco = new AcomodacaoBean(1, null, null, null, null, null, null, null, null, null, null);
//        aco.setDescricao("descricao teste 4 ");
//        //aco.setIdAcomodacao(7);
//        aco.setLvArcondicionado("S");
//        aco.setLvCafe("N");
//        aco.setLvCozinha("S");
//        aco.setLvHidro("N");
//        aco.setLvKitpraia("S");
//        aco.setLvSacada("N");
//        aco.setLvSauna("S");
//        aco.setLvTv("N");
//        aco.setNmAcomodacao("TESTES 4");
//
//        AcomodacaoArquivoControl ac = new AcomodacaoArquivoControl();
//        ac.insert(aco);
//        ac.delete(1);
//
//
//        //ac.mostrar();
//       //ac.delete(3);
//        List<AcomodacaoBean> list = new ArrayList<AcomodacaoBean>();
//        list = ac.selectAll();
//        for(AcomodacaoBean com : list){
//            System.out.println("id-"+com.getIdAcomodacao()+"  Descricao:"+com.getDescricao());
//        }
//        //ac.mostrar();
//
//        // AcomodacaoControl ws = new AcomodacaoControl();
//        //int  i =ws.insert(aco);
//        //List<AcomodacaoBean> list = new ArrayList<AcomodacaoBean>();
//        //list = ws.selectAll();
//        // for (AcomodacaoBean aco1 : list) {
//        //System.out.println(aco1.getNmAcomodacao());
//        // }
    }
}
