/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Exemplar;
import entity.Obra;
import entity.exceptions.NameException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class ExemplarDAO implements IExemplarDAO {

    private static final String SQL_INSERT = "insert into exemplar (dataDeCadastro, fornecedor, dataDeAquisicao, id_obra , numero_sequencial) VALUES (?,?,?,?,?);";
    private static final String SQL_UPDATE = "update exemplar set dataDeCadastro = ?,fornecedor = ?, dataDeAquisicao = ?,id_obra = ?, numero_sequencial = ? WHERE id = ?;";
    private static final String SQL_REMOVE = "delete from exemplar where id = ?;";
    private static final String SQL_FIND_ALL = "select * from exemplar;";
    private static final String SQL_ORDER_TABLE = "select * from exemplar order by nome;";

    @Override
    public int save(List<Exemplar> exemplares, Obra obra) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            for (Exemplar exemplar : exemplares) {
                pstm.setDate(1, new java.sql.Date(exemplar.getDataDeCadastro().getTime()));
                pstm.setString(2, exemplar.getFornecedor());
                pstm.setDate(3, new java.sql.Date(exemplar.getDataDeAquisicao().getTime()));
                pstm.setInt(4, exemplar.getIdObra());
                pstm.setInt(5, exemplar.getNumeroSequancial());
                result = pstm.executeUpdate();
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
        return result;
    }

    @Override
    public int update(Exemplar exemplar) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setDate(1, new java.sql.Date(exemplar.getDataDeCadastro().getTime()));
            pstm.setString(2, exemplar.getFornecedor());
            pstm.setDate(3, new java.sql.Date(exemplar.getDataDeAquisicao().getTime()));
            pstm.setInt(4, exemplar.getIdObra());
            pstm.setInt(5, exemplar.getNumeroSequancial());
            pstm.setInt(6, exemplar.getId());

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
    public Exemplar buscar(String nome) throws SQLException {
        Connection conn = DBConnection.getConnection();

        ResultSet rs = null;
        try {
            PreparedStatement comando = conn.prepareStatement("SELECT * FROM exemplar WHERE fornecedor LIKE '%" + nome + "%';");

            rs = comando.executeQuery();
            while (rs.next()) {
                // pega todos os atributos da pessoa  
                Exemplar exemplar;
                exemplar = new Exemplar(rs.getInt("id"),
                        rs.getDate("dataDeCadastro"),
                        rs.getString("fornecedor"),
                        rs.getDate("dataDeAquisicao"),
                        rs.getInt("id_obra"),
                        rs.getInt("numero_sequencial"));
                return exemplar;

            }

        } catch (SQLException e) {
            throw new SQLException("Sintaxe do Sql esta Incorreta...");
        }
        return null;
    }

    @Override
    public List<Exemplar> finAll() {

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Exemplar> exemplares = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(SQL_ORDER_TABLE);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Exemplar exemplar;
                try {
                    exemplar = new Exemplar(rs.getInt("id"),
                            rs.getDate("dataDeCadastro"),
                            rs.getString("fornecedor"),
                            rs.getDate("dataDeAquisicao"),
                            rs.getInt("id_obra"),
                            rs.getInt("numero_sequencial"));
                    exemplares.add(exemplar);
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
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exemplares;
    }
}

        
