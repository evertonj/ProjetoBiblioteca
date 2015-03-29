/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controller.OperadorController;
import entity.Operador;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class FrmRealizarLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmRealizarLogin
     */
    public FrmRealizarLogin() {
        initComponents();
//        DBConnection.createTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        tpsSenha = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Senha:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lages - Cópia1.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));

        tfLogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfLoginKeyReleased(evt);
            }
        });

        tpsSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tpsSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tpsSenhaKeyReleased(evt);
            }
        });

        btLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1402424302_clean_2.png"))); // NOI18N
        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        btLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btLoginKeyReleased(evt);
            }
        });

        btFechar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1404967476_Exit.png"))); // NOI18N
        btFechar.setText("Fechar");
        btFechar.setToolTipText("");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        btFechar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btFecharKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tpsSenha)
                            .addComponent(tfLogin)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btFechar, btLogin});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tpsSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btFechar, btLogin});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        if(login()) {
            JOptionPane.showMessageDialog(null, "Nome e/ou senha incorretos!");
            tfLogin.requestFocus();
        }
    }//GEN-LAST:event_btLoginActionPerformed
    private boolean login() throws HeadlessException {
        String usuario = tfLogin.getText();
        String senha = String.copyValueOf(tpsSenha.getPassword());
        String senhaCrip = FrmCadastroOperador.ComputeHash(senha);

        Operador operador = new OperadorController().searchOperadorAuthentication(usuario, senhaCrip);

        if (operador != null) {
            FrmTelaPrincipal telaPrincipal = new FrmTelaPrincipal();
            telaPrincipal.setVisible(true);
            dispose();
            return false;
        }
        return true;
    }

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btFecharActionPerformed
    int contador = 1;
    private void tpsSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpsSenhaKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (login()) {
                contador++;
                if (contador == 2) {
                    JOptionPane.showMessageDialog(null, "Nome e/ou senha incorretos!");
                    contador = 0;
                } else {
                    contador = 1;
                }
            }
        }
    }//GEN-LAST:event_tpsSenhaKeyReleased

    private void tfLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLoginKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (login()) {
                contador++;
                if (contador == 2) {
                    JOptionPane.showMessageDialog(null, "Nome e/ou senha incorretos!");
                    contador = 0;
                } else {
                    contador = 1;
                }
            }
        }
    }//GEN-LAST:event_tfLoginKeyReleased

    private void btLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btLoginKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (login()) {
                contador++;
                if (contador == 2) {
                    JOptionPane.showMessageDialog(null, "Nome e/ou senha incorretos!");
                    contador = 0;
                } else {
                    contador = 1;
                }
            }
        }
    }//GEN-LAST:event_btLoginKeyReleased

    private void btFecharKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btFecharKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            System.exit(0);
        }
    }//GEN-LAST:event_btFecharKeyReleased

    private Dimension redimensionarTela() {
        return (new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        FrmRealizarLogin login = new FrmRealizarLogin();
        login.setLocationRelativeTo(null);
        login.dispose();
        login.setUndecorated(true);
        login.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tpsSenha;
    // End of variables declaration//GEN-END:variables
}
