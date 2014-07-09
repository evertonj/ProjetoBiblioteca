package CadastroOperador.dao;

import CadastroOperador.entity.Operador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperadorDAO implements IOperadorDAO {

    private static final String SQL_SAVE = "insert into operador(nome, senha) values (?, ?);";
    private static final String SQL_UPDATE = "update operador set nome = ?, senha = ? where id = ?;";
    private static final String SQL_REMOVE = "delete from operador where id = ?;";
    private static final String SQL_SEARCH = "select * from operador where nome like '%?%';";
    private static final String SQL_FIND_ALL = "select * from operador;";

    @Override
    public int save(Operador operador) {
        int result = 0;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_SAVE)) {
                pstm.setString(1, operador.getNome());
                pstm.setString(2, operador.getSenha());
                result = pstm.executeUpdate();
                pstm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Operador operador) {
        int result = 0;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE)) {
                pstm.setString(1, operador.getNome());
                pstm.setString(2, operador.getSenha());
                pstm.setLong(5, operador.getId());
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
    public Operador search(String nome) {
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement comando = null;
        try {
            comando = conn.prepareStatement(SQL_SEARCH);
            rs = comando.executeQuery();
            while (rs.next()) {
                // pega todos os atributos da pessoa  
                Operador operador = new Operador(rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("SENHA"));
                return operador;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Operador> findAll() {
        List<Operador> operadores = new ArrayList<>();
        ResultSet rs;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_FIND_ALL)) {
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Operador operador = new Operador();
                    operador.setId(rs.getLong("id"));
                    operador.setNome(rs.getString("nome"));
                    operadores.add(operador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operadores;
    }
}
