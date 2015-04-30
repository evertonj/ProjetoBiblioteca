package dao;

import connection.DBConnection;
import entity.Email;
import entity.EnumSituacaoUsuario;
import entity.Telefone;
import entity.Usuario;
import entity.exceptions.NameException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String sql = "INSERT INTO usuario(nome, serie, foto,DataCadastro,situacao) VALUES (?, ?, ?,?,?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSerie());
            pstm.setBytes(3, usuario.getFoto());
            pstm.setDate(4, new java.sql.Date(usuario.getDataCadastro().getTime()));
            pstm.setString(5, usuario.getSituacao().toString());
            result = pstm.executeUpdate();

            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.salvarTelefone(usuario.getListTelefone());
        this.salvarEmail(usuario.getListEmail());
        return result;
    }

    private void salvarTelefone(List<Telefone> telefones) {

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

            for (int i = 0; i < telefones.size(); i++) {
                {
                    pstm = conn.prepareStatement(sqlTelefones);
                    pstm.setString(1, telefones.get(i).getTelefone());
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

    private void salvarUmEmail(Email email, int idUsuario) {
        String sqlEmail = "insert into email_usuario(email, idusuario) values(?, ?)";
        Connection conn = DBConnection.getConnection();;
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlEmail);
            pstm.setString(1, email.getEmail());
            pstm.setInt(2, idUsuario);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void salvarUmTelefone(Telefone tel, int idUsuario) {
        String sqlTelefone = "insert into telefone_usuario(numero, idusuario) values(?, ?)";
        Connection conn = DBConnection.getConnection();;
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlTelefone);
            pstm.setString(1, tel.getTelefone());
            pstm.setInt(2, idUsuario);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void salvarEmail(List<Email> emails) {

        Connection conn = null;
        PreparedStatement pstm = null, pstmIdUsuario = null;
        ResultSet rs = null;
        String sqlEmails = "insert into email_usuario(email, idusuario) values(?, ?)";
        try {
            conn = DBConnection.getConnection();
            int contador = 0;
            pstmIdUsuario = conn.prepareStatement("select max(id) AS ultimoidUsuario from usuario");
            rs = pstmIdUsuario.executeQuery();

            rs.next();
            int ultimoIdUsuario = rs.getInt("ultimoidusuario");

            for (int i = 0; i < emails.size(); i++) {
                {
                    pstm = conn.prepareStatement(sqlEmails);
                    pstm.setString(1, emails.get(i).getEmail());
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
            try (PreparedStatement pstm = conn.prepareStatement("update usuario set nome = ?, serie = ?, foto = ? , situacao = ? where id = ?;")) {
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getSerie());
                pstm.setBytes(3, usuario.getFoto());
                 pstm.setString(4, usuario.getSituacao().toString());
                pstm.setInt(5, usuario.getId());
                for (Email col : usuario.getListEmail()) {
                    if (col.getId() == 0) {
                        System.out.println("Adicionou email");
                        salvarUmEmail(col, usuario.getId());
                    } else {
                        updateEmail(col, usuario.getId());
                    }
                }
                for (Telefone col : usuario.getListTelefone()) {
                    if (col.getId() == 0) {
                        System.out.println("Adicionou Telefone");
                        salvarUmTelefone(col, usuario.getId());
                    } else {
                        updateTelefone(col, usuario.getId());
                    }
                }
                result = pstm.executeUpdate();
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //remove(result)

        return result;
    }
    
    public void removerEmail(Email email) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM email_usuario WHERE id = ?");
            pstm.setInt(1, email.getId());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removerTelefone(Telefone tel) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM telefone_usuario WHERE id = ?");
            pstm.setInt(1, tel.getId());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateEmail(Email email, int id) {
        Connection conn = null;
        PreparedStatement pstm = null, pstmIdUsuario = null;
        ResultSet rs = null;
        String sqlEmail = "update email_usuario set email = ? where idusuario = ? and id = ?";

        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sqlEmail);
            pstm.setString(1, email.getEmail());
            pstm.setInt(2, id);
            pstm.setInt(3, email.getId());
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

    private void updateTelefone(Telefone telefone, int id) {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sqlTelefone = "update telefone_usuario set numero = ? where idusuario = ? and id = ?";
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(sqlTelefone);
            pstm.setString(1, telefone.getTelefone());
            pstm.setInt(2, id);
            pstm.setInt(3, telefone.getId());
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
            usuario.setSituacao(EnumSituacaoUsuario.getSituacao(rs.getString("situacao")));

            usuario.setListEmail(emails(rsEmail));

            return usuario;

        } catch (SQLException ex) {
            throw new SQLException("Problema na Escrita do SQL...");
        } catch (NameException ex) {
            throw new NameException("nome incorreto...");
        }

    }
    int contador = 0;

    private List<Telefone> telefones(ResultSet rs) throws NameException, SQLException {
        List<Telefone> listaDeTelefones = new ArrayList<>();
        while (rs.next()) {
            Telefone tel = new Telefone();
            tel.setId(rs.getInt("id"));
            tel.setTelefone(rs.getString("numero"));
            listaDeTelefones.add(tel);
        }
        return listaDeTelefones;
    }

    private List<Email> emails(ResultSet rs) throws NameException, SQLException {
        List<Email> listaDeEmail = new ArrayList<>();
        while (rs.next()) {
            Email email = new Email();
            email.setId(rs.getInt("id"));
            email.setEmail(rs.getString("email"));
            listaDeEmail.add(email);
        }
        return listaDeEmail;
    }

    public List<Usuario> buscaPorNome(String nome) {

        PreparedStatement pstmO;
        Connection conn = null;
        Usuario usuario;
        ResultSet rs = null, rsExterno = null;
        List<Usuario> listaDeUsuario = new ArrayList<>();

        String sqlUsuario = "select * from usuario where nome like '" + nome + "%'";
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
}
