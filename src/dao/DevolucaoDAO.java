/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Instant;

/**
 *
 * @author Everton
 */
public class DevolucaoDAO {
    
    public static final String sqlDevolucao = "insert into devolucao(exemplar_id, usuario_id, data_devolucao, operador_idoperador) values(?, ? , ?, ?)";

    public void salvarDevolucao(int usuario_id, int exemplar_id, int id, LocalDateTime now) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlDevolucao);
            pstm.setInt(1, exemplar_id);
            pstm.setInt(2, usuario_id);
            pstm.setDate(3, new Date(Instant.now().getMillis()));
            pstm.setInt(4, id);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
