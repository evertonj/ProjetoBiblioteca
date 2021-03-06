/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import connection.DBConnection;
import java.awt.Cursor;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Thiago
 */
public class DialogRelatorio extends javax.swing.JDialog {

    /**
     * Creates new form DialogRelatorio
     */
    public DialogRelatorio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private String stringConnect, stringRel;
    private Cursor cursor;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbTipo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btGerar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 4, true));
        jPanel1.setAutoscrolls(true);

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Autor", "Editora", "Usuário" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de relatório ");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 4));

        btGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btGerar.setText("Gerar");
        btGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarActionPerformed(evt);
            }
        });

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoActionPerformed

    private void btGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarActionPerformed
        try {

            if (defineStringConnect(cbTipo.getSelectedItem().toString())) {
                chamaRelatorio();
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Nenhum dado cadastrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro");
        }


    }//GEN-LAST:event_btGerarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogRelatorio dialog = new DialogRelatorio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private boolean defineStringConnect(String tipo) {
        if (tipo.equals("Autor")) {
            stringConnect = "select * from autor;";
            stringRel = "/relatorios/RelatorioAutor.jasper";
            return true;
        } else if (tipo.equals("Editora")) {
            stringConnect = "select * from editora;";
            stringRel = "/relatorios/RelatorioEditoras.jasper";
            return true;
        } else if (tipo.equals("Usuário")) {
            stringConnect = "SELECT DISTINCT\n"
                    + "     usuario.`id`,email_usuario.`id`, telefone_usuario.`numero`, email_usuario.`email`,email_usuario.`idUsuario`,\n"
                    + "     usuario.`nome` AS usuario_nome,\n"
                    + "     usuario.`serie` AS usuario_serie,\n"
                    + "     usuario.`foto` AS usuario_foto,\n"
                    + "     telefone_usuario.`numero` AS telefone_usuario_numero,\n"
                    + "     email_usuario.`id` AS email_usuario_id,\n"
                    + "     email_usuario.`email` AS email_usuario_email,\n"
                    + "     email_usuario.`idUsuario` AS email_usuario_idUsuario,\n"
                    + "     email_usuario_A.`email` AS email_usuario_A_email,\n"
                    + "     usuario.`id` AS usuario_id\n"
                    + "FROM\n"
                    + "     `usuario` usuario INNER JOIN `telefone_usuario` telefone_usuario ON usuario.`id` = telefone_usuario.`idUsuario`\n"
                    + "     left JOIN `email_usuario` email_usuario ON usuario.`id` = email_usuario.`idUsuario`\n"
                    + "     INNER JOIN `email_usuario` email_usuario_A ON usuario.`id` = email_usuario_A.`idUsuario` GROUP BY usuario.`id` order by usuario.`serie`";
            stringRel = "/relatorios/RelatorioUsuario.jasper";
            return true;
        } else if (tipo.equals("Obra")) {
            stringConnect = "SELECT\n"
                    + "     obra_autor.`id` AS obra_autor_id,\n"
                    + "     obra_autor.`idobra` AS obra_autor_idobra,\n"
                    + "     obra_autor.`idautor` AS obra_autor_idautor,\n"
                    + "     autor.`id` AS autor_id,\n"
                    + "     autor.`nome` AS autor_nome,\n"
                    + "     autor.`sobrenome` AS autor_sobrenome,\n"
                    + "     obra.`id` AS obra_id,\n"
                    + "     obra.`titulo` AS obra_titulo,\n"
                    + "     obra.`edicao` AS obra_edicao,\n"
                    + "     obra.`ano` AS obra_ano,\n"
                    + "     obra.`isbn` AS obra_isbn,\n"
                    + "     obra.`foto` AS obra_foto,\n"
                    + "     obra.`id_editora` AS obra_id_editora,\n"
                    + "     obra.`idassunto` AS obra_idassunto,\n"
                    + "     exemplar.`id` AS exemplar_id,\n"
                    + "     exemplar.`dataDeCadastro` AS exemplar_dataDeCadastro,\n"
                    + "     exemplar.`fornecedor` AS exemplar_fornecedor,\n"
                    + "     exemplar.`dataDeAquisicao` AS exemplar_dataDeAquisicao,\n"
                    + "     exemplar.`numero_sequencial` AS exemplar_numero_sequencial,\n"
                    + "     exemplar.`situacao` AS exemplar_situacao,\n"
                    + "     exemplar.`id_obra` AS exemplar_id_obra,\n"
                    + "     exemplar.`descricao` AS exemplar_descricao,\n"
                    + "     editora.`id` AS editora_id,\n"
                    + "     editora.`nome` AS editora_nome,\n"
                    + "     editora.`telefone` AS editora_telefone,\n"
                    + "     editora.`email` AS editora_email,\n"
                    + "     editora.`cidade` AS editora_cidade,\n"
                    + "     editora.`rua` AS editora_rua,\n"
                    + "     editora.`bairro` AS editora_bairro,\n"
                    + "     editora.`numero` AS editora_numero\n"
                    + "FROM\n"
                    + "     `autor` autor INNER JOIN `obra_autor` obra_autor ON autor.`id` = obra_autor.`idautor`\n"
                    + "     INNER JOIN `obra` obra ON obra_autor.`idobra` = obra.`id`,\n"
                    + "     `exemplar` exemplar,\n"
                    + "     `editora` editora\n"
                    + "GROUP BY obra.`titulo`\n"
                    + "Order by obra.`titulo`";
            stringRel = "/relatorios/RelatorioObra.jasper";
            return true;
        } else {
            return false;
        }

    }

    private void chamaRelatorio() {
        try {

            cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            setCursor(cursor);
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = null;
            int result = 0;

            pstm = conn.prepareStatement(stringConnect);

            HashMap params = new HashMap();

            InputStream stream = getClass().getResourceAsStream(stringRel);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(pstm.executeQuery());
            JasperPrint jpPrint = JasperFillManager.fillReport(stream, params, relatResul);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(DialogRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DialogRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
            setCursor(cursor);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGerar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
