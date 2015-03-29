/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Emprestimo;
import java.sql.Connection;
import java.sql.Date;
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
    String sql = "INSERT INTO `biblioteca`.`emprestimo`\n"
            + "(`exemplar_id`,\n"
            + "`usuario_id`,\n"
            + "`data_emprestimo`,\n"
            + "`data_devolucao`,\n"
            + "`foi_devolvido`)\n"
            + "VALUES(?, ?, ?, ?, ?)";

    @Override
    public void emprestimo(Emprestimo emprestimo) {
        Connection con = DBConnection.getConnection();
        try {
            for (int i = 0; i < emprestimo.getObra_id().size(); i++) {
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setInt(1, emprestimo.getObra_id().get(i));
                pstm.setInt(2, emprestimo.getUsuario_id());
                pstm.setDate(3, new Date(emprestimo.getData_emprestimo().toDate().getTime()));
                pstm.setDate(4, new Date(emprestimo.getData_devolucao().toDateTime().plusDays(emprestimo.getDiasParaDevolucao()).getMillis()));
                pstm.setBoolean(5, false);
                pstm.execute();
            }
            exemDAO.mudarSituacaoParaEmprestado(emprestimo.getObra_id());
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
}
