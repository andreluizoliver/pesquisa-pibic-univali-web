/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rnp.sctfed.service.dao;

import br.rnp.stcfed.service.bean.AcomodacaoBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andre Luiz
 */
public class AcomodacaoDao extends Conexao {

    public AcomodacaoDao() throws ClassNotFoundException {
        super();
    }

    public int insert(Connection conn, AcomodacaoBean aco) throws SQLException {

        Statement st = null;
        ResultSet rs = null;
        int pk = 0;

        try {

            st = conn.createStatement();
            rs = st.executeQuery("SELECT nextval('seq_acomodacao') as pk");

            if (rs.next()) {
                pk = rs.getInt("pk");
            }

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO acomodacao VALUES ( ").append(pk);
            sql.append(",'" + aco.getLvSacada() + "'");
            sql.append(",'" + aco.getLvCozinha() + "'");
            sql.append(",'" + aco.getLvHidro() + "'");
            sql.append(",'" + aco.getLvKitpraia() + "'");
            sql.append(",'" + aco.getLvTv() + "'");
            sql.append(",'" + aco.getLvCafe() + "'");
            sql.append(",'" + aco.getLvSauna() + "'");
            sql.append(",'" + aco.getLvArcondicionado() + "'");
            sql.append(",'" + aco.getNmAcomodacao() + "'");
            sql.append(",'" + aco.getDescricao() + "')");
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

    public int update(Connection conn, AcomodacaoBean aco) throws SQLException {

        Statement st = null;
        int pk = 0;

        try {
            st = conn.createStatement();

            StringBuffer sql = new StringBuffer();
            sql.append("UPDATE acomodacao SET ");
            sql.append("lv_sacada = '" + aco.getLvSacada() + "',");
            sql.append("lv_cozinha = '" + aco.getLvCozinha() + "',");
            sql.append("lv_hidro = '" + aco.getLvHidro() + "',");
            sql.append("lv_kitpraia = '" + aco.getLvKitpraia() + "',");
            sql.append("lv_tv = '" + aco.getLvTv() + "',");
            sql.append("lv_cafe = '" + aco.getLvCafe() + "',");
            sql.append("lv_sauna = '" + aco.getLvSauna() + "',");
            sql.append("lv_arcondicionado = '" + aco.getLvArcondicionado() + "',");
            sql.append("nm_acomodacao = '" + aco.getNmAcomodacao() + "',");
            sql.append("descricao = '" + aco.getDescricao() + "'");
            sql.append(" WHERE id_acomodacao = " + aco.getIdAcomodacao());
            st.executeUpdate(sql.toString());
            pk = aco.getIdAcomodacao();
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

    public AcomodacaoBean selectPorId(Connection conn, int id) throws SQLException {

        AcomodacaoBean aco = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            st = conn.createStatement();

            String sql = "Select * from acomodacao where id_acomodacao =" + id;
            rs = st.executeQuery(sql);

            if (rs.next()) {
                aco = new AcomodacaoBean();
                aco.setIdAcomodacao(id);
                aco.setLvSacada(rs.getString("lv_sacada"));
                aco.setLvCozinha(rs.getString("lv_cozinha"));
                aco.setLvHidro(rs.getString("lv_hidro"));
                aco.setLvKitpraia(rs.getString("lv_kitpraia"));
                aco.setLvTv(rs.getString("lv_tv"));
                aco.setLvCafe(rs.getString("lv_cafe"));
                aco.setLvSauna(rs.getString("lv_sauna"));
                aco.setLvArcondicionado(rs.getString("lv_arcondicionado"));
                aco.setNmAcomodacao(rs.getString("nm_acomodacao"));
                aco.setDescricao(rs.getString("descricao"));
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
        return aco;
    }

    public int delete(Connection conn, int id) throws SQLException {

        Statement st = null;
        int idAcomodacao = 0;

        try {
            st = conn.createStatement();

            String sql = "DELETE FROM acomodacao WHERE id_acomodacao = " + id;
            st.executeUpdate(sql);
            idAcomodacao = id;
        } finally {
            try {
                st.close();
                st = null;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idAcomodacao;
    }

    public ArrayList<AcomodacaoBean> selectPorNome(Connection conn, String descricao) throws Exception {

        AcomodacaoBean aco = null;
        ArrayList<AcomodacaoBean> lista = null;
        ResultSet rs = null;
        Statement st = null;

        try {

            st = conn.createStatement();

            String sql = "Select * from acomodacao where nm_acomodacao LIKE '%" + descricao + "%'";
            rs = st.executeQuery(sql);
            lista = new ArrayList<AcomodacaoBean>();
            while (rs.next()) {
                aco = new AcomodacaoBean();
                aco.setIdAcomodacao(rs.getInt("id_acomodacao"));
                aco.setLvSacada(rs.getString("lv_sacada"));
                aco.setLvCozinha(rs.getString("lv_cozinha"));
                aco.setLvHidro(rs.getString("lv_hidro"));
                aco.setLvKitpraia(rs.getString("lv_kitpraia"));
                aco.setLvTv(rs.getString("lv_tv"));
                aco.setLvCafe(rs.getString("lv_cafe"));
                aco.setLvSauna(rs.getString("lv_sauna"));
                aco.setLvArcondicionado(rs.getString("lv_arcondicionado"));
                aco.setNmAcomodacao(rs.getString("nm_acomodacao"));
                aco.setDescricao(rs.getString("descricao"));
                lista.add(aco);
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

    public ArrayList<AcomodacaoBean> selectAll(Connection conn) throws SQLException {
        AcomodacaoBean aco = null;
        ArrayList<AcomodacaoBean> lista = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            st = conn.createStatement();

            String sql = "Select * from acomodacao order by nm_acomodacao";
            rs = st.executeQuery(sql);
            lista = new ArrayList<AcomodacaoBean>();
            while (rs.next()) {
                aco = new AcomodacaoBean();
                aco.setIdAcomodacao(rs.getInt("id_acomodacao"));
                aco.setLvSacada(rs.getString("lv_sacada"));
                aco.setLvCozinha(rs.getString("lv_cozinha"));
                aco.setLvHidro(rs.getString("lv_hidro"));
                aco.setLvKitpraia(rs.getString("lv_kitpraia"));
                aco.setLvTv(rs.getString("lv_tv"));
                aco.setLvCafe(rs.getString("lv_cafe"));
                aco.setLvSauna(rs.getString("lv_sauna"));
                aco.setLvArcondicionado(rs.getString("lv_arcondicionado"));
                aco.setNmAcomodacao(rs.getString("nm_acomodacao"));
                aco.setDescricao(rs.getString("descricao"));
                lista.add(aco);
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
