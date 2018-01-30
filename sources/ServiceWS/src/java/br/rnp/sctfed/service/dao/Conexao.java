/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rnp.sctfed.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Andre
 */
public class Conexao {

    private String db;
    private String login;
    private String password;
    private String url;

    protected Conexao() throws ClassNotFoundException {

        // Carrega a classe do driver JDBC
        Class.forName("org.postgresql.Driver");

        db = "hotelDB";
        login = "postgres";
        password = "andrelo89";
        url = "jdbc:postgresql://localhost:5432/";
    }

    public Connection getConnection() throws Exception {

        return DriverManager.getConnection(url + db, login, password);
    }
}
