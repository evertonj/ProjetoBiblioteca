/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroDeAutor.dao;
import cadastroDeAutor.entity.Autor;
import cadastroDeAutor.entity.exceptions.NameException;
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
public class AutorDAO implements IAutorDAO {

    private static final String SQL_INSERT = "insert into AUTOR (NOME, SOBRENOME, DATANASCIMENTO) VALUES (?,?,?);";
    private static final String SQL_UPDATE = "update AUTOR set NOME = ?, SOBRENOME= ?, DATANASCIMENTO=? WHERE ID = ?;";
    private static final String SQL_REMOVE = "delete from AUTOR where ID = ?;";
    private static final String SQL_FIND_ALL = "select * from AUTOR;";
    private static final String SQL_ORDER_TABLE = "select * from autor order by nome;";

    @Override
    public int save(Autor autor) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
          
            pstm.setString(1, autor.getNome());
            pstm.setString(2, autor.getSobrenome());
            pstm.setDate(3, autor.getDataNascimento());
       
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
             pstm.setString(3, autor.getDataNascimento().toString());
           
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
     public Autor buscar(String nome) {  
         Connection conn = DBConnection.getConnection();
      
      ResultSet rs=null;  
      try {  
           PreparedStatement comando = conn.prepareStatement("SELECT * FROM Autor WHERE Nome LIKE '%"+nome+"%';" );
       
         rs = comando.executeQuery();
         while (rs.next()) {  
             
            // pega todos os atributos da pessoa  
             Autor autor;
             autor = new Autor( rs.getLong("ID"),
                     rs.getString("NOME"),
                     rs.getString("SOBRENOME"),
                     rs.getDate("DATANASCIMENTO"));
               return autor;
                  
             
         }  
         
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
                autor = new Autor( rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("SOBRENOME"),
                        rs.getDate("DATANASCIMENTO")
                );
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
