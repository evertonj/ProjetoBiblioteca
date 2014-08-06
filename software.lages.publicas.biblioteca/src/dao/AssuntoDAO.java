/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import connection.DBConnection;
import entity.Assunto;
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
 * @author Thiago
 */
public class AssuntoDAO implements IAssuntoDAO {

    private static final String SQL_INSERT = "insert into assunto (NOME) VALUES (?);";
    private static final String SQL_UPDATE = "update assunto set NOME = ? WHERE ID = ?;";
    private static final String SQL_REMOVE = "delete from assunto where ID = ?;";
    private static final String SQL_FIND_ALL = "select * from assunto;";
    private static final String SQL_ORDER_TABLE = "select * from assunto order by nome;";

    @Override
    public int save(Assunto assunto) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
          
            pstm.setString(1, assunto.getNome());
            
       
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
    public int update(Assunto assunto) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
           pstm.setString(1, assunto.getNome());
           
           
            pstm.setInt(2, assunto.getId());
           
            
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
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_REMOVE);
            pstm.setInt(1, id);
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
     public Assunto buscar(String nome) {  
         Connection conn = DBConnection.getConnection();
      
      ResultSet rs=null;  
      try {  
          PreparedStatement comando = conn.prepareStatement("SELECT * FROM assunto WHERE Nome = '"+nome+"';" );
       
         rs = comando.executeQuery();
         if (rs.next()) {  
             
            // pega todos os atributos da pessoa  
            Assunto  assunto = new Assunto();
            assunto.setNome(rs.getString("Nome"));
            assunto.setId(rs.getInt("id"));
             return assunto;
         }  
         
      } catch (SQLException e) {  
          
         return null;  
      }  
      return null;
     }
    @Override
    public List<Assunto> finAll() {
        
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Assunto> assuntos = new ArrayList<>();
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(SQL_ORDER_TABLE);

            rs = pstm.executeQuery();

            while (rs.next()) {      
                
              
                Assunto assunto = new Assunto();
                assunto.setId(rs.getInt("id"));
                assunto.setNome(rs.getString("nome"));
                assuntos.add(assunto);
                        
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
        return assuntos;
    }

}


