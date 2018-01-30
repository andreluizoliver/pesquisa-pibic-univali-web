/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rnp.stcfed.service.control;

import br.rnp.sctfed.service.dao.AcomodacaoDao;
import br.rnp.stcfed.service.bean.AcomodacaoBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre Luiz
 */
public class AcomodacaoControl {

    AcomodacaoDao dao = null;

    public AcomodacaoControl() throws ClassNotFoundException {
        dao = new AcomodacaoDao();
    }

    public void delete(int id) throws SQLException {

        Connection conn = null;


        try {
            conn = dao.getConnection();
            conn.setAutoCommit(false);

            dao.delete(conn, id);
            conn.commit();

        } catch (Throwable e) {

            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } finally {

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            conn = null;
        }

    }

    public int insert(AcomodacaoBean res) throws SQLException {

        Connection conn = null;
        int pkProduto = -1;
        try {
            conn = dao.getConnection();
            conn.setAutoCommit(false);

            pkProduto = dao.insert(conn, res);

            if (pkProduto != 0) {

                conn.commit();
            } else {
                throw new Exception("Erro ao recuperar o valor do sequence.");
            }
        } catch (Throwable e) {

            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } finally {

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            conn = null;
        }
        return pkProduto;
    }

    public ArrayList<AcomodacaoBean> selectAll() throws SQLException {

        Connection conn = null;
        ArrayList<AcomodacaoBean> lista = null;

        try {
            conn = dao.getConnection();
            conn.setAutoCommit(false);

            lista = dao.selectAll(conn);
            conn.commit();
        } catch (Throwable e) {

            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } finally {

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            conn = null;
        }

        return lista;
    }

    public AcomodacaoBean selectPorId(int id) throws SQLException {

        Connection conn = null;
        AcomodacaoBean res = null;

        try {
            conn = dao.getConnection();
            conn.setAutoCommit(false);

            res = dao.selectPorId(conn, id);
            conn.commit();
        } catch (Throwable e) {

            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } finally {

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            conn = null;
        }

        return res;
    }

    public ArrayList<AcomodacaoBean> selectPorNome(String descricao) throws SQLException {

        Connection conn = null;
        ArrayList<AcomodacaoBean> lista = null;

        try {
            conn = dao.getConnection();
            conn.setAutoCommit(false);

            lista = dao.selectPorNome(conn, descricao);
            conn.commit();
        } catch (Throwable e) {

            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } finally {

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            conn = null;
        }

        return lista;
    }

    public int update(AcomodacaoBean res) throws SQLException {

        Connection conn = null;
        int id = 0;
        try {
            conn = dao.getConnection();
            conn.setAutoCommit(false);

            id = dao.update(conn, res);
            conn.commit();
        } catch (Throwable e) {

            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } finally {

            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            conn = null;
        }

        return id;
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        AcomodacaoBean aco = new AcomodacaoBean();
        aco.setDescricao("descricao teste 1 ");
        aco.setIdAcomodacao(7);
        aco.setLvArcondicionado("S");
        aco.setLvCafe("N");
        aco.setLvCozinha("S");
        aco.setLvHidro("N");
        aco.setLvKitpraia("S");
        aco.setLvSacada("N");
        aco.setLvSauna("S");
        aco.setLvTv("N");
        aco.setNmAcomodacao("TESTES 1");

        //ReservaControl rc = new ReservaControl();
        //rc.insert(res);

        AcomodacaoControl ws = new AcomodacaoControl();
        //int  i =ws.insert(aco);
        List<AcomodacaoBean> list = new ArrayList<AcomodacaoBean>();
        list = ws.selectAll();
        for (AcomodacaoBean aco1 : list) {
            System.out.println(aco1.getNmAcomodacao());
        }
    }
}
