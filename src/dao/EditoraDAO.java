/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import connection.DBConnection;
import entity.Editora;
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
public class EditoraDAO implements IEditoraDAO {

    private static final String SQL_INSERT = "insert into EDITORA (NOME, TELEFONE, EMAIL, CIDADE , RUA ,BAIRRO ,NUMERO) VALUES (?,?,?,?,?,?,?);";
    private static final String SQL_UPDATE = "update EDITORA set NOME = ?,TELEFONE = ?, EMAIL = ?,CIDADE = ?,   Rua = ?, Cidade = ?,NUMERO = ? WHERE ID = ?;";
    private static final String SQL_REMOVE = "delete from EDITORA where ID = ?;";
    private static final String SQL_FIND_ALL = "select * from EDITORA;";
    private static final String SQL_ORDER_TABLE = "select * from editora order by nome;";

    @Override
    public int save(Editora editora) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
          
            pstm.setString(1, editora.getNome());
            pstm.setString(2, editora.getTelefone());
            pstm.setString(3, editora.getEmail());
            pstm.setString(4, editora.getCidade());
            pstm.setString(5, editora.getRua());
            pstm.setString(6, editora.getBairro());
            pstm.setString(7, editora.getNumero());
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
    public int update(Editora editora) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
           pstm.setString(1, editora.getNome());
            pstm.setString(2, editora.getTelefone());
            pstm.setString(3, editora.getEmail());
            pstm.setString(4, editora.getCidade());
            pstm.setString(5, editora.getRua());
            pstm.setString(6, editora.getBairro());
            pstm.setString(7, editora.getNumero());
            pstm.setInt(8, editora.getId());
           
            
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
     public Editora buscar(String nome) {  
         Connection conn = DBConnection.getConnection();
      
      ResultSet rs=null;  
      try {  
           PreparedStatement comando = conn.prepareStatement("SELECT * FROM EDITORA WHERE Nome LIKE '%"+nome+"%';" );
       
         rs = comando.executeQuery();
         while (rs.next()) {  
             
            // pega todos os atributos da pessoa  
             Editora editora;
               try {
                   editora = new Editora( rs.getInt("ID"),
                           rs.getString("NOME"),
                           rs.getString("TELEFONE"),
                           rs.getString("EMAIL"),
                           rs.getString("CIDADE"),
                           rs.getString("RUA"),
                           rs.getString("BAIRRO"),
                           rs.getString("NUMERO"));
                   return editora;
               } catch (NameException ex) {
                   Logger.getLogger(EditoraDAO.class.getName()).log(Level.SEVERE, null, ex);
               }
                  
             
         }  
         
      } catch (SQLException e) {  
          
         return null;  
      }  
      return null;
     }
    @Override
    public List<Editora> finAll() {
        
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Editora> editoras = new ArrayList<>();
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(SQL_ORDER_TABLE);

            rs = pstm.executeQuery();
System.out.println("teste");
            while (rs.next()) {      
                
              
                Editora editora;
                try {
                    editora = new Editora( rs.getInt("ID"),
                            rs.getString("NOME"),
                            rs.getString("TELEFONE"),
                            rs.getString("EMAIL"),
                            rs.getString("CIDADE"),
                            rs.getString("RUA"),
                            rs.getString("BAIRRO"),
                            rs.getString("NUMERO"));
                    editoras.add(editora);
                } catch (NameException ex) {
                    Logger.getLogger(EditoraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                           
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
        return editoras;
    }

}
