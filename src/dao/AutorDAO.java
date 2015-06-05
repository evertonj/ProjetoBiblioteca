/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Autor;
import entity.exceptions.NameException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//Teste Git

/**
 *
 * @author Alex
 */
public class AutorDAO implements IAutorDAO {

    private static final String SQL_INSERT = "insert into autor (autor_nome, sobrenome) values (?,?);";
    private static final String SQL_UPDATE = "update autor set autor_nome = ?, sobrenome= ? where id = ?;";
    private static final String SQL_REMOVE = "delete from autor where id = ?;";
    private static final String SQL_FIND_ALL = "select * from autor;";
    private static final String SQL_ORDER_TABLE = "select * from autor order by autor_nome;";

    @Override
    public int save(Autor autor) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setString(1, autor.getNome());
            pstm.setString(2, autor.getSobrenome());
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
    public int update(Autor autor) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, autor.getNome());
            pstm.setString(2, autor.getSobrenome());
            pstm.setLong(3, autor.getId());

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
    public List<Autor> buscar(String nome) {
        Connection conn = DBConnection.getConnection();
        List<Autor> lista = new ArrayList();
        ResultSet rs = null;
        try {
            PreparedStatement comando = conn.prepareStatement("select * from autor where autor_nome like '%" + nome + "%';");
            rs = comando.executeQuery();
            while (rs.next()) {
                // pega todos os atributos da pessoa  
                Autor autor;
                autor = new Autor(rs.getInt("id"),
                        rs.getString("autor_nome"),
                        rs.getString("sobrenome"));
                lista.add(autor);
            }
            return lista;

        } catch (SQLException e) {
            return null;
        } catch (NameException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Autor> finAll() {

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Autor> autors = new ArrayList<>();
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(SQL_ORDER_TABLE);

            rs = pstm.executeQuery();

            while (rs.next()) {

                Autor autor;
                autor = new Autor(rs.getInt("id"),
                        rs.getString("autor_nome"),
                        rs.getString("sobrenome"));
                autors.add(autor);

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
        } catch (NameException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autors;
    }

}
