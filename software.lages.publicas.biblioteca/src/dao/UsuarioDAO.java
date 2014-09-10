package dao;

import connection.DBConnection;
import entity.Usuario;
import entity.exceptions.NameException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements IUsuarioDAO {

    private static final String SQL_UPDATE = "update usuario set nome = ?, serie = ?, email = ?, telefone = ? where id = ?;";
    private static final String SQL_REMOVE = "delete from usuario where id = ?;";
    private static final String SQL_FIND_ALL = "select * from usuario;";

    @Override
    public int save(Usuario usuario) {
        int result = 0;
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO usuario(nome, serie, foto) VALUES (?, ?, ?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSerie());
            pstm.setBytes(3, usuario.getFoto());
            
            result = pstm.executeUpdate();
           
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.salvarTelefone(usuario.getListTelefone());
        this.salvarEmail(usuario.getListEmail());
        return result;
    }
     private void salvarTelefone(List<String> telefone) {

        Connection conn = null;
        PreparedStatement pstm = null, pstmIdUsuario = null;
        ResultSet rs = null;
        String sqlTelefones = "insert into telefone_usuario(telefone, idusuario) values(?, ?)";
        try {
            conn = DBConnection.getConnection();
            int contador = 0;
            pstmIdUsuario = conn.prepareStatement("select max(id) AS ultimoidUsuario from usuario");
            rs = pstmIdUsuario.executeQuery();

            rs.next();
            int ultimoIdUsuario = rs.getInt("ultimoidusuario");

            for (int i = 0; i < telefone.size(); i++) {
                {
                   
                    pstm = conn.prepareStatement(sqlTelefones);
                   
                    pstm.setString(1, telefone.get(i));
                    pstm.setInt(2, ultimoIdUsuario);//Corrigir
                   
                    pstm.executeUpdate();
                   
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

    

    private void salvarEmail(List<String> email) {

        Connection conn = null;
        PreparedStatement pstm = null, pstmIdUsuario = null;
        ResultSet rs = null;
        String sqlTelefones = "insert into email_usuario(email, idusuario) values(?, ?)";
        try {
            conn = DBConnection.getConnection();
            int contador = 0;
            pstmIdUsuario = conn.prepareStatement("select max(id) AS ultimoidUsuario from usuario");
            rs = pstmIdUsuario.executeQuery();

            rs.next();
            int ultimoIdUsuario = rs.getInt("ultimoidusuario");

            for (int i = 0; i < email.size(); i++) {
                {
                
                    pstm = conn.prepareStatement(sqlTelefones);
                   
                    pstm.setString(1, email.get(i));
                    pstm.setInt(2, ultimoIdUsuario);//Corrigir
                   
                    pstm.executeUpdate();
                   
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

    @Override
    public int update(Usuario usuario) {
        int result = 0;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE)) {
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getSerie());
                pstm.setLong(5, usuario.getId());
                result = pstm.executeUpdate();
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int remove(Long id) {
        int result = 0;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_REMOVE)) {
                pstm.setLong(1, id);
                result = pstm.executeUpdate();
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @return
     */
    @Override
     public List<Usuario> findAll()  {
         
        PreparedStatement pstmO, pstmE, pstmAss, pstm4;
        Connection conn = null;
        Usuario usuario;
        ResultSet rs = null, rsExterno = null;
        List<Usuario> listaDeUsuario = new ArrayList<>();
       
        String sqlUsuario = "select * from usuario;";
        try {
            conn = DBConnection.getConnection();
            pstmO = conn.prepareStatement(sqlUsuario);
            rs = pstmO.executeQuery();
            
            
            while (rs.next()) {
                usuario = usuario(rs);
               
                listaDeUsuario.add(usuario);
            }
            return listaDeUsuario;
        } catch (SQLException ex) {
            try {
                throw new SQLException("SQL incorreto");
            } catch (SQLException ex1) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
       
        } catch (NameException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDeUsuario;
     }

    private Usuario usuario(ResultSet rs) throws SQLException, NameException {
        int idusuario;
        ResultSet rsTelefone = null, rsEmail = null;
        PreparedStatement pstmT = null, pstmE = null;
        Connection conn = DBConnection.getConnection();
        try {
            Usuario usuario = null;
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNome(rs.getString("Nome"));
                usuario.setId(rs.getInt("id"));
                idusuario = usuario.getId();
                String sqlTelefone = "select * from usuario_telefone where idusuario = " + idusuario + ";";
                 String sqlEmail = "select * from usuario_email where idusuario = " + idusuario + ";";
                pstmT = conn.prepareStatement(sqlTelefone);
                rsTelefone = pstmT.executeQuery();
                usuario.setListTelefone(telefones(rsTelefone));
                usuario.setFoto(rs.getBytes("Foto"));
                usuario.setSerie(sqlTelefone);
                usuario.setListEmail(emails(rsEmail));
                
                
                
            }
            return usuario;
        } catch (SQLException ex) {
            throw new SQLException("Problema na Escrita do SQL...");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }
    }
    int contador = 0;

    private List<String> telefones(ResultSet rs) throws NameException, SQLException {
        List<String> listaDeTelefones = new ArrayList<>();
        while (rs.next()) {
            listaDeTelefones.add(rs.getString("Telefone"));
          
        }
        return listaDeTelefones;
    }
     private List<String> emails(ResultSet rs) throws NameException, SQLException {
        List<String> listaDeEmail = new ArrayList<>();
        while (rs.next()) {
            listaDeEmail.add(rs.getString("email"));
          
        }
        return listaDeEmail;
    }

}
