/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Assunto;
import entity.Editora;
import entity.Autor;
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
public class ObraDAO implements IObraDAO {

    @Override
    public int save(Obra obra) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert into obra(TITULO, EDICAO, ANO, ID_EDITORA, ISBN, IDASSUNTO, FOTO) VALUES (?, ?, ?, ?, ?, ?, ?);";
//load_file('?')
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, obra.getTitulo());
            pstm.setString(2, obra.getEdicao());
            pstm.setShort(3, obra.getAno());
            System.out.println("ID Editora" + obra.getEditora().getId());
            pstm.setInt(4, obra.getEditora().getId());
            pstm.setString(5, obra.getIsbn());
            pstm.setInt(6, obra.getAssunto().getId());
            pstm.setBytes(7, obra.getFoto());
            result = pstm.executeUpdate();
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
        this.salvarAutor(obra);
        this.salvarExemplar(obra);
        return result;
    }

    private void salvarExemplar(Obra obra) {

        Connection conn = null;
        PreparedStatement pstm = null, pstmIdObra = null;
        ResultSet rs = null;
        String sqlExeplares = "insert into exemplar(dataDeCadastro, fornecedor, dataDeAquisicao, id_Obra) values(?, ?, ?, ?)";
        int contador = 0;
        try {
            conn = DBConnection.getConnection();
            pstmIdObra = conn.prepareStatement("select max(id) AS ultimoidobra from obra");
            rs = pstmIdObra.executeQuery();
            System.out.println("Teste Result");
            rs.next();
            int ultimoIdObra = rs.getInt("ultimoidobra");
            for (Exemplar exemplar : obra.getExemplar()) {
                pstm = conn.prepareStatement(sqlExeplares);
                pstm.setDate(1, new java.sql.Date(exemplar.getDataDeCadastro().getTime()));
                pstm.setString(2, exemplar.getFornecedor());
                pstm.setDate(3, new java.sql.Date(exemplar.getDataDeAquisicao().getTime()));
                pstm.setInt(4, ultimoIdObra);
                pstm.executeUpdate();
                contador++;
                System.out.println("Inserindo exemplar: " + contador);
            }
            pstm.close();
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
    }

    private void salvarAutor(Obra obra) {

        Connection conn = null;
        PreparedStatement pstm = null, pstmIdObra = null;
        ResultSet rs = null;
        String sqlAutores = "insert into obra_autor(idautor, idobra) values(?, ?)";
        try {
            conn = DBConnection.getConnection();
            int contador = 0;
            pstmIdObra = conn.prepareStatement("select max(id) AS ultimoidobra from obra");
            rs = pstmIdObra.executeQuery();
            System.out.println("Teste Result");
            rs.next();
            int ultimoIdObra = rs.getInt("ultimoidobra");
            System.out.println("ID_OBRA" + rs.getInt("ultimoidobra"));
            for (Autor autor : obra.getAutores()) {
                System.out.println("Inserindo Autor: " + contador);
                pstm = conn.prepareStatement(sqlAutores);
                System.out.println("Inserindo Autor: " + contador);
                System.out.println("Autor ID" + autor.getId());
                pstm.setInt(1, autor.getId());
                pstm.setInt(2, ultimoIdObra);//Corrigir
                System.out.println("Inserindo Autor passou do setInt: " + contador);
                pstm.executeUpdate();
                System.out.println("Executou a Query");
                contador++;
                System.out.println("Inserindo Autor: " + contador);
            }
            pstm.close();
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
            pstm.setInt(6, obra.getAssunto().getId());
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
        PreparedStatement pstmO, pstmA, pstmE, pstmAss;
        Connection conn = null;
        Obra obra;
        ResultSet rs, rsAutores, rsEditora, rsAssunto;
        List<Obra> listaDeObra = new ArrayList<>();
        String sql = "select * from obra;";
        String sqlAutores = "select * from autor A, obra O obra_autor OA where O.id = OA.idobra and OA = A.id;";
        String sqlEditora = "select * from editora where id = id_editora;";
        String sqlAssunto = "select * from assunto where id = idassunto;";
        try {
            pstmO = conn.prepareStatement(sql);
            rs = pstmO.executeQuery();
            pstmA = conn.prepareStatement(sqlAutores);
            rsAutores = pstmA.executeQuery();
            pstmE = conn.prepareStatement(sqlEditora);
            rsEditora = pstmE.executeQuery();
            pstmAss = conn.prepareStatement(sqlAssunto);
            rsAssunto = pstmAss.executeQuery();
            while (rs.next()) {
                obra = obra(rs, rsAutores, rsEditora, rsAssunto);
                listaDeObra.add(obra);
            }
            return listaDeObra;
        } catch (SQLException ex) {
            throw new SQLException("SQL incorreto");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }

    private Obra obra(ResultSet rs, ResultSet rsAutor, ResultSet rsEditora, ResultSet rsAssunto) throws SQLException, NameException {
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
                obra.setAssunto(assunto(rsAssunto));
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
            Autor autor = new Autor(rs.getInt("id"), rs.getString("nome"),
                    rs.getString("sobrenome"), rs.getDate("data"));
            listaDeAutores.add(autor);
        }
        return listaDeAutores;
    }

    private Assunto assunto(ResultSet rs) throws NameException, SQLException {
        Assunto assunto = new Assunto();
        try {
            if (rs.next()) {
                assunto.setId(rs.getInt("id"));
                assunto.setNome(rs.getString("nome"));
            }
            return assunto;
        } catch (SQLException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Editora editora(ResultSet rs) throws NameException, SQLException {
        Editora editora = null;
        try {
            if (rs.next()) {
                editora = new Editora(rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("TELEFONE"),
                        rs.getString("EMAIL"),
                        rs.getString("CIDADE"),
                        rs.getString("RUA"),
                        rs.getString("BAIRRO"),
                        rs.getString("NUMERO"));
            }
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
