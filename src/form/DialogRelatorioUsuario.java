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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import relatorios.Relatorio;

/**
 *
 * @author Thiago
 */
public class DialogRelatorioUsuario extends javax.swing.JDialog {

    /**
     * Creates new form DialogRelatorio
     */
    public DialogRelatorioUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitaCampos();
        cbSituacao.setEnabled(false);
    }
    private String stringConnect, stringRel;
    private Cursor cursor;
    Relatorio relatorio = new Relatorio();

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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        btGerar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cbTipo = new javax.swing.JComboBox();
        tfLetra = new javax.swing.JTextField();
        checkTipo = new javax.swing.JCheckBox();
        checkLetra = new javax.swing.JCheckBox();
        checkSituacao = new javax.swing.JCheckBox();
        cbSituacao = new javax.swing.JComboBox();

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

        jRadioButton3.setText("jRadioButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 4, true), "Relatório de Usuários"));
        jPanel1.setAutoscrolls(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 4));

        btVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btGerar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btGerar.setText("Gerar");
        btGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 4));

        cbTipo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Série" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        checkTipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkTipo.setText("Ordenar por:");
        checkTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTipoActionPerformed(evt);
            }
        });

        checkLetra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkLetra.setText("Por letra");
        checkLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLetraActionPerformed(evt);
            }
        });

        checkSituacao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkSituacao.setText("Selecionar situação");
        checkSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSituacaoActionPerformed(evt);
            }
        });

        cbSituacao.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO", "SUSPENSE" }));
        cbSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSituacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkTipo)
                    .addComponent(checkLetra)
                    .addComponent(checkSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbSituacao, 0, 125, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbTipo, 0, 125, Short.MAX_VALUE)
                        .addComponent(tfLetra)))
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkTipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkLetra))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkSituacao)
                    .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
       // try {

            if (checkTipo.isSelected() && !checkSituacao.isSelected()) {
                if (relatorio.defineStringConnect("Usuario" + cbTipo.getSelectedItem().toString())) {
                    chamaRelatorio();
                }
            }
            if(checkTipo.isSelected()&& checkSituacao.isSelected()){
                relatorioTipoSituacao();
            }
            if (checkLetra.isSelected() && !checkSituacao.isSelected()) {
                if(tfLetra.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Campo letra nao pode ser vazio");
                }else{
                    relatorioLetra();
                }
             
            }
            if(checkLetra.isSelected() && checkSituacao.isSelected()){
                if(tfLetra.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Campo letra nao pode ser vazio");
                }else{
                    relatorioLetraSituacao();
                }
            }
            if(checkSituacao.isSelected() && !checkLetra.isSelected() && !checkTipo.isSelected()){
                relatorioSituacao();
            }
           
        //} catch (NullPointerException e) {
          //  JOptionPane.showMessageDialog(this, "Nenhum dado cadastrado");
        //} catch (Exception e) {
           // JOptionPane.showMessageDialog(this, "Ocorreu um erro");
        //}


    }//GEN-LAST:event_btGerarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void checkLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLetraActionPerformed
        if (checkLetra.isSelected()) {
            checkTipo.setSelected(false);
            cbTipo.setEnabled(false);

            tfLetra.setEnabled(true);
        } else {
            desabilitaCampos();
        }

    }//GEN-LAST:event_checkLetraActionPerformed

    private void checkSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSituacaoActionPerformed
        if (checkSituacao.isSelected()) {
            cbSituacao.setEnabled(true);

        } else {
            cbSituacao.setEnabled(false);
        }
    }//GEN-LAST:event_checkSituacaoActionPerformed

    private void cbSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSituacaoActionPerformed

    private void checkTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTipoActionPerformed
        if (checkTipo.isSelected()) {
            checkLetra.setSelected(false);
            tfLetra.setEnabled(false);
            cbTipo.setEnabled(true);
        } else {
            desabilitaCampos();
        }
    }//GEN-LAST:event_checkTipoActionPerformed
    public void desabilitaCampos() {
        tfLetra.setEnabled(false);

        cbTipo.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(DialogRelatorioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogRelatorioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogRelatorioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogRelatorioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogRelatorioUsuario dialog = new DialogRelatorioUsuario(new javax.swing.JFrame(), true);
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

    private void chamaRelatorio() {
        try {
            System.out.println(relatorio.getStringConnect());
            System.out.println(relatorio.getStringRel());
            cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            setCursor(cursor);
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstm = null;

            pstm = conn.prepareStatement(relatorio.getStringConnect());

            HashMap params = new HashMap();
            InputStream stream = getClass().getResourceAsStream(relatorio.getStringRel());
            JRResultSetDataSource relatResul = new JRResultSetDataSource(pstm.executeQuery());
            JasperPrint jpPrint = JasperFillManager.fillReport(stream, params, relatResul);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(DialogRelatorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DialogRelatorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
            setCursor(cursor);
        }
    }
    
    
   
    private void chamarRelatorio(){  
        JasperPrint rel = null;  
          Map parametros = new HashMap(); 
         
         
        parametros.put("nome", tfLetra.getText());  
         Connection conn = DBConnection.getConnection();
        try {
           
            rel = JasperFillManager.fillReport("\\relatorios\\RelatorioUsuario.jasper", parametros, conn);//tem q criar a classe conexao!  
       
        JasperViewer jv = new JasperViewer(rel, false);  
        jv.setExtendedState(jv.MAXIMIZED_BOTH);  
        jv.setVisible(true);  
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }  
     public void relatorioLetra () {
        try {
            Connection conn = DBConnection.getConnection();
            InputStream is = getClass().getResourceAsStream("/relatorios/RelatorioUsuario.jasper");
            HashMap map = new HashMap();
            String nome = tfLetra.getText();
            map.put("nome", nome);
            
            JasperPrint rel = JasperFillManager.fillReport(is, map, conn);
            JasperViewer viewer = new JasperViewer(rel, false);
            viewer.setLocationRelativeTo(null);
          
            viewer.setVisible(true);
            viewer.setZoomRatio((float) 1);
            viewer.toFront();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
     }
     public void relatorioLetraSituacao () {
        try {
            Connection conn = DBConnection.getConnection();
            InputStream is = getClass().getResourceAsStream("/relatorios/RelatorioUsuarioLetraSituacao.jasper");
            HashMap map = new HashMap();
            String nome = tfLetra.getText();
            map.put("nome", nome);
            map.put("situacao", cbSituacao.getSelectedItem().toString());
            
            JasperPrint rel = JasperFillManager.fillReport(is, map, conn);
            JasperViewer viewer = new JasperViewer(rel, false);
            viewer.setLocationRelativeTo(null);
          
            viewer.setVisible(true);
            viewer.setZoomRatio((float) 1);
            viewer.toFront();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
     }
      public void relatorioTipoSituacao () {
        try {
            Connection conn = DBConnection.getConnection();
            InputStream is = getClass().getResourceAsStream("/relatorios/RelatorioUsuarioTipoSituacao.jasper");
            HashMap map = new HashMap();
            String tipo = cbTipo.getSelectedItem().toString();
            map.put("tipo", tipo);
            map.put("situacao", cbSituacao.getSelectedItem().toString());
            
            JasperPrint rel = JasperFillManager.fillReport(is, map, conn);
            JasperViewer viewer = new JasperViewer(rel, false);
            viewer.setLocationRelativeTo(null);
          
            viewer.setVisible(true);
            viewer.setZoomRatio((float) 1);
            viewer.toFront();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
     }
       public void relatorioSituacao () {
        try {
            Connection conn = DBConnection.getConnection();
            InputStream is = getClass().getResourceAsStream("/relatorios/RelatorioUsuarioSituacao.jasper");
            HashMap map = new HashMap();
           
           
            map.put("situacao", cbSituacao.getSelectedItem().toString());
            
            JasperPrint rel = JasperFillManager.fillReport(is, map, conn);
            JasperViewer viewer = new JasperViewer(rel, false);
            viewer.setLocationRelativeTo(null);
          
            viewer.setVisible(true);
            viewer.setZoomRatio((float) 1);
            viewer.toFront();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGerar;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JCheckBox checkLetra;
    private javax.swing.JCheckBox checkSituacao;
    private javax.swing.JCheckBox checkTipo;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField tfLetra;
    // End of variables declaration//GEN-END:variables
}
