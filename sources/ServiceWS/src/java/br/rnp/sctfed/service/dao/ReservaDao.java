/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rnp.sctfed.service.dao;

import br.rnp.sctfed.service.util.DataUtil;
import br.rnp.stcfed.service.bean.ReservaBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Andre
 */
public class ReservaDao extends Conexao {

    public ReservaDao() throws ClassNotFoundException {
        super();
    }

    public int insert(Connection conn, ReservaBean res) throws SQLException {

        Statement st = null;
        ResultSet rs = null;
        int pk = 0;

        try {

            st = conn.createStatement();
            rs = st.executeQuery("SELECT nextval('seq_reserva') as pk");

            if (rs.next()) {
                pk = rs.getInt("pk");
            }

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO reserva VALUES ( ").append(pk);
            sql.append(",'" + res.getNome() + "'");
            sql.append(",'" + res.getTelefone() + "'");
            sql.append(",'" + res.getEmail() + "'");
            sql.append("," + res.getNrPessoas());
            sql.append(",'" + DataUtil.stringTostringDB(res.getDtEntrada()) + "'");
            sql.append(",'" + DataUtil.stringTostringDB(res.getDtSaida()) + "'");
            sql.append(",'" + res.getObs() + "'");
            sql.append(",'" + res.getCrianca() + "'");
            sql.append("," + res.getAcomodacao().getIdAcomodacao() + ")");
            st.executeUpdate(sql.toString());


        } finally {
            try {
                st.close();
                rs.close();
                st = null;
                rs = null;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pk;

    }

    public int update(Connection conn, ReservaBean res) throws SQLException {

        Statement st = null;
        int pk = 0;

        try {
            st = conn.createStatement();

            StringBuffer sql = new StringBuffer();
            sql.append("UPDATE reserva SET ");
            sql.append("nome = '" + res.getNome() + "',");
            sql.append("telefone = '" + res.getTelefone() + "',");
            sql.append("email = '" + res.getEmail() + "',");
            sql.append("nr_pessoas = " + res.getNrPessoas() + ",");
            sql.append("dt_entrada = '" + DataUtil.stringTostringDB(res.getDtEntrada()) + "',");
            sql.append("dt_saida = '" + DataUtil.stringTostringDB(res.getDtSaida()) + "',");
            sql.append("obs = '" + res.getObs() + "'");
            sql.append("lv_crianca = '" + res.getCrianca() + "'");
            sql.append("id_acomodacao = " + res.getAcomodacao().getIdAcomodacao());
            sql.append(" WHERE id_reserva = " + res.getIdReserva());
            st.executeUpdate(sql.toString());
            pk = res.getIdReserva();
        } finally {
            try {
                st.close();
                st = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pk;
    }

    public ReservaBean selectPorId(Connection conn, int id) throws SQLException {

        ReservaBean res = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            st = conn.createStatement();

            String sql = "Select * from reserva where id_reserva =" + id;
            rs = st.executeQuery(sql);

            if (rs.next()) {
                res = new ReservaBean();
                res.setIdReserva(rs.getInt("id_reserva"));
                res.setNome(rs.getString("nome"));
                res.setTelefone(rs.getString("telefone"));
                res.setEmail(rs.getString("email"));
                res.setNrPessoas(rs.getInt("nr_pessoas"));
                res.setDtEntrada(DataUtil.dateToString(rs.getDate("dt_entrada")));
                res.setDtSaida(DataUtil.dateToString(rs.getDate("dt_saida")));
                res.setObs(rs.getString("obs"));
                res.setCrianca(rs.getString("lv_crianca"));
            }
        } finally {
            try {
                st.close();
                rs.close();
                rs = null;
                st = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return res;
    }

    public int delete(Connection conn, int id) throws SQLException {

        Statement st = null;
        int idReserva = 0;

        try {
            st = conn.createStatement();

            String sql = "DELETE FROM reserva WHERE id_reserva = " + id;
            st.executeUpdate(sql);
            idReserva = id;
        } finally {
            try {
                st.close();
                st = null;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idReserva;
    }

    public ArrayList<ReservaBean> selectPorNome(Connection conn, String descricao) throws Exception {

        ReservaBean res = null;
        ArrayList<ReservaBean> lista = null;
        ResultSet rs = null;
        Statement st = null;

        try {

            st = conn.createStatement();

            String sql = "Select * from reserva where nome LIKE '%" + descricao + "%'";
            rs = st.executeQuery(sql);
            lista = new ArrayList<ReservaBean>();
            while (rs.next()) {
                res = new ReservaBean();
                res.setIdReserva(rs.getInt("id_reserva"));
                res.setNome(rs.getString("nome"));
                res.setTelefone(rs.getString("telefone"));
                res.setEmail(rs.getString("email"));
                res.setNrPessoas(rs.getInt("nr_pessoas"));
                res.setDtEntrada(DataUtil.dateToString(rs.getDate("dt_entrada")));
                res.setDtSaida(DataUtil.dateToString(rs.getDate("dt_saida")));
                res.setObs(rs.getString("obs"));
                res.setCrianca(rs.getString("lv_crianca"));
                lista.add(res);
            }
        } finally {
            try {
                st.close();
                rs.close();
                rs = null;
                st = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return lista;
    }

    public ArrayList<ReservaBean> selectAll(Connection conn) throws SQLException {
        ReservaBean res = null;
        ArrayList<ReservaBean> lista = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            st = conn.createStatement();

            String sql = "Select * from reserva";
            rs = st.executeQuery(sql);
            lista = new ArrayList<ReservaBean>();
            while (rs.next()) {
                res = new ReservaBean();
                res.setIdReserva(rs.getInt("id_reserva"));
                res.setNome(rs.getString("nome"));
                res.setTelefone(rs.getString("telefone"));
                res.setEmail(rs.getString("email"));
                res.setNrPessoas(rs.getInt("nr_pessoas"));
                res.setDtEntrada(DataUtil.dateToString(rs.getDate("dt_entrada")));
                res.setDtSaida(DataUtil.dateToString(rs.getDate("dt_saida")));
                res.setObs(rs.getString("obs"));
                res.setCrianca(rs.getString("lv_crianca"));
                lista.add(res);
            }
        } finally {
            try {
                st.close();
                rs.close();
                rs = null;
                st = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return lista;
    }
}
