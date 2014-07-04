package biblioteca.dao;

import biblioteca.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    private static final String SQL_SAVE = "insert into usuario(nome, serie, email, telefone) values (?, ?, ?, ?);";
    private static final String SQL_UPDATE = "update usuario set nome = ?, serie = ?, email = ?, telefone = ? where id = ?;";
    private static final String SQL_REMOVE = "delete from usuario where id = ?;";
    private static final String SQL_FIND_ALL = "select * from usuario;";

    @Override
    public int save(Usuario usuario) {
        int result = 0;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_SAVE)) {
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getSerie());
                pstm.setString(3, usuario.getEmail());
                pstm.setString(4, usuario.getTelefone());
                result = pstm.executeUpdate();
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Usuario usuario) {
        int result = 0;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE)) {
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getSerie());
                pstm.setString(3, usuario.getEmail());
                pstm.setString(4, usuario.getTelefone());
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
                while(rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setSerie(rs.getString("serie"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefone(rs.getString("telefone"));
                    
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}
