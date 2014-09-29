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

    private static final String SQL_REMOVE = "delete  from usuario where id = ?;";
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
        String sqlTelefones = "insert into telefone_usuario(numero, idusuario) values(?, ?)";
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
            try (PreparedStatement pstm = conn.prepareStatement("update usuario set nome = ?, serie = ?, foto = ? where id = ?;")) {
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getSerie());
                pstm.setBytes(3, usuario.getFoto());
                pstm.setInt(4, usuario.getId());
               
                result = pstm.executeUpdate();
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //remove(result)
       
        
        return result;
    }
    private void updateEmail(String email, int id) {

        Connection conn = null;
        PreparedStatement pstm = null, pstmIdUsuario = null;
        ResultSet rs = null;
        String sqlEmail = "update email_usuario set email = ? where idusuario = " + id + ";";
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sqlEmail);
         

            

                    pstm.setString(1, email);
                    pstm.setInt(2, id);

                    pstm.executeUpdate();

                

           
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

//   private void removeTelefone(int id){
//       PreparedStatement pstmE = null;
//        String telefone = "delete from telefone_usuario where idusuario = " + id + ";";
//        pstmE
//     
//       
//   }

    @Override
    public int remove(int id) {
        int result = 0;
        PreparedStatement pstmO = null, pstmE = null;
        String telefone = "delete from telefone_usuario where idusuario = " + id + ";";

        String email = "delete from email_usuario where idusuario =" + id + ";";
        try {
            Connection conn = DBConnection.getConnection();
            pstmO = conn.prepareStatement(telefone);
            pstmE = conn.prepareStatement(email);
            pstmO.executeUpdate();
            pstmE.executeUpdate();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_REMOVE)) {
                pstm.setInt(1, id);
                result = pstm.executeUpdate();
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    

    private void updateTelefone(List<String> telefone, int id) {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sqlEmail = "delete from telefone_usuario where idusuario = " + id + ";";
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sqlEmail);
            rs = pstm.executeQuery();
            

            while(rs.next()){

                for (int i = 0; i < telefone.size(); i++) {
                    
               
                    pstm.setString(1, telefone.get(i));
                    pstm.setInt(2, id);

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

    /**
     *
     * @return
     */
    @Override
    public List<Usuario> findAll() {

        PreparedStatement pstmO;
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

            usuario = new Usuario();
            System.out.println(" teste ");

            usuario.setNome(rs.getString("Nome"));
            System.out.println(usuario.getNome());
            usuario.setId(rs.getInt("id"));
            idusuario = usuario.getId();
            System.out.println(idusuario);
            String sqlTelefone = "select * from telefone_usuario where idusuario = " + idusuario + ";";
            String sqlEmail = "select * from email_usuario where idusuario = " + idusuario + ";";
            pstmT = conn.prepareStatement(sqlTelefone);
            System.out.println(" Teste");
            rsTelefone = pstmT.executeQuery();
            pstmE = conn.prepareStatement(sqlEmail);
            rsEmail = pstmE.executeQuery();
            usuario.setListTelefone(telefones(rsTelefone));
            usuario.setFoto(rs.getBytes("Foto"));

            usuario.setSerie(rs.getString("Serie"));

            usuario.setListEmail(emails(rsEmail));

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
            listaDeTelefones.add(rs.getString("numero"));

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

    public List<Usuario> buscaPorNome(String nome) {

        PreparedStatement pstmO;
        Connection conn = null;
        Usuario usuario;
        ResultSet rs = null, rsExterno = null;
        List<Usuario> listaDeUsuario = new ArrayList<>();

        String sqlUsuario = " select * from usuario where nome like '" + nome + "%';";
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

    public List<Usuario> buscaPorSerie(String nome) {

        PreparedStatement pstmO;
        Connection conn = null;
        Usuario usuario;
        ResultSet rs = null, rsExterno = null;
        List<Usuario> listaDeUsuario = new ArrayList<>();

        String sqlUsuario = "select * from usuario where serie like '" + nome + "%';";
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

    @Override
    public Usuario buscaNome(String nome, String serie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
