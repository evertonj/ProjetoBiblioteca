/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.UsuarioDAO;
import entity.ExemplarEmprestimo;
import entity.Usuario;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import table.UsuarioTableModel;

/**
 *
 * @author Alex
 */
public class DialogAdicionarUsuario extends javax.swing.JDialog {

    /**
     * Creates new form FrmCadastroUsuario
     */
    public DialogAdicionarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tfBusca.requestFocus();
    }
    private Usuario usuario;
    List<Usuario> listaUsuario = new ArrayList<>();

    private void refreshTable(List<Usuario> listaUsuario) {

        if (listaUsuario != null) {
            tbAluno.setModel(new UsuarioTableModel(listaUsuario));
            tbAluno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private Usuario getUsuarioDaTabela() {
        int indice = tbAluno.getSelectedRow();
        if (indice != -1) {
            Usuario usuario = listaUsuario.get(indice);
            return usuario;
        }
        return null;
    }
    private ImageIcon icon;
    byte[] foto;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        tfBusca = new javax.swing.JTextField();
        cbPesquisa = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAluno = new javax.swing.JTable();
        btSelecionar = new javax.swing.JButton();
        btAtualizar2 = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Usuários");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));

        tfBusca.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tfBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscaKeyReleased(evt);
            }
        });

        cbPesquisa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aluno", "Série" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBusca)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAluno);

        btSelecionar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btSelecionar.setForeground(new java.awt.Color(0, 102, 204));
        btSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/selecionarUsuario48x48.png"))); // NOI18N
        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        btAtualizar2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btAtualizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btAtualizar2.setText("Voltar");
        btAtualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAtualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAtualizar2, btSelecionar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSelecionar)
                    .addComponent(btAtualizar2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAtualizar2, btSelecionar});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        this.usuario = getUsuarioDaTabela();
        if (this.usuario == null) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário.");
            return;
        } else {
            DialogEmprestimo.setUsuario(this.usuario);
        }
        dispose();
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void tfBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaKeyReleased
        if (tfBusca.getText().isEmpty()) {
            listaUsuario.clear();
            refreshTable(listaUsuario);
        } else {
            if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
                buscarDadosParaTabela();
            }
        }
    }//GEN-LAST:event_tfBuscaKeyReleased

    private void buscarDadosParaTabela() {
        if (tfBusca.getText().isEmpty()) {
            listaUsuario.clear();
        } else {
            switch (cbPesquisa.getSelectedIndex()) {
                case 0:
                    listaUsuario = new UsuarioDAO().buscaPorNome(tfBusca.getText());
                    verifica(listaUsuario);
                    break;
                case 1:
                    listaUsuario = new UsuarioDAO().buscaPorSerie(tfBusca.getText());
                    verifica(listaUsuario);
                    break;

            }
        }
    }

    private void verifica(List<Usuario> lista) {
        if (lista.isEmpty()) {
            int confirme;
            confirme = JOptionPane.showConfirmDialog(this, "A busca não encontrou aluno com nome iniciado em: ("+tfBusca.getText()+").\nDeseja adicionar um novo usuário ?.", "Novo Usuário", JOptionPane.YES_NO_OPTION);
            if(confirme == 0) {
                new FrmCadastroUsuario(new javax.swing.JFrame(), true).setVisible(true);
            }
        }
        this.refreshTable(listaUsuario);
    }


    private void btAtualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizar2ActionPerformed
        dispose();
    }//GEN-LAST:event_btAtualizar2ActionPerformed

    private void tbAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAlunoMouseClicked
        if (evt.getClickCount() == 2) {
            this.usuario = getUsuarioDaTabela();
            if (this.usuario == null) {
                JOptionPane.showMessageDialog(this, "Selecione um usuário.");
                return;
            } else {
                DialogEmprestimo.setUsuario(this.usuario);
            }
            dispose();
        }
    }//GEN-LAST:event_tbAlunoMouseClicked

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
            java.util.logging.Logger.getLogger(DialogAdicionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAdicionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAdicionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAdicionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAdicionarUsuario dialog = new DialogAdicionarUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAtualizar2;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JComboBox cbPesquisa;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tbAluno;
    private javax.swing.JTextField tfBusca;
    // End of variables declaration//GEN-END:variables
}
