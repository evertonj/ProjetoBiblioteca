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

    private static final String SQL_INSERT = "insert into ASSUNTO (NOME) VALUES (?);";
    private static final String SQL_UPDATE = "update ASSUNTO set NOME = ? WHERE ID = ?;";
    private static final String SQL_REMOVE = "delete from ASSUNTO where ID = ?;";
    private static final String SQL_FIND_ALL = "select * from ASSUNTO;";
    private static final String SQL_ORDER_TABLE = "select * from autor order by nome;";

    @Override
    public int save(Assunto autor) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
          
            pstm.setString(1, autor.getNome());
            
       
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
    public int update(Assunto autor) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
           pstm.setString(1, autor.getNome());
           
           
            pstm.setLong(4, autor.getId());
           
            
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
     public Assunto buscar(String nome) {  
         Connection conn = DBConnection.getConnection();
      
      ResultSet rs=null;  
      try {  
           PreparedStatement comando = conn.prepareStatement("SELECT * FROM Assunto WHERE Nome LIKE '%"+nome+"%';" );
       
         rs = comando.executeQuery();
         while (rs.next()) {  
             
            // pega todos os atributos da pessoa  
            Assunto  assunto = new Assunto();
            assunto.setNome(rs.getString("Nome"));
            assunto.setId(rs.getInt("id"));
             
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
        List<Assunto> autors = new ArrayList<>();
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(SQL_ORDER_TABLE);

            rs = pstm.executeQuery();

            while (rs.next()) {                       
              
                 Assunto  assunto = new Assunto();
            assunto.setNome(rs.getString("Nome"));
            assunto.setId(rs.getInt("id"));
                
                autors.add(assunto);    
               
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
        return autors;
    }


}
