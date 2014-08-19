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
import java.lang.reflect.Array;
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
        String sqlExeplares = "insert into exemplar(dataDeCadastro, fornecedor, dataDeAquisicao, id_Obra, numero_sequencial) values(?, ?, ?, ?, ?)";
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
                pstm.setInt(5, exemplar.getNumeroSequancial());
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
    /*
     @Override
     public List<Obra> findAll() throws SQLException, NameException {
     PreparedStatement pstm, pstm1 = null, pstm2 = null, pstm3 = null, pstm4 = null;
     Connection conn = null;
     Obra obra;
     ResultSet rs, rsAutor, rsEditora, rsAssunto, rsExterno;
     List<Obra> listaDeObra = new ArrayList<>();
     String sqlEditora = "select * from editora, obra where obra.id_editora = editora.id;";
     String sqlAutor = "select * from autor A, obra O, obra_autor OA where O.id = OA.idobra and OA.idautor = A.id;";
     String sqlAssunto = "select * from assunto, obra where obra.idAssunto = assunto.id;";
     String sqlObra = "select * from obra;";
     //        String sql = "select o.id as obraid, o.ano as obraano, o.edicao as obraedicao, o.foto as obrafoto,\n"
     //                + " o.id_editora as obraideditora, o.idAssunto as obraidassunto, o.isbn as obraisbn, o.titulo as obratitulo,\n"
     //                + "ass.id as assuntoid, ass.nome as assuntonome, aut.datanascimento as autordatanascimento, aut.id as autorid,\n"
     //                + " aut.nome as autornome, aut.sobrenome as autorsobrenome, edit.bairro as editorabairro, edit.cidade as editoracidade, edit.email as editoraemail,\n"
     //                + " edit.id as editoraid, edit.nome as editoranome, edit.numero as editoranumero, edit.rua as editorarua, edit.telefone as editoratelefone,\n"
     //                + " o_a.id as obra_autorid, o_a.idautor as obra_autoridautor, o_a.idobra as obra_autoridobra\n"
     //                + " from obra as o, assunto as ass, autor as aut, editora as edit, obra_autor as o_a where o.id_editora = edit.id and \n"
     //                + "o.idAssunto = ass.id and o_a.idautor = aut.id and o_a.idobra = o.id;";
     try {
     conn = DBConnection.getConnection();

     pstm4 = conn.prepareStatement(sqlObra);
     rsExterno = pstm4.executeQuery();
     int contador = 0;
     while (rsExterno.next()) {
     pstm = conn.prepareStatement(sqlObra);
     pstm1 = conn.prepareStatement(sqlAutor);
     pstm2 = conn.prepareStatement(sqlEditora);
     pstm3 = conn.prepareStatement(sqlAssunto);
     rs = pstm.executeQuery();
     rsAutor = pstm1.executeQuery();
     rsEditora = pstm2.executeQuery();
     rsAssunto = pstm3.executeQuery();
     System.out.println("Contador: " + contador);
     obra = obra(rs, rsAutor, rsEditora, rsAssunto);
     contador++;
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

     private Obra obra(ResultSet rs, ResultSet rsAutor, ResultSet rsEditora, ResultSet rsAssunto) throws SQLException, NameException {
     try {
     Obra obra = null;
     while (rs.next()) {
     obra = new Obra();
     obra.setTitulo(rs.getString("obratitulo"));
     obra.setId(rs.getInt("obraid"));

     obra.setAutores(autores(rsAutor));
     System.out.println("Teste Find All");

     obra.setEdicao(rs.getString("obraedicao"));

     obra.setAno(rs.getShort("obraano"));

     obra.setEditora(editora(rsEditora));

     obra.setIsbn(rs.getString("obraisbn"));
     obra.setAssunto(assunto(rsAssunto));

     obra.setFoto(rs.getBytes("obrafoto"));
     }
     return obra;
     } catch (SQLException ex) {
     throw new SQLException("Problema na Escrita do SQL...");
     } catch (NameException ex) {
     throw new NameException("nome incorreto...");
     }
     }

     private List<Autor> autores(ResultSet rs) throws NameException, SQLException {
     List<Autor> listaDeAutores = new ArrayList<>();
     while (rs.next()) {
     Autor autor = new Autor(rs.getInt("autorid"), rs.getString("autornome"),
     rs.getString("autorsobrenome"), rs.getDate("autordatanascimento"));

     listaDeAutores.add(autor);
     }

     return listaDeAutores;
     }

     private Assunto assunto(ResultSet rs) throws NameException, SQLException {
     Assunto assunto = new Assunto();
     try {
     if (rs.next()) {
     assunto.setId(rs.getInt("assuntoid"));
     assunto.setNome(rs.getString("assuntonome"));
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

     editora = new Editora(rs.getInt("editoraid"),
     rs.getString("editoranome"),
     rs.getString("editoratelefone"),
     rs.getString("editoraemail"),
     rs.getString("editoracidade"),
     rs.getString("editorarua"),
     rs.getString("editorabairro"),
     rs.getString("editoranumero"));

     }
     return editora;
     } catch (SQLException ex) {
     Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return null;
     }
     */

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
        ResultSet rsAutor = null;
        PreparedStatement pstmA = null;
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
                    rs.getString("sobrenome"), rs.getDate("datanascimento"));
            contador++;
            System.out.println("Contador de Autores: " + contador);
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
    public List<Obra> consulta(String titulo) throws SQLException, NameException {
        PreparedStatement pstmO, pstmE, pstmAss, pstm4;
        Connection conn = null;
        Obra obra;
        ResultSet rs, rsEditora, rsAssunto, rsExterno;
        List<Obra> listaDeObra = new ArrayList<>();
        String sqlEditora = "select * from editora, obra where obra.id_editora = editora.id;";
        String sqlAssunto = "select * from assunto, obra where obra.idAssunto = assunto.id;";
        String sqlObra = "select * from obra where titulo like "+"'%"+titulo+"%';";
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

    @Override
    public List<Obra> consulta(int codigo) throws SQLException, NameException{
        return null;
    }
}
