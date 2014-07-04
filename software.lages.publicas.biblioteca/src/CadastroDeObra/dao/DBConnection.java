/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CadastroDeObra.dao;

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
 
    public static void createTableObra() {        
        Connection connection = getConnection();
        PreparedStatement stmt = null;
        String sql = "CREATE TABLE IF NOT EXISTS OBRA (" +
                "  ID INT NOT NULL AUTO_INCREMENT," +
                "  TITULO VARCHAR(60) NOT NULL," +
                "  EDICAO VARCHAR(60)," +
                "  ANO VARCHAR(60)," +
                "  ISBN VARCHAR(60) ," +
                "  ASSUNTO VARCHAR(60)," +
                "  IMAGEM VARCHAR(60)," +
                "  FK_OBRA_EDITORA INT NOT NULL" +
                "  FK_OBRA_AUTOR INT NOT NULL" +
                "  PRIMARY KEY (ID)" +
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
    
        public static void createTableAutor() {        
        Connection connection = getConnection();
        PreparedStatement stmt = null;
        String sql = "CREATE TABLE IF NOT EXISTS AUTOR (" +
                "  ID INT NOT NULL AUTO_INCREMENT," +
                "  AUTOR VARCHAR(60) NOT NULL," +
                "  PRIMARY KEY (ID)" +
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

