package dao;

import connection.DBConnection;
import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            this.salvarTelefone(usuario.getListTelefone());
            this.salvarEmail(usuario.getListEmail());
            result = pstm.executeUpdate();
           
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
     private void salvarTelefone(List<String> telefone) {

        Connection conn = null;
        PreparedStatement pstm = null, pstmIdUsuario = null;
        ResultSet rs = null;
        String sqlTelefones = "insert into telefone_autor(telefone, idusuario) values(?, ?)";
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
        String sqlTelefones = "insert into email_autor(email, idusuario) values(?, ?)";
        try {
            conn = DBConnection.getConnection();
            int contador = 0;
            pstmIdUsuario = conn.prepareStatement("select max(id) AS ultimoidUsuario from usuario");
            rs = pstmIdUsuario.executeQuery();

            rs.next();
            int ultimoIdUsuario = rs.getInt("ultimoidusuario");

            for (int i = 0; i < email.size(); i++) {
                {
                    System.out.println("Inserindo Autor: " + contador);
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

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        ResultSet rs;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_FIND_ALL)) {
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setSerie(rs.getString("serie"));
//                    usuario.setEmail(rs.getString("email"));
//                    usuario.setTelefone(rs.getString("telefone"));

                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}
