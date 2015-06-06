/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import entity.Assunto;
import entity.Email;
import entity.EnumSituacaoUsuario;
import entity.Obra;
import entity.Reserva;
import entity.Telefone;
import entity.Usuario;
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
public class ReservaDAO {
    
    private static final String sqlReserva = "insert into reserva(data_reserva, posicao, usuario_id, obra_id, exemplar_id) values(?, ?, ?, ?, ?)";
    private static String sqlListaReserva;
    private static String sqlObra = "select * from obra where id = ?";
    private static String sqlAssunto = "select * from assunto where id = ?";
    private static String sqlUsuario = "select * from usuario where id = ?";
    private static String sqlEmails = "select * from email_usuario where idUsuario = ?";
    private static String sqlTelefones = "select * from telefone_usuario where idUsuario = ?";
    private static String sqlExcluirReserva = "delete from reserva where idreserva = ?";
    private static String sqlConsultaReserva = "";
    
    public void FazerReserva(Reserva reserva) {
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm  = con.prepareStatement(sqlReserva);
            pstm.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            pstm.setInt(2, reserva.getPosicao());
            pstm.setInt(3, reserva.getUsuario().getId());
            pstm.setInt(4, reserva.getObra().getId());
            pstm.setInt(5, reserva.getIdExemplar());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Reserva> ListaReserva(int usuarioOuObra, String pesquisa){
        List<Reserva> listaReserva = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        if(usuarioOuObra == 0){
            sqlListaReserva = "SELECT * FROM reserva r, obra o, usuario u WHERE o.titulo like ? and r.obra_id = o.id and r.usuario_id = u.id";
        }else {
            sqlListaReserva = "SELECT * FROM reserva r, obra o, usuario u WHERE u.nome like ? and r.obra_id = o.id and r.usuario_id = u.id";
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sqlListaReserva);
            pstm.setString(1, pesquisa+"%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("idreserva"));
                reserva.setPosicao(rs.getInt("posicao"));
                reserva.setDataReserva(rs.getDate("data_reserva").toLocalDate());
                reserva.setObra(retornObra(rs.getInt("obra_id")));
                reserva.setUsuario(returnUsuario(rs.getInt("usuario_id")));
                listaReserva.add(reserva);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReserva;
    }
    
    
    private Obra retornObra(int id){
        Obra obra = new Obra();
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement(sqlObra);
            pstm.setInt(1, id);
            ResultSet  rs = pstm.executeQuery();
            if(rs.first()) {
                obra.setAno(rs.getShort("ano"));
                obra.setAssunto(returnAssunto(rs.getInt("idassunto")));
                obra.setEdicao(rs.getString("edicao"));
                obra.setId(id);
                obra.setTitulo(rs.getString("titulo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obra;
    }
    
    private Usuario returnUsuario(int id){
       Usuario usuario = new Usuario();
       Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlUsuario);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.first()){
                usuario.setDataCadastro(new Date(rs.getDate("DataCadastro").getTime()));
                usuario.setSituacao(EnumSituacaoUsuario.getSituacao(rs.getString("situacao")));
                usuario.setSerie(rs.getString("serie"));
                usuario.setId(id);
                usuario.setNome(rs.getString("nome"));
                usuario.setListEmail(returnEmails(id));
                usuario.setListTelefone(returnTelefones(id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    private Assunto returnAssunto(int id) {
        Assunto assunto = new Assunto();
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlAssunto);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.first()){
                assunto.setId(id);
                assunto.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assunto;
    }

    public List<Email> returnEmails(int id) {
        List<Email> emails = new ArrayList<>();
        Connection con =  DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlEmails);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                Email email = new Email();
                email.setId(rs.getInt("id"));
                email.setEmail(rs.getString("email"));
                emails.add(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emails;
    }
    
    private List<Telefone> returnTelefones(int id) {
        List<Telefone> telefones = new ArrayList<>();
        Connection con =  DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlTelefones);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("id"));
                telefone.setTelefone(rs.getString("numero"));
                telefones.add(telefone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return telefones;
    }

    public void excluirReserva(int id) throws SQLException {
        Connection con =  DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement(sqlExcluirReserva);
            pstm.setInt(1, id);
            pstm.execute();
    }

    public boolean verificaSeExisteReserva(int idExemplar) {
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlConsultaReserva);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
