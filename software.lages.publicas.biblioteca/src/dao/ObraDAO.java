/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Editora;
import entity.Autor;
import connection.DBConnection;
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
public class ObraDAO implements IObraDAO {

    @Override
    public int save(Obra obra) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert into obra(TITULO, EDICAO, ANO, EDITORA, ISBN, ASSUNTO, FOTO) VALUES (?, ?, ?, ?, ?, ?, ?);";
        String sqlAutores = "insert into obra_autor(idobra, idautor) values(last_insert_id(), ?);";
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, obra.getTitulo());
            pstm.setString(2, obra.getEdicao());
            pstm.setShort(3, obra.getAno());
            pstm.setInt(4, obra.getEditora().getId());
            System.out.println("dEPOIS DO id EDITORA");
            pstm.setString(5, obra.getIsbn());
            pstm.setString(6, obra.getAssunto());
            pstm.setBytes(7, obra.getFoto());
            result = pstm.executeUpdate();
            System.out.println("Antes do Autor");
            for (Autor autor1 : obra.getAutores()) {
                pstm = conn.prepareStatement(sqlAutores);
                pstm.setLong(1, autor1.getId());
                result = pstm.executeUpdate();
            }
            pstm.close();
            return result;
        } catch (SQLException SqlEx) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException SqlEx1) {
                SqlEx1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            SqlEx.printStackTrace();
        }
        return result;

    }

    @Override
    public int update(Obra obra) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "update obra set TITULO = ?, EDICAO = ?, ANO = ?, EDITORA = ?,"
                + " ISBN = ?, ASSUNTO = ?, FOTO = ? where id = ?;";
        String sqlAutores = "update obra_autor set idobra = ?, idautor = ? where idobra = ?;";
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, obra.getTitulo());
            pstm.setString(2, obra.getEdicao());
            pstm.setShort(3, obra.getAno());
            pstm.setInt(4, obra.getEditora().getId());
            pstm.setString(5, obra.getIsbn());
            pstm.setString(6, obra.getAssunto());
            pstm.setBytes(7, obra.getFoto());
            result = pstm.executeUpdate();
            for (Autor autor1 : obra.getAutores()) {
                pstm = conn.prepareStatement(sqlAutores);
                pstm.setInt(1, obra.getId());
                pstm.setLong(2, autor1.getId());
                pstm.setInt(3, obra.getId());
                result = pstm.executeUpdate();
            }
            pstm.close();
            return result;
        } catch (SQLException SqlEx) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException SqlEx1) {
                SqlEx1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            SqlEx.printStackTrace();
        }
        return result;

    }

    @Override
    public int remove(int id) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "delete obra where id = " + id;
        String sqlVinculo = "delete obra_autor where idobra = " + id;
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            result = pstm.executeUpdate();
            pstm = conn.prepareStatement(sqlVinculo);
            result = pstm.executeUpdate();
            pstm.close();
            return result;
        } catch (SQLException SqlEx) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException SqlEx1) {
                SqlEx1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            SqlEx.printStackTrace();
        }
        return result;

    }

    @Override
    public List<Obra> findAll() throws SQLException, NameException {
        PreparedStatement pstmO, pstmA, pstmE;
        Connection conn = null ;
        Obra obra;
        ResultSet rs, rsAutores, rsEditora;
        List<Obra> listaDeObra = new ArrayList<>();
        String sql = "select * from obra;";
        String sqlAutores = "select * from autor A, obra O obra_autor OA where O.id = OA.idobra and OA = A.id;";
        String sqlEditora = "select * from editora where id = id_editora;";
        try {
            pstmO = conn.prepareStatement(sql);
            rs = pstmO.executeQuery();
            pstmA = conn.prepareStatement(sqlAutores);
            rsAutores = pstmA.executeQuery();
            pstmE = conn.prepareStatement(sqlEditora);
            rsEditora = pstmE.executeQuery();
            while (rs.next()) {
                obra = obra(rs, rsAutores, rsEditora);
                listaDeObra.add(obra);
            }
            return listaDeObra;
        } catch (SQLException ex) {
            throw new SQLException("SQL incorreto");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }

    private Obra obra(ResultSet rs, ResultSet rsAutor, ResultSet rsEditora) throws SQLException, NameException {
        try {
            while (rs.next()) {
                Obra obra = new Obra();
                obra.setTitulo(rs.getString("titulo"));
                obra.setId(rs.getInt("id"));
                obra.setAutores(autores(rsAutor));
                obra.setEdicao(rs.getString("edicao"));
                obra.setAno(rs.getShort("ano"));
                obra.setEditora(editora(rsEditora));
                obra.setIsbn(rs.getString("isbn"));
                obra.setAssunto(rs.getString("assunto"));
                obra.setFoto(rs.getBytes("foto"));
            }
            return null;
        } catch (SQLException ex) {
            throw new SQLException("Problema na Escrita do SQL...");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }

    private List<Autor> autores(ResultSet rs) throws NameException, SQLException {
        List<Autor> listaDeAutores = new ArrayList<>();
        while (rs.next()) {
            Autor autor = new Autor(rs.getLong("id"), rs.getString("nome"),
                    rs.getString("sobrenome"), rs.getDate("data"));
            listaDeAutores.add(autor);
        }
        return listaDeAutores;
    }

    private Editora editora(ResultSet rs) throws NameException{
        Editora editora;
        try {
            editora = new Editora(rs.getInt("ID"),
                    rs.getString("NOME"),
                    rs.getString("TELEFONE"),
                    rs.getString("EMAIL"),
                    rs.getString("CIDADE"),
                    rs.getString("RUA"),
                    rs.getString("BAIRRO"),
                    rs.getString("NUMERO"));
            return editora;
        } catch (SQLException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Obra> consulta(String titulo) {
        return null;
    }

    @Override
    public List<Obra> consulta(int codigo) {
        return null;
    }

    public List<Autor> listaDeAutores() {
        return null;
    }

}
