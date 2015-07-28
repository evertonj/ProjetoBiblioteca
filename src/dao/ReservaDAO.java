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
import entity.ExcluirEmprestimo;
import entity.Obra;
import entity.Reserva;
import entity.Telefone;
import entity.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Dictionary;
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
    private static String sqlEmails = "select usuario_id from reserva where obra_id = ?";
    private static String sqlTelefones = "select * from telefone_usuario where idUsuario = ?";
    private static String sqlExcluirReserva = "delete from reserva where idreserva = ?";
    private static String sqlConsultaReserva = "select * from reserva where obra_id = ?";

    public void FazerReserva(Reserva reserva) {
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlReserva);
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

    public List<Reserva> ListaReserva(int usuarioOuObra, String pesquisa) {
        List<Reserva> listaReserva = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        if (usuarioOuObra == 0) {
            sqlListaReserva = "SELECT * FROM reserva r, obra o, usuario u WHERE o.titulo like ? and r.obra_id = o.id and r.usuario_id = u.id";
        } else {
            sqlListaReserva = "SELECT * FROM reserva r, obra o, usuario u WHERE u.nome like ? and r.obra_id = o.id and r.usuario_id = u.id";
        }
        try {
            PreparedStatement pstm = con.prepareStatement(sqlListaReserva);
            pstm.setString(1, pesquisa + "%");
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

    private Obra retornObra(int id) {
        Obra obra = new Obra();
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement(sqlObra);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {
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

    private Usuario returnUsuario(int id) {
        Usuario usuario = new Usuario();
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlUsuario);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {
                usuario.setDataCadastro(new Date(rs.getDate("DataCadastro").getTime()));
                usuario.setSituacao(EnumSituacaoUsuario.getSituacao(rs.getString("situacao")));
                usuario.setSerie(rs.getString("serie"));
                usuario.setId(id);
                usuario.setNome(rs.getString("nome"));
                usuario.setListEmail(returnEmailsUser(id));
                usuario.setListTelefone(returnTelefones(id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public List<Email> returnEmailsUser(int id) {
        List<Email> emails = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement("select * from email_usuario where idUsuario = ?");
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

    private Assunto returnAssunto(int id) {
        Assunto assunto = new Assunto();
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlAssunto);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {
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
        Connection con = DBConnection.getConnection();
        int idUsuario = 0;
        try {
            PreparedStatement pstm1 = con.prepareStatement(sqlEmails);
            pstm1.setInt(1, id);
            ResultSet rs1 = pstm1.executeQuery();
            if (rs1.first()) {
                idUsuario = rs1.getInt("usuario_id");
                PreparedStatement pstm = con.prepareStatement("select * from email_usuario where idUsuario = " + idUsuario);
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    Email email = new Email();
                    email.setId(rs.getInt("id"));
                    email.setEmail(rs.getString("email"));
                    emails.add(email);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emails;
    }

    private List<Telefone> returnTelefones(int id) {
        List<Telefone> telefones = new ArrayList<>();
        Connection con = DBConnection.getConnection();
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
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sqlExcluirReserva);
        pstm.setInt(1, id);
        pstm.execute();
    }

    public boolean verificaSeExisteReserva(int idObra) {
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sqlConsultaReserva);
            pstm.setInt(1, idObra);
            ResultSet rs = pstm.executeQuery();
            return rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Usuario returnUsuarioPelaObra(int idObra) {
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm;
        int idUsuario = 0;
        try {
            pstm = con.prepareStatement(sqlConsultaReserva);
            pstm.setInt(1, idObra);
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {
                idUsuario = rs.getInt("usuario_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnUsuario(idUsuario);
    }

    public String buscaEmaileTelefone(int idUsuario) {
        String sqlTelefone = "select numero from telefone_usuario where idUsuario = ?";
        String sqlEmail = "select email from email_usuario where idUsuario = ?";
        List<String> emails = new ArrayList<>();
        List<String> telefones = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm, pstmTel;
        try {
            pstm = con.prepareStatement(sqlEmail);
            pstm.setInt(1, idUsuario);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                emails.add(rs.getString("email"));
            }
            pstmTel = con.prepareStatement(sqlTelefone);
            pstmTel.setInt(1, idUsuario);
            ResultSet rsTel = pstmTel.executeQuery();
            while (rsTel.next()) {
                telefones.add(rsTel.getString("numero"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dadosDoAluno = "Telefone(s): ";
        for (String telefone : telefones) {
            dadosDoAluno += telefone + "\n";
        }
        dadosDoAluno += "E-mail(s): ";
        for (String email : emails) {
            dadosDoAluno += email + "\n";
        }
        return dadosDoAluno;
    }

    public void adicionaPrioridadeDeEmprestimo(ExcluirEmprestimo empexcluso) {
        Connection con = DBConnection.getConnection();
        try {
            LocalDateTime dataFinal = LocalDateTime.now();
            PreparedStatement pstm1 = null;
            PreparedStatement pstm = con.prepareStatement("insert into prioridade_emprestimo(data_final, usuario_id) values(?, ?)");
            if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
                dataFinal.plusDays(4);
            }
            if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                dataFinal.plusDays(5);
            }
            pstm1 = con.prepareStatement("select usuario_id from reserva");
            ResultSet rs = pstm1.executeQuery();
            rs.first();
            pstm.setTimestamp(1, Timestamp.valueOf(dataFinal));
            int idUser = rs.getInt("usuario_id");
            pstm.setInt(2, idUser);
            pstm.execute();
            pstm = con.prepareStatement("delete from reserva where usuario_id = ?");
            pstm.setInt(1, idUser);
            pstm.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verificaObraReservada(Usuario user) {
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement("select * from prioridade_emprestimo");
            ResultSet rs = pstm.executeQuery();
            if (rs.first()) {
                LocalDateTime data = rs.getTimestamp("data_final").toLocalDateTime();
                int idUser = rs.getInt("usuario_id");
                if (data.isBefore(LocalDate.now().atStartOfDay())) {
                    pstm = con.prepareStatement("delete from prioridade_emprestimo where usuario_id = ?");
                    pstm.setInt(1, idUser);
                    pstm.execute();
                    return false;
                } else {
                    return idUser != user.getId();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int quantidadeDePrioridadeEmprestimo() {
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm;
        int cont = 0;
        try {
            pstm = con.prepareStatement("select * from prioridade_emprestimo");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                cont++;
            }
            return cont;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void deletaPrioridadeReserva(int id) {
        Connection con = DBConnection.getConnection();
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement("delete from prioridade_emprestimo where usuario_id = ?");
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void atualizaReservasUltrapassadas() {
        LocalDate dataAtual = LocalDate.now(ZoneId.systemDefault());
        Connection con = DBConnection.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement("delete from prioridade_emprestimo where data_final < ?");
            pstm.setDate(1, Date.valueOf(dataAtual));
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
