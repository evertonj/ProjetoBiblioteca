/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Emprestimo;
import entity.ExcluirEmprestimo;
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
 * @author Everton
 */
public class EmprestimoDAO implements IEmprestimoDAO {

    ExemplarDAO exemDAO = new ExemplarDAO();

    String queryBuscaEmprestimo = "select * from emprestimo where usuario_id = ? and exemplar_id = ?";

    String sql = "INSERT INTO `biblioteca`.`emprestimo`"
            + "(`exemplar_id`,"
            + "`usuario_id`,"
            + "`data_emprestimo`,"
            + "`data_devolucao`,"
            + "`foi_devolvido`,"
            + "`autor_id`,"
            + "`editora_id`,"
            + "`dias_para_devolver`,"
            + "`obra_id`,"
            + "`operador_idoperador`) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String queryBuscaDadosEmprestimo = "select u.id, u.nome, ex.id, o.titulo, a.autor_nome, a.sobrenome, o.edicao, o.ano, edit.editora_nome "
            + "from usuario u, obra o, editora edit, emprestimo e, autor a, obra_autor oa, exemplar ex "
            + "where o.id = oa.idobra and oa.idobra = e.obra_id  and a.id = oa.idautor and oa.idautor = e.autor_id and edit.id = o.id_editora  and ex.id_obra = o.id and e.foi_devolvido = 0 and e.exemplar_id = ex.id  and e.usuario_id = u.id and u.nome like ?";

    @Override
    public void emprestimo(Emprestimo emprestimo) {
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, emprestimo.getExemplar_id());
            pstm.setInt(2, emprestimo.getUsuario_id());
            pstm.setTimestamp(3, new java.sql.Timestamp(emprestimo.getData_emprestimo().toEpochDay()));
            pstm.setTimestamp(4, new java.sql.Timestamp(emprestimo.getData_devolucao().plusDays(emprestimo.getDiasParaDevolucao()).toEpochDay()));
            pstm.setBoolean(5, false);
            pstm.setInt(6, emprestimo.getAutor_id());
            pstm.setInt(7, emprestimo.getEditora_id());
            pstm.setInt(8, emprestimo.getDiasParaDevolucao());
            pstm.setInt(9, emprestimo.getObra_id());
            pstm.setInt(10, emprestimo.getOperador_id());
            pstm.execute();
            exemDAO.mudarSituacaoParaEmprestado(emprestimo.getExemplar_id());
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirEmprestimo(Emprestimo emp) {
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement("delete from emprestimo where exemplar_id = ? and usuario_id = ?");
            pstm.setInt(1, emp.getExemplar_id());
            pstm.setInt(2, emp.getUsuario_id());
            pstm.execute();
            exemDAO.mudarSituacaoParaDisponivel(emp.getExemplar_id());
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Integer> consultarSeJaPussuiAlgoEmprestado(int idUsuario) {
        Connection con = DBConnection.getConnection();
        List<Integer> lista = new ArrayList<>();
        try {
            PreparedStatement pstm = con.prepareStatement("select exemplar_id from emprestimo where usuario_id = ? and foi_devolvido = 0");
            pstm.setInt(1, idUsuario);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int exemplar_id = rs.getInt("exemplar_id");
                lista.add(exemplar_id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public String consultarTituloDoExemplar(int exemplar_id) {
        Connection con = DBConnection.getConnection();
        String titulo = null;
        try {
            PreparedStatement pstm = con.prepareStatement("select titulo from obra o, exemplar e where e.id = ? and o.id = id_obra");
            pstm.setInt(1, exemplar_id);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {
                titulo = rs.getString("titulo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return titulo;
    }

    public List<ExcluirEmprestimo> ConsultarPorNomeParaExcluir(String usuario) {
        List<ExcluirEmprestimo> lista = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(queryBuscaDadosEmprestimo);
            pstm.setString(1,  "%"+usuario + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ExcluirEmprestimo exEmp = new ExcluirEmprestimo();
                exEmp.setIdUsuario(rs.getInt("u.id"));
                exEmp.setIdExemplar(rs.getInt("ex.id"));
                exEmp.setAno(rs.getString("o.ano"));
                String nome = rs.getString("a.autor_nome");
                String sobrenome = rs.getString("a.sobrenome");
                exEmp.setAutor(nome + " " + sobrenome);
                exEmp.setEdicao(rs.getString("o.edicao"));
                exEmp.setTitulo(rs.getString("o.titulo"));
                exEmp.setUsuario(rs.getString("u.nome"));
                exEmp.setEditora(rs.getString("edit.editora_nome"));
                exEmp.setEmprestimo(getEmprestimo(rs.getInt("u.id"), rs.getInt("ex.id")));
                lista.add(exEmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private Emprestimo getEmprestimo(int idUsuario, int idExemplar) {
        Emprestimo emp = null;
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement(queryBuscaEmprestimo);
            pstm.setInt(1, idUsuario);
            pstm.setInt(2, idExemplar);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {
                emp = new Emprestimo();
                emp.setAutor_id(rs.getInt("autor_id"));
                emp.setData_devolucao(rs.getDate("data_devolucao").toLocalDate());
                emp.setData_emprestimo(rs.getDate("data_emprestimo").toLocalDate());
                emp.setDiasParaDevolucao(rs.getInt("dias_para_devolver"));
                emp.setEditora_id(rs.getInt("editora_id"));
                emp.setExemplar_id(rs.getInt("exemplar_id"));
                emp.setObra_id(rs.getInt("obra_id"));
                emp.setUsuario_id(rs.getInt("usuario_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }
}
