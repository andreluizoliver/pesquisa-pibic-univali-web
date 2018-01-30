/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rnp.stcfed.service.control;

import br.rnp.sctfed.service.dao.ReservaDao;
import br.rnp.stcfed.service.bean.ReservaBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class ReservaControl {

    ReservaDao dao = null;

    public ReservaControl() throws ClassNotFoundException {
        dao = new ReservaDao();
    }

    public void delete(int id) throws SQLException {

		Connection conn = null;


		try{
			conn = dao.getConnection();
			conn.setAutoCommit(false);

			dao.delete(conn, id);
			conn.commit();

		}
		catch(Throwable e){

			if (conn != null && !conn.isClosed())
				conn.rollback();
		}
		finally{

			if (conn != null && !conn.isClosed())
				conn.close();

			conn = null;
		}

	}


	public int insert(ReservaBean res) throws SQLException {

		Connection conn = null;
		int pkProduto = -1;
		try{
			conn = dao.getConnection();
			conn.setAutoCommit(false);

			pkProduto = dao.insert(conn, res);

			if (pkProduto != 0){

				conn.commit();
			}
			else
				throw new Exception("Erro ao recuperar o valor do sequence.");
		}
		catch(Throwable e){

			if (conn != null && !conn.isClosed())
				conn.rollback();
		}
		finally{

			if (conn != null && !conn.isClosed())
				conn.close();

			conn = null;
		}
		return pkProduto;
	}


	public ArrayList<ReservaBean> selectAll() throws SQLException {

		Connection conn = null;
		ArrayList<ReservaBean> lista = null;

		try{
			conn = dao.getConnection();
			conn.setAutoCommit(false);

			lista = dao.selectAll(conn);
			conn.commit();
		}
		catch(Throwable e){

			if (conn != null && !conn.isClosed())
				conn.rollback();
		}
		finally{

			if (conn != null && !conn.isClosed())
				conn.close();

			conn = null;
		}

		return lista;
	}


	public ReservaBean selectPorId(int id) throws SQLException {

		Connection conn = null;
		ReservaBean res = null;

		try{
			conn = dao.getConnection();
			conn.setAutoCommit(false);

			res = dao.selectPorId(conn, id);
			conn.commit();
		}
		catch(Throwable e){

			if (conn != null && !conn.isClosed())
				conn.rollback();
		}
		finally{

			if (conn != null && !conn.isClosed())
				conn.close();

			conn = null;
		}

		return res;
	}

	public ArrayList<ReservaBean> selectPorNome(String descricao) throws SQLException {

		Connection conn = null;
		ArrayList<ReservaBean> lista = null;

		try{
			conn = dao.getConnection();
			conn.setAutoCommit(false);

			lista = dao.selectPorNome(conn, descricao);
			conn.commit();
		}
		catch(Throwable e){

			if (conn != null && !conn.isClosed())
				conn.rollback();
		}
		finally{

			if (conn != null && !conn.isClosed())
				conn.close();

			conn = null;
		}

		return lista;
	}


	public int update(ReservaBean res) throws SQLException {

		Connection conn = null;
		int id = 0;
		try{
			conn = dao.getConnection();
			conn.setAutoCommit(false);

			id = dao.update(conn, res);
			conn.commit();
		}
		catch(Throwable e){

			if (conn != null && !conn.isClosed())
				conn.rollback();
		}
		finally{

			if (conn != null && !conn.isClosed())
				conn.close();

			conn = null;
		}

		return id;
	}

        public void main(String args[]) throws ClassNotFoundException, SQLException{
        ReservaBean res = new ReservaBean();
        res.setEmail("00000@gmail.com");
        res.setIdReserva(1);
        res.setNome("Thais");
        res.setNrPessoas(3);
        res.setObs("obsThais");
        res.setTelefone("0000000");

        //ReservaControl rc = new ReservaControl();
        //rc.insert(res);

        ReservaControl ws = new ReservaControl();
        int  i =ws.insert(res);
    }



}
