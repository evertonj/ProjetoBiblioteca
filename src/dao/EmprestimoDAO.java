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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everton
 */
public class EmprestimoDAO implements IEmprestimoDAO {

    String sql = "INSERT INTO `biblioteca`.`emprestimo`\n"
            + "(`obra_id`,\n"
            + "`usuario_id`,\n"
            + "`data_emprestimo`,\n"
            + "`data_devolucao`)\n"
            + "VALUES(?, ?, ?, ?)";

    @Override
    public void emprestimo(Emprestimo emprestimo) {
        Date date;
        Connection con = DBConnection.getConnection();
        try {
            for (int i = 0; i < 10; i++) {
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setInt(1, emprestimo.getObra_id().get(i));
                pstm.setInt(2, emprestimo.getUsuario_id());
                pstm.setDate(3, new Date(emprestimo.getData_emprestimo().toDate().getTime()));
                pstm.setDate(4, new Date(emprestimo.getData_devolucao().toDateTime().plusDays(emprestimo.getDiasParaDevolucao()).getMillis()));
                pstm.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
