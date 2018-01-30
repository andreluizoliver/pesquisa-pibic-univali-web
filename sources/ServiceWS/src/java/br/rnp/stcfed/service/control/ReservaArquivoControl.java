/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rnp.stcfed.service.control;

import br.rnp.sctfed.service.dao.ReservaDao;
import br.rnp.stcfed.service.bean.ReservaBean;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class ReservaArquivoControl {

    ReservaDao dao = null;
    private ArrayList<ReservaBean> resList = new ArrayList<ReservaBean>();

    public ReservaArquivoControl() {
    }

    public void delete(int id) throws SQLException {

        lerDoArquivo();

        for (int i = 0; i < resList.size(); i++) {
            if (resList.get(i).getIdReserva() == id) {
                resList.remove(resList.get(i));
            }
        }

        salvaEmArquivo();

    }

    public int insert(ReservaBean res) throws SQLException {

        int idAux = 1;

        salvaEmArquivo();

        lerDoArquivo();

        if (!resList.isEmpty()) {
            idAux = resList.get(resList.size() - 1).getIdReserva() + 1;
        }

        res.setIdReserva(idAux);

        resList.add(res);

        salvaEmArquivo();

        return idAux;
    }

    public ArrayList<ReservaBean> selectAll() throws SQLException {

        lerDoArquivo();

        return resList;
    }

    public ReservaBean selectPorId(int id) throws SQLException {

        ReservaBean aco = null;

        lerDoArquivo();

        for (ReservaBean acom : resList) {
            if (acom.getIdReserva() == id) {
                return acom;
            }
        }

        return aco;
    }

    public ArrayList<ReservaBean> selectPorNome(String descricao) throws SQLException {

        ArrayList<ReservaBean> acoss = new ArrayList<ReservaBean>();

        lerDoArquivo();

        for (ReservaBean acom : resList) {
            if (acom.getNome().equals(descricao)) {
                acoss.add(acom);
            }
        }

        return acoss;
    }

    public int update(ReservaBean res) throws SQLException {

        lerDoArquivo();

        for (int i = 0; i < resList.size(); i++) {
            if (resList.get(i).getIdReserva() == res.getIdReserva()) {
                resList.add(i, res);
            }
        }

        salvaEmArquivo();

        return -1;
    }

    public void salvaEmArquivo() {
        try {
            FileOutputStream out = new FileOutputStream("resList.dad");
            ObjectOutputStream objectout = new ObjectOutputStream(out);
            objectout.writeObject(resList);
            objectout.close();
            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void lerDoArquivo() {
        try {
            FileInputStream in = new FileInputStream("resList.dad");
            ObjectInputStream objectIn = new ObjectInputStream(in);
            resList = (ArrayList<ReservaBean>) objectIn.readObject();
            objectIn.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int mostrar() throws SQLException {

        lerDoArquivo();

        for(ReservaBean com : resList){
            System.out.println("id-"+com.getIdReserva()+"  Nome:"+com.getNome());
        }

        return -1;
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        ReservaBean res = new ReservaBean();
        res.setEmail("00000@gmail.com");
        res.setIdReserva(1);
        res.setNome("Thais");
        res.setNrPessoas(3);
        res.setObs("obsThais");
        res.setTelefone("0000000");

        ReservaArquivoControl rc = new ReservaArquivoControl();
        rc.insert(res);
        rc.mostrar();

        ReservaControl ws = new ReservaControl();
        int i = ws.insert(res);
    }
}
