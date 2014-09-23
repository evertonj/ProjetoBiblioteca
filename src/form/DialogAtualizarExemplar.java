/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.ExemplarDAO;
import entity.Exemplar;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import table.ExemplarColumnModel;
import table.ExemplarTableModel;
import validarJtextField.LetrasPermitidas;

/**
 *
 * @author Alex
 */
public class DialogAtualizarExemplar extends javax.swing.JDialog {

    ExemplarDAO dao = new ExemplarDAO();
    List<Exemplar> listaDeExemplar;
    Exemplar exemplar;

    public void DefineDadosEAjustesNajTable() {
        tbAlterarExemplar.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = tbAlterarExemplar.getFontMetrics(tbAlterarExemplar.getFont());
        tbAlterarExemplar.setColumnModel(new ExemplarColumnModel(fm));
        tbAlterarExemplar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbAlterarExemplar.setModel(new ExemplarTableModel(listaDeExemplar));
    }

    /**
     * Creates new form DialogAtualizarObra
     */
    public DialogAtualizarExemplar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tfFornecedor.setDocument(new LetrasPermitidas());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlterarExemplar = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btPesquisarPorFornecedor = new javax.swing.JButton();
        tfTitulo = new javax.swing.JTextField();
        tfFornecedor = new javax.swing.JTextField();
        btPesquisarPorTitulo = new javax.swing.JButton();
        btPesquisarPorDataCadastro = new javax.swing.JButton();
        btPesquisarPorDataAquisicao = new javax.swing.JButton();
        dcDataCadastro = new com.toedter.calendar.JDateChooser();
        dcDataAquisicao = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Exemplar");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 4));

        tbAlterarExemplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbAlterarExemplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAlterarExemplarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAlterarExemplar);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAtualizar, btVoltar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAtualizar, btVoltar});

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Consultar por Titulo da Obra.......:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Consultar por Data de Cadastro.:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Consultar por Fornecedor...........:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Consultar por Data de Aquisição:");

        btPesquisarPorFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorFornecedorActionPerformed(evt);
            }
        });

        tfTitulo.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tfTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTituloKeyReleased(evt);
            }
        });

        tfFornecedor.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tfFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFornecedorKeyReleased(evt);
            }
        });

        btPesquisarPorTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorTituloActionPerformed(evt);
            }
        });

        btPesquisarPorDataCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorDataCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorDataCadastroActionPerformed(evt);
            }
        });

        btPesquisarPorDataAquisicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorDataAquisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorDataAquisicaoActionPerformed(evt);
            }
        });

        dcDataCadastro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dcDataCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dcDataCadastroKeyReleased(evt);
            }
        });

        dcDataAquisicao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dcDataAquisicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dcDataAquisicaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(dcDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPesquisarPorDataAquisicao)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tfFornecedor)
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(dcDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPesquisarPorDataCadastro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btPesquisarPorFornecedor))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisarPorTitulo)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPesquisarPorTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfFornecedor)
                        .addComponent(jLabel5))
                    .addComponent(btPesquisarPorFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcDataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPesquisarPorDataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btPesquisarPorDataAquisicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcDataAquisicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dcDataAquisicao, dcDataCadastro, tfFornecedor});

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

    private void tbAlterarExemplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAlterarExemplarMouseClicked
        int rowIndex = tbAlterarExemplar.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Exemplar a ser Alterado!!!");
            return;
        }
        exemplar = new ExemplarTableModel(listaDeExemplar).get(rowIndex);
    }//GEN-LAST:event_tbAlterarExemplarMouseClicked

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        int rowIndex = tbAlterarExemplar.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Exemplar a ser Alterado!!!");
            return;
        }
        exemplar = new ExemplarTableModel(listaDeExemplar).get(rowIndex);
        DialogUpdateExemplar du = new DialogUpdateExemplar(new javax.swing.JFrame(), true);
        DialogUpdateExemplar.exemplar = exemplar;
        DialogUpdateExemplar.setDados();
        du.setVisible(true);
        DefineDadosEAjustesNajTable();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btPesquisarPorFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorFornecedorActionPerformed
        this.pesquisarPorFornecedor();
        tfFornecedor.setText(null);
    }//GEN-LAST:event_btPesquisarPorFornecedorActionPerformed

    private void btPesquisarPorDataCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorDataCadastroActionPerformed
        this.pesquisarPorDataCadastro();
        dcDataCadastro.setDate(null);
    }//GEN-LAST:event_btPesquisarPorDataCadastroActionPerformed

    private void btPesquisarPorDataAquisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorDataAquisicaoActionPerformed
        this.pesquisarPorDataAquisicao();
        dcDataAquisicao.setDate(null);
    }//GEN-LAST:event_btPesquisarPorDataAquisicaoActionPerformed

    private void btPesquisarPorTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorTituloActionPerformed
        this.pesquisarPorTitulo();
        tfTitulo.setText(null);
    }//GEN-LAST:event_btPesquisarPorTituloActionPerformed

    private void tfTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTituloKeyReleased
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            this.pesquisarPorTitulo();
            tfTitulo.setText(null);
        }
    }//GEN-LAST:event_tfTituloKeyReleased

    private void tfFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFornecedorKeyReleased
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            this.pesquisarPorFornecedor();
            tfFornecedor.setText(null);
        }
    }//GEN-LAST:event_tfFornecedorKeyReleased

    private void dcDataCadastroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcDataCadastroKeyReleased
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            this.pesquisarPorDataCadastro();
            dcDataCadastro.setDate(null);
        }
    }//GEN-LAST:event_dcDataCadastroKeyReleased

    private void dcDataAquisicaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcDataAquisicaoKeyReleased
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            this.pesquisarPorDataAquisicao();
            dcDataAquisicao.setDate(null);
        }
    }//GEN-LAST:event_dcDataAquisicaoKeyReleased

    private void pesquisarPorFornecedor() {
        if (!tfFornecedor.getText().isEmpty()) {
            try {
                listaDeExemplar = dao.buscar(tfFornecedor.getText());
                if (listaDeExemplar.isEmpty()) {
                     tbAlterarExemplar.setModel(new DefaultTableModel());
                     JOptionPane.showMessageDialog(this, "A Busca Não Encontrou Nenhum Valor!!!");
                     return;
                 }
//            for (int i = 0; i < listaDeExemplar.size(); i++) {
//                System.out.println("Exemplar: "+listaDeExemplar.get(i));
//            }
                DefineDadosEAjustesNajTable();
            } catch (SQLException ex) {
                Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Digite o Nome do Fornecedor!");
        }
    }
    
    private void pesquisarPorDataCadastro() {
        if (dcDataCadastro.getDate() != null) {
             try {
                listaDeExemplar = dao.buscarDataCadastro(dcDataCadastro.getDate());
                 if (listaDeExemplar.isEmpty()) {
                     tbAlterarExemplar.setModel(new DefaultTableModel());
                     JOptionPane.showMessageDialog(this, "A Busca Não Encontrou Nenhum Valor!!!");
                     return;
                 }
//            for (int i = 0; i < listaDeExemplar.size(); i++) {
//                System.out.println("Exemplar: "+listaDeExemplar.get(i));
//            }
                DefineDadosEAjustesNajTable();
            } catch (SQLException ex) {
                Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione Uma Data!");
        }
    }
    
    private void pesquisarPorDataAquisicao() {
        if (dcDataAquisicao.getDate() != null) {
             try {
                listaDeExemplar = dao.buscarDataAquisicao(dcDataAquisicao.getDate());
                 if (listaDeExemplar.isEmpty()) {
                     tbAlterarExemplar.setModel(new DefaultTableModel());
                     JOptionPane.showMessageDialog(this, "A Busca Não Encontrou Nenhum Valor!!!");
                     return;
                 }
//            for (int i = 0; i < listaDeExemplar.size(); i++) {
//                System.out.println("Exemplar: "+listaDeExemplar.get(i));
//            }
                DefineDadosEAjustesNajTable();
            } catch (SQLException ex) {
                Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione Uma Data!");
        }
    }
    
    private void pesquisarPorTitulo() {
        if (!tfTitulo.getText().isEmpty()) {
             try {
                listaDeExemplar = dao.buscarTitulo(tfTitulo.getText());
                 if (listaDeExemplar.isEmpty()) {
                     tbAlterarExemplar.setModel(new DefaultTableModel());
                     JOptionPane.showMessageDialog(this, "A Busca Não Encontrou Nenhum Valor!!!");
                     return;
                 }
//            for (int i = 0; i < listaDeExemplar.size(); i++) {
//                System.out.println("Exemplar: "+listaDeExemplar.get(i));
//            }
                DefineDadosEAjustesNajTable();
            } catch (SQLException ex) {
                Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Digite o Título da Obra!");
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAtualizarExemplar dialog = new DialogAtualizarExemplar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btPesquisarPorDataAquisicao;
    private javax.swing.JButton btPesquisarPorDataCadastro;
    private javax.swing.JButton btPesquisarPorFornecedor;
    private javax.swing.JButton btPesquisarPorTitulo;
    private javax.swing.JButton btVoltar;
    private com.toedter.calendar.JDateChooser dcDataAquisicao;
    private com.toedter.calendar.JDateChooser dcDataCadastro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAlterarExemplar;
    private javax.swing.JTextField tfFornecedor;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}
