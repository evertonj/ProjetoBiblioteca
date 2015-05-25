/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.ExemplarObraDAO;
import dao.ReservaDAO;
import entity.EnumSituacaoExemplar;
import entity.ExemplarEmprestimo;
import entity.Reserva;
import entity.Usuario;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultStyledDocument;
import table.ExemplarEmprestimoTableModel;
import table.ExemplarObraColumnModel;
import validadorDeTextField.SomenteNumero;

/**
 *
 * @author Alex
 */
public class DialogSelecionarObra extends javax.swing.JDialog {

    ExemplarObraDAO dao = new ExemplarObraDAO();
    List<ExemplarEmprestimo> listaDeObra = new ArrayList<>();
    public static Usuario user;

    public void DefineDadosEAjustesNajTable() {
        tbAtualizarObra.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = tbAtualizarObra.getFontMetrics(tbAtualizarObra.getFont());
        tbAtualizarObra.setColumnModel(new ExemplarObraColumnModel(fm));
        tbAtualizarObra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbAtualizarObra.setModel(new ExemplarEmprestimoTableModel(listaDeObra));
    }

    /**
     * Creates new form DialogAtualizarObra
     */
    public DialogSelecionarObra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tfTitulo.requestFocus();
    }
    ExemplarEmprestimo exemplarEmprestimo;

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
        tfTitulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAtualizarObra = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btAtualizar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        cbOpcaoPesquisa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exemplares para Emprestimo");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 4));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Consultar por:");

        tfTitulo.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tfTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTituloKeyReleased(evt);
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

        btAtualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btAtualizar.setForeground(new java.awt.Color(0, 102, 204));
        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Book-icon.png"))); // NOI18N
        btAtualizar.setText("Selecionar Obra");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAtualizar, btVoltar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtualizar)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAtualizar, btVoltar});

        cbOpcaoPesquisa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbOpcaoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TITULO", "AUTOR", "ISBN", "CÓDIGO", "ASSUNTO" }));
        cbOpcaoPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOpcaoPesquisaItemStateChanged(evt);
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOpcaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTitulo)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTitulo)
                    .addComponent(jLabel2)
                    .addComponent(cbOpcaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbOpcaoPesquisa, tfTitulo});

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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed
    int contador = 0;
    private void tbAtualizarObraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAtualizarObraMouseClicked
        try {
            int rowIndex = tbAtualizarObra.getSelectedRow();
            if (rowIndex == -1) {
                JOptionPane.showMessageDialog(this, "Selecione a Obra a ser Atualizada!!!");
                return;
            }
            exemplarEmprestimo = new ExemplarEmprestimoTableModel(listaDeObra).get(rowIndex);
        } catch (IndexOutOfBoundsException e) {
            DefineDadosEAjustesNajTable();
        }
        contador++;
        if (contador == 2) {
            atualizar();
            tfTitulo.requestFocus();
            contador = 0;
        }
    }//GEN-LAST:event_tbAtualizarObraMouseClicked

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void atualizar() {
        int disponivel = 0;
        int rowIndex = tbAtualizarObra.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione a Obra a ser Atualizada!!!");
            return;
        }
        exemplarEmprestimo = new ExemplarEmprestimoTableModel(listaDeObra).get(rowIndex);
        if (exemplarEmprestimo.getExemplar().getSituacao() == EnumSituacaoExemplar.EMPRESTADO) {
            for (ExemplarEmprestimo exemplar : listaDeObra) {
                if (exemplar.getExemplar().getSituacao() == EnumSituacaoExemplar.DISPONIVEL) {
                    disponivel++;
                }
            }
            if (disponivel > 0) {
                JOptionPane.showMessageDialog(this, "Selecione um exemplar disponivel");
                return;
            } else {
                int opcao = JOptionPane.showConfirmDialog(this, "Deseja reservar este exemplar", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
                System.out.println(opcao);
                if(opcao == 0) {
                    Reserva reserva = new Reserva();
                    reserva.setDataReserva(LocalDate.now(ZoneId.systemDefault()));
                    reserva.setObra(exemplarEmprestimo.getObra());
                    reserva.setUsuario(this.user);
                    ReservaDAO daoReserva = new ReservaDAO();
                    daoReserva.FazerReserva(reserva);
                }
                return;
            }
            
        }
        if (exemplarEmprestimo.getExemplar().getSituacao() == EnumSituacaoExemplar.DISPONIVEL) {
            if (DialogEmprestimo.setObraNaLista(exemplarEmprestimo)) {
                JOptionPane.showMessageDialog(this, "Um exemplar com este título, já foi adicionado.");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Só é possível emprestar exemplar com situação disponível.");
            contador = 0;
            return;
        }
        dispose();
    }

    private void tfTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTituloKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            if (!tfTitulo.getText().isEmpty()) {
                this.pesquisa();
                DefineDadosEAjustesNajTable();
            } else {
                listaDeObra.clear();
                tbAtualizarObra.setModel(new ExemplarEmprestimoTableModel(listaDeObra));
            }
        }
    }//GEN-LAST:event_tfTituloKeyReleased

    private void cbOpcaoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOpcaoPesquisaItemStateChanged
        tfTitulo.requestFocus();
        if (cbOpcaoPesquisa.getSelectedIndex() == 2 || cbOpcaoPesquisa.getSelectedIndex() == 3) {
            tfTitulo.setDocument(new SomenteNumero());
        } else {
            tfTitulo.setDocument(new DefaultStyledDocument());
        }
    }//GEN-LAST:event_cbOpcaoPesquisaItemStateChanged

    private boolean pesquisa() {
        try {
            if (tfTitulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite sua pesquisa.");
                return false;
            }
            switch (cbOpcaoPesquisa.getSelectedIndex()) {
                case 0:
                    listaDeObra = dao.consulta(tfTitulo.getText());
                    return verifica(listaDeObra);

                case 1:
                    listaDeObra = dao.consultaAutor(tfTitulo.getText());
                    return verifica(listaDeObra);

                case 2:
                    listaDeObra = dao.consultaIsbn(tfTitulo.getText());
                    return verifica(listaDeObra);

                case 3:
                    try {
                        listaDeObra = dao.consultaPorCodigo(Integer.parseInt(tfTitulo.getText()));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Favor digite somente números.");
                        return false;
                    }
                    return verifica(listaDeObra);

                case 4:
                    listaDeObra = dao.consultaAssunto(tfTitulo.getText());
                    return verifica(listaDeObra);

            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    private boolean verifica(List<ExemplarEmprestimo> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "A busca não encontrou nenhum resultado.");
            return false;
        }
        return true;
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
            java.util.logging.Logger.getLogger(DialogSelecionarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogSelecionarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogSelecionarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogSelecionarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogSelecionarObra dialog = new DialogSelecionarObra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbOpcaoPesquisa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAtualizarObra;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}
