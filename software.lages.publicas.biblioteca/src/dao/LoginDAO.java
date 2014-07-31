/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dao.ILoginDAO;
import entity.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.DBConnection;

/**
 * 
 * @author Familia
 */
public class LoginDAO implements ILoginDAO {

    private static final String SQL_LOGIN = "select NOME, SENHA from LOGIN where = ?, ?;";
    private static final String SQL_SEARCH = "SELECT * FROM pessoa WHERE Nome LIKE '%?%';";

    @Override
    public Login search(String nome) {
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement comando = null;
        try {
            comando = conn.prepareStatement(SQL_SEARCH);
            rs = comando.executeQuery();
            while (rs.next()) {
                // pega todos os atributos da pessoa  
                Login login = new Login(rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("SENHA"));
                return login;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    public boolean login(String login, String senha) {
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement comando = null;
        try {
            comando = conn.prepareStatement(SQL_LOGIN);
            rs = comando.executeQuery();
            while (rs.next()) {
                String senhaBanco = rs.getString("senha");
                String loginBanco = rs.getString("nome");
                if (login.equals(loginBanco) && senha.equals(senhaBanco)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
