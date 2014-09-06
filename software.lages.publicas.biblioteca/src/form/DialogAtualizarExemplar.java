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
public class DialogAtualizarExemplar extends javax.swing.JDialog {

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
    public DialogAtualizarExemplar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        tfObra = new javax.swing.JTextField();
        btPesquisarPorTitulo = new javax.swing.JButton();
        btPesquisarPorIsbn = new javax.swing.JButton();
        btPesquisarPorCodigo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAtualizarObra = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btPesquisarPorAutor = new javax.swing.JButton();
        tfFornecedor = new javax.swing.JTextField();
        dcDataDeCadastro = new com.toedter.calendar.JDateChooser();
        dcDataDeAquisicao = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Obra");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 4));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Consultar por Obra.......................:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Consultar por Data de Cadastro.:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Consultar por Data de Aquisição:");

        tfObra.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N

        btPesquisarPorTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorTitulo.setMinimumSize(new java.awt.Dimension(49, 22));
        btPesquisarPorTitulo.setPreferredSize(new java.awt.Dimension(49, 22));
        btPesquisarPorTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorTituloActionPerformed(evt);
            }
        });

        btPesquisarPorIsbn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorIsbn.setMinimumSize(new java.awt.Dimension(49, 22));
        btPesquisarPorIsbn.setPreferredSize(new java.awt.Dimension(49, 22));
        btPesquisarPorIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorIsbnActionPerformed(evt);
            }
        });

        btPesquisarPorCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorCodigo.setMinimumSize(new java.awt.Dimension(49, 22));
        btPesquisarPorCodigo.setPreferredSize(new java.awt.Dimension(49, 22));
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

        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        jButton6.setText("Atualizar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btVoltar, jButton6});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btVoltar, jButton6});

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Consultar por Fornecedor...........:");

        btPesquisarPorAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search16x16.png"))); // NOI18N
        btPesquisarPorAutor.setMinimumSize(new java.awt.Dimension(49, 22));
        btPesquisarPorAutor.setPreferredSize(new java.awt.Dimension(49, 22));
        btPesquisarPorAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorAutorActionPerformed(evt);
            }
        });

        tfFornecedor.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N

        dcDataDeCadastro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        dcDataDeAquisicao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dcDataDeAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dcDataDeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisarPorIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfObra, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btPesquisarPorAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPesquisarPorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfFornecedor, tfObra});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfObra)
                        .addComponent(jLabel2))
                    .addComponent(btPesquisarPorTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisarPorAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(tfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisarPorIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(dcDataDeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(dcDataDeAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btPesquisarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dcDataDeAquisicao, dcDataDeCadastro, tfFornecedor});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btPesquisarPorAutor, btPesquisarPorCodigo, btPesquisarPorIsbn, btPesquisarPorTitulo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btPesquisarPorTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorTituloActionPerformed
        try {
            listaDeObra = dao.consulta(tfObra.getText());
            if (listaDeObra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A Consulta Não Encontrou Nenhum Resultado.");
            } else {
                this.DefineDadosEAjustesNajTable();
                tbAtualizarObra.setModel(new ObraAtualizarTableModel(listaDeObra));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NameException ex) {
            Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DialogNovaObra novaObra = new DialogNovaObra(new javax.swing.JFrame(), true);
        novaObra.setDados(obra);
        novaObra.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btPesquisarPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorCodigoActionPerformed
//        try {
//            if (!tfCodigo.getText().isEmpty()) {
//                listaDeObra = dao.consultaPorCodigo(Integer.parseInt(tfCodigo.getText()));
//                if (listaDeObra.isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "A Consulta Não Encontrou Nenhum Resultado.");
//                } else {
//                    this.DefineDadosEAjustesNajTable();
//                    tbAtualizarObra.setModel(new ObraAtualizarTableModel(listaDeObra));
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Favor Informe o Código da Obra.");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NameException ex) {
//            Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btPesquisarPorCodigoActionPerformed

    private void btPesquisarPorAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorAutorActionPerformed
        try {
            if (!tfFornecedor.getText().isEmpty()) {
                listaDeObra = dao.consultaAutor(tfFornecedor.getText());
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
            Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NameException ex) {
            Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarPorAutorActionPerformed

    private void btPesquisarPorIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorIsbnActionPerformed
//        try {
//            if (!tfDataDeCadastro.getText().isEmpty()) {
//                listaDeObra = dao.consultaIsbn(tfDataDeCadastro.getText());
//                if (listaDeObra.isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "A Consulta Não Encontrou Nenhum Resultado.");
//                } else {
//                    this.DefineDadosEAjustesNajTable();
//                    tbAtualizarObra.setModel(new ObraAtualizarTableModel(listaDeObra));
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Favor Informe o ISBN da Obra.");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NameException ex) {
//            Logger.getLogger(DialogAtualizarExemplar.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
    private javax.swing.JButton btPesquisarPorAutor;
    private javax.swing.JButton btPesquisarPorCodigo;
    private javax.swing.JButton btPesquisarPorIsbn;
    private javax.swing.JButton btPesquisarPorTitulo;
    private javax.swing.JButton btVoltar;
    private com.toedter.calendar.JDateChooser dcDataDeAquisicao;
    private com.toedter.calendar.JDateChooser dcDataDeCadastro;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAtualizarObra;
    private javax.swing.JTextField tfFornecedor;
    private javax.swing.JTextField tfObra;
    // End of variables declaration//GEN-END:variables
}