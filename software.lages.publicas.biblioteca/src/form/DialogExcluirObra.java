/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.ObraDAO;
import entity.Obra;
import entity.exceptions.NameException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import table.ObraAtualizarTableModel;
import table.ObraColumnModel;
import validarJtextField.LetrasPermitidas;
import validarJtextField.NumerosPermitidos;
import validarJtextField.SomenteNumero;

/**
 *
 * @author Alex
 */
public class DialogExcluirObra extends javax.swing.JDialog {

    ObraDAO dao = new ObraDAO();
    List<Obra> listaDeObra = new ArrayList<>();

    public void DefineDadosEAjustesNajTable() {
        tbAtualizarObra.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = tbAtualizarObra.getFontMetrics(tbAtualizarObra.getFont());
        tbAtualizarObra.setColumnModel(new ObraColumnModel(fm));
        tbAtualizarObra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Creates new form DialogAtualizarObra
     */
    public DialogExcluirObra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tfAutor.setDocument(new LetrasPermitidas());
        tfIsbn.setDocument(new SomenteNumero());
        tfCodigo.setDocument(new SomenteNumero());
    }
    Obra obra;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        btPesquisarPorTitulo = new javax.swing.JButton();
        btPesquisarPorIsbn = new javax.swing.JButton();
        btPesquisarPorCodigo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAtualizarObra = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btPesquisarPorAutor = new javax.swing.JButton();
        tfAutor = new javax.swing.JTextField();
        tfIsbn = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Obra");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 4));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Consultar por Titulo:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Consultar por ISBN:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Consultar por Código:");

        tfTitulo.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N

        btPesquisarPorTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorTituloActionPerformed(evt);
            }
        });

        btPesquisarPorIsbn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorIsbnActionPerformed(evt);
            }
        });

        btPesquisarPorCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorCodigoActionPerformed(evt);
            }
        });

        tbAtualizarObra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbAtualizarObra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAtualizarObraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAtualizarObra);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btExcluir, btVoltar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btExcluir, btVoltar});

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Consultar por Autor:");

        btPesquisarPorAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorAutorActionPerformed(evt);
            }
        });

        tfAutor.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N

        tfIsbn.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N

        tfCodigo.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisarPorTitulo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfIsbn)
                                    .addComponent(tfAutor)
                                    .addComponent(tfCodigo))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btPesquisarPorIsbn)
                                        .addComponent(btPesquisarPorCodigo))
                                    .addComponent(btPesquisarPorAutor))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPesquisarPorTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTitulo)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btPesquisarPorAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btPesquisarPorIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btPesquisarPorCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btPesquisarPorTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorTituloActionPerformed
        try {
            listaDeObra = dao.consulta(tfTitulo.getText());
            if (listaDeObra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A Consulta Não Encontrou Nenhum Resultado.");
            } else {
                this.DefineDadosEAjustesNajTable();
                tbAtualizarObra.setModel(new ObraAtualizarTableModel(listaDeObra));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogExcluirObra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NameException ex) {
            Logger.getLogger(DialogExcluirObra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarPorTituloActionPerformed

    private void tbAtualizarObraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAtualizarObraMouseClicked
        int rowIndex = tbAtualizarObra.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione a Obra a ser Atualizada!!!");
            return;
        }
        obra = new ObraAtualizarTableModel(listaDeObra).get(rowIndex);
    }//GEN-LAST:event_tbAtualizarObraMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int rowIndex = tbAtualizarObra.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione a Obra a ser Removida!!!");
            return;
        }
        Obra obraRemove = new ObraAtualizarTableModel(listaDeObra).get(rowIndex);
        int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusão ?", "Excluir Obra", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }
        int result = dao.remove(obraRemove.getId());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Obra removida com Sucesso!");
            this.DefineDadosEAjustesNajTable();
            listaDeObra.remove(rowIndex);
            tbAtualizarObra.setModel(new ObraAtualizarTableModel(listaDeObra));
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btPesquisarPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorCodigoActionPerformed
        try {
            if (!tfCodigo.getText().isEmpty()) {
                listaDeObra = dao.consultaPorCodigo(Integer.parseInt(tfCodigo.getText()));
                if (listaDeObra.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "A Consulta Não Encontrou Nenhum Resultado.");
                } else {
                    this.DefineDadosEAjustesNajTable();
                    tbAtualizarObra.setModel(new ObraAtualizarTableModel(listaDeObra));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Favor Informe o Código da Obra.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogExcluirObra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NameException ex) {
            Logger.getLogger(DialogExcluirObra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarPorCodigoActionPerformed

    private void btPesquisarPorAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorAutorActionPerformed
        try {
            if (!tfAutor.getText().isEmpty()) {
                listaDeObra = dao.consultaAutor(tfAutor.getText());
                if (listaDeObra.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "A Consulta Não Encontrou Nenhum Resultado.");
                } else {
                    this.DefineDadosEAjustesNajTable();
                    tbAtualizarObra.setModel(new ObraAtualizarTableModel(listaDeObra));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Favor Informe o Nome do Autor.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogExcluirObra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NameException ex) {
            Logger.getLogger(DialogExcluirObra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarPorAutorActionPerformed

    private void btPesquisarPorIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorIsbnActionPerformed
        try {
            if (!tfIsbn.getText().isEmpty()) {
                listaDeObra = dao.consultaIsbn(tfIsbn.getText());
                if (listaDeObra.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "A Consulta Não Encontrou Nenhum Resultado.");
                } else {
                    this.DefineDadosEAjustesNajTable();
                    tbAtualizarObra.setModel(new ObraAtualizarTableModel(listaDeObra));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Favor Informe o ISBN da Obra.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogExcluirObra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NameException ex) {
            Logger.getLogger(DialogExcluirObra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarPorIsbnActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogExcluirObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogExcluirObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogExcluirObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogExcluirObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogExcluirObra dialog = new DialogExcluirObra(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisarPorAutor;
    private javax.swing.JButton btPesquisarPorCodigo;
    private javax.swing.JButton btPesquisarPorIsbn;
    private javax.swing.JButton btPesquisarPorTitulo;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAtualizarObra;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfIsbn;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}
