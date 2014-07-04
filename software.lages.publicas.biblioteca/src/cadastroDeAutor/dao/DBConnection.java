/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadastroDeAutor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Alex
 */
public class DBConnection {
    private static final String URL_MYSQL = "jdbc:mysql://localhost/biblioteca";
    private static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "root";
 
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS_MYSQL);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
 
    public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (conn!= null) {
                conn.close();
            }
 
            if (stmt!= null) {
                stmt.close();
            }
 
            if (rs!= null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void createTable() {
        
        Connection connection = getConnection();
        PreparedStatement stmt = null;
        String sql = "CREATE TABLE IF NOT EXISTS AUTOR (" +
                "  ID bigint(20) NOT NULL AUTO_INCREMENT," +
                "  NOME VARCHAR(40) NOT NULL," +
                "  SOBRENOME VARCHAR(40)," +
                "DATANASCIMENTO DATE,"+
                "primary Key(id)"+
               
                ");";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
          
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}
