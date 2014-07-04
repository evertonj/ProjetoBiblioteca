/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadastroDeObra.dao;

import CadastroDeObra.model.Autor;
import CadastroDeObra.model.Obra;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        FileInputStream fis = null;
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, obra.getTitulo());
            pstm.setString(2, obra.getEdicao());
            pstm.setShort(3, obra.getAno());
            pstm.setInt(4, 10);
            pstm.setString(5, obra.getIsbn());
            pstm.setString(6, obra.getAssunto());
            fis = new FileInputStream(obra.getFoto());
            pstm.setBinaryStream(7, fis, obra.getFoto().length());
            result = pstm.executeUpdate();
            for (String autor1 : obra.getAutores()) {
                pstm = conn.prepareStatement(sqlAutores);
                pstm.setInt(1, 10);
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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    @Override
    public int update(Obra obra) {
        return 0;
    }

    @Override
    public int remove(int id) {
        return 0;
    }

    @Override
    public List<Obra> findAll() {
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

}
