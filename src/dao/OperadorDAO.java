package dao;

import connection.DBConnection;
import entity.Operador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperadorDAO implements IOperadorDAO {

    private static final String SQL_SAVE = "INSERT INTO operador(nome, senha) VALUES (?, ?);";
    private static final String SQL_UPDATE = "UPDATE operador SET nome = ?, senha = ? WHERE idOperador = ?;";
    private static final String SQL_REMOVE = "DELETE FROM operador WHERE idOperador = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM operador WHERE nome = ?";
    private static final String SQL_FIND_ALL = "SELECT * FROM operador;";
    private static final String SQL_LIST_OPERATOR = "SELECT * FROM operador WHERE nome LIKE ?";
    private static final String SQL_SEARCH_AUTHENTICATION = "SELECT * FROM operador WHERE nome = ? and senha = ?";
      

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
                pstm.setLong(3, operador.getId());
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
        ResultSet rs;
        PreparedStatement comando;
        try {
            comando = conn.prepareStatement(SQL_SEARCH);
            comando.setString(1, nome);
            rs = comando.executeQuery();
            if (rs.next()) {
                // pega todos os atributos da pessoa  
                Operador operador = new Operador(rs.getLong("idoperador"),
                        rs.getString("nome"),
                        rs.getString("senha"));
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
                    operador.setId(rs.getLong("idoperador"));
                    operador.setNome(rs.getString("nome"));
                    operador.setSenha(rs.getString("senha"));
                    operadores.add(operador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operadores;
    }

    @Override
    public List<Operador> listOfOperator(String name) {
        List<Operador> operadores = new ArrayList<>();
        ResultSet rs;
        try {
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement pstm = conn.prepareStatement(SQL_LIST_OPERATOR)) {
                pstm.setString(1, name+"%");
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Operador operador = new Operador();
                    operador.setId(rs.getLong("idoperador"));
                    operador.setNome(rs.getString("nome"));
                    operador.setSenha(rs.getString("senha"));
                    operadores.add(operador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operadores;
    }

    @Override
    public Operador searchOperadorAuthentication(String nome, String senha) {
        Connection conn = DBConnection.getConnection();
        ResultSet rs;
        PreparedStatement comando;
        try {
            comando = conn.prepareStatement(SQL_SEARCH_AUTHENTICATION);
            comando.setString(1, nome);
            comando.setString(2, senha);
            rs = comando.executeQuery();
            if (rs.next()) {
                // pega todos os atributos da pessoa  
                Operador operador = new Operador(rs.getLong("idoperador"),
                        rs.getString("nome"),
                        rs.getString("senha"));
                return operador;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}
