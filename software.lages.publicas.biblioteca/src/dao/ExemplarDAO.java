/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.EnumSituacaoExemplar;
import entity.Exemplar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alex
 */
public class ExemplarDAO implements IExemplarDAO {

    private static final String SQL_INSERT = "insert into exemplar(dataDeCadastro, fornecedor, dataDeAquisicao, id_Obra, numero_sequencial, situacao) values(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update exemplar set dataDeCadastro = ?,fornecedor = ?, dataDeAquisicao = ?,id_obra = ?, numero_sequencial = ?, situacao = ? WHERE id = ?;";
    private static final String SQL_REMOVE = "delete from exemplar where id = ?;";
    private static final String SQL_ORDER_TABLE = "select * from exemplar order by nome;";

    public String ObtemTituloDaObra(int idOBra) {
        String titulo;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement("select titulo from obra where id = " + idOBra + ";");
            rs = pstm.executeQuery();
            if (rs.next()) {
                return titulo = rs.getString("titulo");
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
        return null;
    }

    @Override
    public int save(Exemplar exemplar) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setDate(1, new java.sql.Date(exemplar.getDataDeCadastro().getTime()));
            pstm.setString(2, exemplar.getFornecedor());
            pstm.setDate(3, new java.sql.Date(exemplar.getDataDeAquisicao().getTime()));
            pstm.setInt(4, exemplar.getIdObra());
            pstm.setInt(5, exemplar.getNumeroSequancial());
            pstm.setString(6, exemplar.getSituacao().toString());
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
            pstm.setString(6, exemplar.getSituacao().toString());
            pstm.setInt(7, exemplar.getId());
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
    public List<Exemplar> buscar(String fornecedor) throws SQLException {
        Connection conn = DBConnection.getConnection();
        List<Exemplar> exemplares = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM exemplar WHERE fornecedor LIKE ?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, "%" + fornecedor + "%");
            rs = comando.executeQuery();
            while (rs.next()) {
                Exemplar exemplar;
                exemplar = new Exemplar(rs.getInt("id"),
                        new Date(rs.getDate("dataDeCadastro").getTime()),
                        rs.getString("fornecedor"),
                        new Date(rs.getDate("dataDeAquisicao").getTime()),
                        rs.getInt("id_obra"),
                        rs.getInt("numero_sequencial"),
                        EnumSituacaoExemplar.getSituacao(rs.getString("situacao")));
                exemplares.add(exemplar);
            }
        } catch (SQLException e) {
            throw new SQLException("Sintaxe do Sql esta Incorreta...");
        }
        return exemplares;
    }

    public List<Exemplar> buscarTitulo(String titulo) throws SQLException {
        Connection conn = DBConnection.getConnection();
        List<Exemplar> exemplares = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM exemplar e, obra o WHERE  e.id_obra = o.id  and o.titulo LIKE ?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, "%" + titulo + "%");
            rs = comando.executeQuery();
            while (rs.next()) {
                Exemplar exemplar;
                exemplar = new Exemplar(rs.getInt("id"),
                        new Date(rs.getDate("dataDeCadastro").getTime()),
                        rs.getString("fornecedor"),
                        new Date(rs.getDate("dataDeAquisicao").getTime()),
                        rs.getInt("id_obra"),
                        rs.getInt("numero_sequencial"),
                        EnumSituacaoExemplar.getSituacao(rs.getString("situacao")));
                exemplares.add(exemplar);
            }
        } catch (SQLException e) {
            throw new SQLException("Sintaxe do Sql esta Incorreta...");
        }
        return exemplares;
    }

    public List<Exemplar> buscarDataCadastro(Date dataCadastro) throws SQLException {
        Connection conn = DBConnection.getConnection();
        List<Exemplar> exemplares = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM exemplar WHERE dataDeCadastro = ?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setDate(1, new java.sql.Date(dataCadastro.getTime()));
            rs = comando.executeQuery();
            while (rs.next()) {
                Exemplar exemplar;
                exemplar = new Exemplar(rs.getInt("id"),
                        new Date(rs.getDate("dataDeCadastro").getTime()),
                        rs.getString("fornecedor"),
                        new Date(rs.getDate("dataDeAquisicao").getTime()),
                        rs.getInt("id_obra"),
                        rs.getInt("numero_sequencial"),
                        EnumSituacaoExemplar.getSituacao(rs.getString("situacao")));
                exemplares.add(exemplar);
            }
        } catch (SQLException e) {
            throw new SQLException("Sintaxe do Sql esta Incorreta...");
        }
        return exemplares;
    }

    public List<Exemplar> buscarDataAquisicao(Date dataAquisicao) throws SQLException {
        Connection conn = DBConnection.getConnection();
        List<Exemplar> exemplares = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM exemplar WHERE dataDeAquisicao = ?";
        try {
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setDate(1, new java.sql.Date(dataAquisicao.getTime()));
            rs = comando.executeQuery();
            while (rs.next()) {
                Exemplar exemplar;
                exemplar = new Exemplar(rs.getInt("id"),
                        new Date(rs.getDate("dataDeCadastro").getTime()),
                        rs.getString("fornecedor"),
                        new Date(rs.getDate("dataDeAquisicao").getTime()),
                        rs.getInt("id_obra"),
                        rs.getInt("numero_sequencial"),
                        EnumSituacaoExemplar.getSituacao(rs.getString("situacao")));
                exemplares.add(exemplar);
            }
        } catch (SQLException e) {
            throw new SQLException("Sintaxe do Sql esta Incorreta...");
        }
        return exemplares;
    }

    @Override
    public List<Exemplar> finAll() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Exemplar> exemplares = new ArrayList<>();
        ResultSet rs;
        try {
            pstm = conn.prepareStatement(SQL_ORDER_TABLE);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Exemplar exemplar;
                exemplar = new Exemplar(rs.getInt("id"),
                        new Date(rs.getDate("dataDeCadastro").getTime()),
                        rs.getString("fornecedor"),
                        new Date(rs.getDate("dataDeAquisicao").getTime()),
                        rs.getInt("id_obra"),
                        rs.getInt("numero_sequencial"),
                        EnumSituacaoExemplar.getSituacao(rs.getString("situacao")));
                exemplares.add(exemplar);
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
        return exemplares;
    }
}
