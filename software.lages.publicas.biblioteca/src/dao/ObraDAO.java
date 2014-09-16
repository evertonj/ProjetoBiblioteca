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
import entity.EnumSituacaoExemplar;
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
        String sqlExeplares = "insert into exemplar(dataDeCadastro, fornecedor, dataDeAquisicao, id_Obra, numero_sequencial, situacao) values(?, ?, ?, ?, ?, ?)";
        int contador = 0;
        try {
            int ultimoIdObra;
            conn = DBConnection.getConnection();
            if (obra.getId() == 0) {
                System.out.println("Obra ID:" + obra.getId());
                pstmIdObra = conn.prepareStatement("select max(id) AS ultimoidobra from obra");
                rs = pstmIdObra.executeQuery();
                System.out.println("Teste Result");
                rs.next();
                ultimoIdObra = rs.getInt("ultimoidobra");
            } else {
                ultimoIdObra = obra.getId();
            }
            if (obra.getExemplar() != null) {
                for (Exemplar exemplar : obra.getExemplar()) {
                    pstm = conn.prepareStatement(sqlExeplares);
                    pstm.setDate(1, new java.sql.Date(exemplar.getDataDeCadastro().getTime()));
                    pstm.setString(2, exemplar.getFornecedor());
                    pstm.setDate(3, new java.sql.Date(exemplar.getDataDeAquisicao().getTime()));
                    pstm.setInt(4, ultimoIdObra);
                    pstm.setInt(5, exemplar.getNumeroSequancial());
                    pstm.setString(6, exemplar.getSituacao().toString());
                    pstm.executeUpdate();
                    contador++;
                    System.out.println("Inserindo exemplar: " + contador);
                }
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
        System.out.println(" Chamou o Update  ");
        int result = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        PreparedStatement pstm1 = null;
        String sql = "update obra set TITULO = ?, EDICAO = ?, ANO = ?, ID_EDITORA = ?,"
                + " ISBN = ?, IDASSUNTO = ?, FOTO = ? where id = ?;";
        String sqlAutores = "update autor set nome = ?, sobrenome = ? where id = ?";

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
            pstm.setInt(8, obra.getId());
            System.out.println("Chegou no Autor");
            result = pstm.executeUpdate();
            
            List<Autor> listaAutor = obra.getAutores();
            for (Autor autor : listaAutor) {
                pstm1 = conn.prepareStatement(sqlAutores);
                pstm1.setString(1, autor.getNome());
                pstm1.setString(2, autor.getSobrenome());
                pstm1.setInt(3, autor.getId());
                pstm1.execute();
            }
            
            for (Exemplar item : obra.getExemplar()) {
                this.updateExemplar(item);
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
    
        public int updateExemplar(Exemplar exemplar) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement("update exemplar set dataDeCadastro = ?,fornecedor = ?, dataDeAquisicao = ?,id_obra = ?, numero_sequencial = ?, situacao = ? WHERE id = ?;");
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
    public int remove(int id) {
        System.out.println("ID da Obra: " + id);
        int result = 0;
        Connection conn1 = null, conn = null;
        PreparedStatement pstm1 = null, pstm2 = null;
        String sql = "delete from obra where id = " + id + ";";
        String sqlVinculo = "delete from obra_autor where idobra = " + id + ";";
        try {
            conn = DBConnection.getConnection();
            pstm2 = conn.prepareStatement(sqlVinculo);
            result = pstm2.executeUpdate();
            conn1 = DBConnection.getConnection();
            pstm1 = conn1.prepareStatement(sql);
            result = pstm1.executeUpdate();
            System.out.println("Teste Remover");
            pstm1.close();
            pstm2.close();
            return result;
        } catch (SQLException SqlEx) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException SqlEx1) {
                SqlEx1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm1, null);
                DBConnection.close(conn, pstm2, null);
            }
            SqlEx.printStackTrace();
        }
        return result;

    }

    @Override
    public List<Obra> findAll() throws SQLException, NameException {
        PreparedStatement pstmO, pstmE, pstmAss, pstm4;
        Connection conn = null;
        Obra obra;
        ResultSet rs, rsEditora, rsAssunto, rsExterno;
        List<Obra> listaDeObra = new ArrayList<>();
        String sqlEditora = "select * from editora, obra where obra.id_editora = editora.id;";
        String sqlAssunto = "select * from assunto, obra where obra.idAssunto = assunto.id;";
        String sqlObra = "select * from obra;";
        try {
            conn = DBConnection.getConnection();
            pstmO = conn.prepareStatement(sqlObra);
            rs = pstmO.executeQuery();
            pstmE = conn.prepareStatement(sqlEditora);
            rsEditora = pstmE.executeQuery();
            pstmAss = conn.prepareStatement(sqlAssunto);
            rsAssunto = pstmAss.executeQuery();
            pstm4 = conn.prepareStatement(sqlObra);
            rsExterno = pstm4.executeQuery();
            while (rsExterno.next()) {
                obra = obra(rs, rsEditora, rsAssunto);
                System.out.println(obra.getId());
                listaDeObra.add(obra);
            }
            return listaDeObra;
        } catch (SQLException ex) {
            throw new SQLException("SQL incorreto");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }

    private Obra obra(ResultSet rs, ResultSet rsEditora, ResultSet rsAssunto) throws SQLException, NameException {
        int idobra;
        ResultSet rsAutor = null, rsExemplar = null;
        PreparedStatement pstmA = null, pstmE = null;
        Connection conn = DBConnection.getConnection();
        try {
            Obra obra = null;
            if (rs.next()) {
                obra = new Obra();
                obra.setTitulo(rs.getString("titulo"));
                obra.setId(rs.getInt("id"));
                idobra = obra.getId();
                String sqlAutor = "select * from obra as o, autor as a, obra_autor as oha where oha.idobra = " + idobra + " and oha.idautor = a.id group by a.nome;";
                pstmA = conn.prepareStatement(sqlAutor);
                rsAutor = pstmA.executeQuery();
                obra.setAutores(autores(rsAutor));
                obra.setEdicao(rs.getString("edicao"));
                obra.setAno(rs.getShort("ano"));
                obra.setEditora(editora(rsEditora));
                obra.setIsbn(rs.getString("isbn"));
                obra.setAssunto(assunto(rsAssunto));
                obra.setFoto(rs.getBytes("foto"));
                String sqlExemplar = "select * from exemplar where id_obra = " + idobra;
                pstmE = conn.prepareStatement(sqlExemplar);
                rsExemplar = pstmE.executeQuery();
                obra.setExemplar(exemplar(rsExemplar));
            }
            return obra;
        } catch (SQLException ex) {
            throw new SQLException("Problema na Escrita do SQL...");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }
    int contador = 0;

    private List<Autor> autores(ResultSet rs) throws NameException, SQLException {
        List<Autor> listaDeAutores = new ArrayList<>();
        while (rs.next()) {
            Autor autor = new Autor(rs.getInt("id"), rs.getString("nome"),
                    rs.getString("sobrenome"));
            contador++;
            System.out.println("Contador de Autores: " + contador);
            listaDeAutores.add(autor);
        }
        return listaDeAutores;
    }

    private List<Exemplar> exemplar(ResultSet rs) throws NameException, SQLException {
        List<Exemplar> listaDeExemplares = new ArrayList<>();
        Exemplar exemplar;
        try {
            while (rs.next()) {
                exemplar = new Exemplar(rs.getInt("id"),
                        new java.util.Date(rs.getDate("dataDeCadastro").getTime()),
                        rs.getString("fornecedor"),
                        new java.util.Date(rs.getDate("dataDeAquisicao").getTime()),
                        rs.getInt("id_obra"), rs.getInt("numero_sequencial"),
                        EnumSituacaoExemplar.getSituacao(rs.getString("situacao")));
                listaDeExemplares.add(exemplar);
            }
            return listaDeExemplares;
        } catch (SQLException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    public List<Obra> consulta(String titulo) throws SQLException, NameException {
        PreparedStatement pstmO, pstmE, pstmAss, pstm4;
        Connection conn = null;
        Obra obra;
        ResultSet rs, rsEditora, rsAssunto, rsExterno;
        List<Obra> listaDeObra = new ArrayList<>();
        String sqlEditora = "select * from editora, obra where obra.id_editora = editora.id;";
        String sqlAssunto = "select * from assunto, obra where obra.idAssunto = assunto.id;";
        String sqlObra = "select * from obra where titulo like " + "'%" + titulo + "%';";
        try {
            conn = DBConnection.getConnection();
            pstmO = conn.prepareStatement(sqlObra);
            rs = pstmO.executeQuery();
            pstmE = conn.prepareStatement(sqlEditora);
            rsEditora = pstmE.executeQuery();
            pstmAss = conn.prepareStatement(sqlAssunto);
            rsAssunto = pstmAss.executeQuery();
            pstm4 = conn.prepareStatement(sqlObra);
            rsExterno = pstm4.executeQuery();
            while (rsExterno.next()) {
                obra = obra(rs, rsEditora, rsAssunto);
                System.out.println(obra.getId());
                listaDeObra.add(obra);
            }
            return listaDeObra;
        } catch (SQLException ex) {
            throw new SQLException("SQL incorreto");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }

    public List<Obra> consultaAutor(String autor) throws SQLException, NameException {
        PreparedStatement pstmO, pstmE, pstmAss, pstm4;
        Connection conn = null;
        Obra obra;
        ResultSet rs, rsEditora, rsAssunto, rsExterno;
        List<Obra> listaDeObra = new ArrayList<>();
        String sqlEditora = "select * from editora, obra where obra.id_editora = editora.id;";
        String sqlAssunto = "select * from assunto, obra where obra.idAssunto = assunto.id;";
        String sqlObra = "select * from obra o, autor a, obra_autor oa where a.nome like '%" + autor + "%' and oa.idautor = a.id and oa.idobra = o.id;";
        try {
            conn = DBConnection.getConnection();
            pstmO = conn.prepareStatement(sqlObra);
            rs = pstmO.executeQuery();
            pstmE = conn.prepareStatement(sqlEditora);
            rsEditora = pstmE.executeQuery();
            pstmAss = conn.prepareStatement(sqlAssunto);
            rsAssunto = pstmAss.executeQuery();
            pstm4 = conn.prepareStatement(sqlObra);
            rsExterno = pstm4.executeQuery();
            while (rsExterno.next()) {
                obra = obra(rs, rsEditora, rsAssunto);
                System.out.println(obra.getId());
                listaDeObra.add(obra);
            }
            return listaDeObra;
        } catch (SQLException ex) {
            throw new SQLException("SQL incorreto");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }

    public List<Obra> consultaIsbn(String isbn) throws SQLException, NameException {
        PreparedStatement pstmO, pstmE, pstmAss, pstm4;
        Connection conn = null;
        Obra obra;
        ResultSet rs, rsEditora, rsAssunto, rsExterno;
        List<Obra> listaDeObra = new ArrayList<>();
        String sqlEditora = "select * from editora, obra where obra.id_editora = editora.id;";
        String sqlAssunto = "select * from assunto, obra where obra.idAssunto = assunto.id;";
        String sqlObra = "select * from obra where isbn = " + isbn;
        try {
            conn = DBConnection.getConnection();
            pstmO = conn.prepareStatement(sqlObra);
            rs = pstmO.executeQuery();
            pstmE = conn.prepareStatement(sqlEditora);
            rsEditora = pstmE.executeQuery();
            pstmAss = conn.prepareStatement(sqlAssunto);
            rsAssunto = pstmAss.executeQuery();
            pstm4 = conn.prepareStatement(sqlObra);
            rsExterno = pstm4.executeQuery();
            while (rsExterno.next()) {
                obra = obra(rs, rsEditora, rsAssunto);
                System.out.println(obra.getId());
                listaDeObra.add(obra);
            }
            return listaDeObra;
        } catch (SQLException ex) {
            throw new SQLException("SQL incorreto");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }

    public List<Obra> consultaPorCodigo(int codigo) throws SQLException, NameException {
        PreparedStatement pstmO, pstmE, pstmAss, pstm4;
        Connection conn = null;
        Obra obra;
        ResultSet rs, rsEditora, rsAssunto, rsExterno;
        List<Obra> listaDeObra = new ArrayList<>();
        String sqlEditora = "select * from editora, obra where obra.id_editora = editora.id;";
        String sqlAssunto = "select * from assunto, obra where obra.idAssunto = assunto.id;";
        String sqlObra = "select * from obra where id = " + codigo + ";";
        try {
            conn = DBConnection.getConnection();
            pstmO = conn.prepareStatement(sqlObra);
            rs = pstmO.executeQuery();
            pstmE = conn.prepareStatement(sqlEditora);
            rsEditora = pstmE.executeQuery();
            pstmAss = conn.prepareStatement(sqlAssunto);
            rsAssunto = pstmAss.executeQuery();
            pstm4 = conn.prepareStatement(sqlObra);
            rsExterno = pstm4.executeQuery();
            while (rsExterno.next()) {
                obra = obra(rs, rsEditora, rsAssunto);
                System.out.println(obra.getId());
                listaDeObra.add(obra);
            }
            return listaDeObra;
        } catch (SQLException ex) {
            throw new SQLException("SQL incorreto");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }
}
