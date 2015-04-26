/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.InfoDevolucao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Instant;

/**
 *
 * @author Everton
 */
public class DevolucaoDAO {
    
    public static final String sqlDevolucao = "insert into devolucao(exemplar_id, usuario_id, data_devolucao, operador_idoperador) values(?, ? , ?, ?)";
    public static final String sqlBuscarDevolucao = "select u.nome as nomeUsuario, u.serie as serieUsuario, e.numero_sequencial as numeroSequencial, ob.titulo as titulo, d.data_devolucao as dataDevolucao, o.nome as nomeOperador from  devolucao d, exemplar e, operador o, usuario u, obra ob where u.nome like ? and d.exemplar_id = e.id and d.usuario_id = u.id and o.idoperador = d.operador_idoperador and ob.id = e.id_obra;";

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
    
    public List<InfoDevolucao> buscarDevolucao(String nome) {
        List<InfoDevolucao> listaDev = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlBuscarDevolucao);
            pstm.setString(1, nome+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                InfoDevolucao infoDev = new InfoDevolucao();
                infoDev.setNomeUsuario(rs.getString("nomeUsuario"));
                infoDev.setSerieUsuario(rs.getString("serieUsuario"));
                infoDev.setNumeroSequencial(rs.getInt("numeroSequencial"));
                infoDev.setTituloObra(rs.getString("titulo"));
                infoDev.setDataDevolucao(rs.getDate("dataDevolucao").toLocalDate());
                infoDev.setNomeOperador(rs.getString("nomeOperador"));
                listaDev.add(infoDev);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DevolucaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDev;
    }
}
