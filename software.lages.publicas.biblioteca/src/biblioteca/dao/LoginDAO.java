/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.dao;

import biblioteca.entity.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class LoginDAO implements ILoginDAO {

    private static final String SQL_INSERT = "insert into LOGIN (NOME, SENHA) VALUES (?,?);";
    private static final String SQL_UPDATE = "update LOGIN set NOME = ?, SENHA = ? WHERE ID = ?;";
    private static final String SQL_REMOVE = "delete from LOGIN where ID = ?;";
    private static final String SQL_FIND_ALL = "select * from LOGIN;";
    private static final String SQL_ORDER_TABLE = "select * from LOGIN order by nome;";
    private static final String SQL_LOGIN = "select NOME, SENHA from LOGIN where = ?, ?;";
    private static final String SQL_SEARCH = "SELECT * FROM pessoa WHERE Nome LIKE '%?%';";

    @Override
    public int save(Login login) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setString(1, login.getNome());
            pstm.setString(2, login.getSenha());
            result = pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Login login) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, login.getNome());
            pstm.setString(2, login.getSenha());
            result = pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int remove(long id) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_REMOVE);
            pstm.setLong(1, id);
            result = pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

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

    @Override
    public List<Login> finAll() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Login> logins = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(SQL_ORDER_TABLE);
            rs = pstm.executeQuery();
            System.out.println("teste");
            while (rs.next()) {
                Login login = new Login(rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("SENHA"));
                logins.add(login);
            }
            pstm.close();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return logins;
    }

}
