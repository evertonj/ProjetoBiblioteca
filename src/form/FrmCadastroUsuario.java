/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;


import controller.UsuarioController;
import entity.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alex
 */
public class FrmCadastroUsuario extends javax.swing.JDialog {

    /**
     * Creates new form FrmCadastroUsuario
     */
    public FrmCadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        onCancelar();
    }
    List<Usuario> usuarioList;
    int idUsuario;
    private DefaultListModel defaultListaEmail = new DefaultListModel();
    private DefaultListModel defaultListaTelefone = new DefaultListModel();
    private ImageIcon icon;
    private String endImage;
    private ImageIcon fotoEspecie;
    byte[] foto;
      List<String> emails = new ArrayList<>();
        List<String> telefones = new ArrayList<>();

    private void onCancelar() {
        tfNome.setText(null);
        tfTelefone.setText(null);
        tfEmail.setText(null);
        tfTelefone.setText(null);
    }

    private void enableFields(boolean b) {
        tfNome.setEnabled(b);
        tfTelefone.setEnabled(b);
        tfEmail.setEnabled(b);
        tfTelefone.setEnabled(b);
    }
    
    public byte[] getBytes(File file) {
        int len = (int) file.length();
        byte[] sendBuf = new byte[len];
        FileInputStream inFile = null;
        try {
            inFile = new FileInputStream(file);
            inFile.read(sendBuf, 0, len);

        } catch (FileNotFoundException fnfex) {

        } catch (IOException ioex) {

        }
        return sendBuf;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTelefone = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        panelFoto = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        btEscolherFoto = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listEmail = new javax.swing.JList();
        btAddEmail = new javax.swing.JButton();
        btRemoveEmail = new javax.swing.JButton();
        btAddTelefone = new javax.swing.JButton();
        btRemoverTelefone = new javax.swing.JButton();
        tfTelefone = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfSerie = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));

        btSalvar.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/insert.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(95, 30));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setPreferredSize(new java.awt.Dimension(95, 30));
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Telefone:");

        listTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        listTelefone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(listTelefone);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Foto:");

        panelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFotoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbFoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        btEscolherFoto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btEscolherFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/newPicture.png"))); // NOI18N
        btEscolherFoto.setText("Escolher");
        btEscolherFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEscolherFotoActionPerformed(evt);
            }
        });

        tfNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        listEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Emails", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        listEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(listEmail);

        btAddEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btAddEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1404973899_email_add.png"))); // NOI18N
        btAddEmail.setText("Adicionar Email");
        btAddEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddEmailActionPerformed(evt);
            }
        });

        btRemoveEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btRemoveEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1404973906_email_deny.png"))); // NOI18N
        btRemoveEmail.setText("Remover Email");
        btRemoveEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveEmailActionPerformed(evt);
            }
        });

        btAddTelefone.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btAddTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1404973979_Dial.png"))); // NOI18N
        btAddTelefone.setText("Adicionar Telefone");
        btAddTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddTelefoneActionPerformed(evt);
            }
        });

        btRemoverTelefone.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btRemoverTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1404973983_Hungup.png"))); // NOI18N
        btRemoverTelefone.setText("Remover Telefone");
        btRemoverTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverTelefoneActionPerformed(evt);
            }
        });

        tfTelefone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        tfEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("E-mail:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Série:");

        tfSerie.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNome)
                            .addComponent(tfEmail)
                            .addComponent(tfSerie)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                            .addComponent(tfTelefone)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAddEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btRemoveEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAddTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(btRemoverTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEscolherFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(tfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(129, 129, 129)
                                    .addComponent(btAddEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(btRemoveEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btAddTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btRemoverTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btEscolherFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAddEmail, btRemoveEmail});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        int result;
      
    
        Usuario usuario = new Usuario(idUsuario, tfNome.getText(), tfSerie.getText(), emails, telefones, foto);
        if (idUsuario == 0) {
            result = new UsuarioController().addUsuario(usuario);
        } else {
            usuario.setId(idUsuario);
            result = new UsuarioController().alterarUsuario(usuario);
            idUsuario = 0;
        }
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Usuario inserido com Sucesso!");
            onCancelar();
            enableFields(false);
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        onCancelar();
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btAddEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddEmailActionPerformed
        defaultListaEmail.addElement(this.tfEmail.getText());
        emails.add(tfEmail.getText());
        this.listEmail.setModel(defaultListaEmail);
        this.tfEmail.setText(null);
    }//GEN-LAST:event_btAddEmailActionPerformed

    private void btRemoveEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveEmailActionPerformed
        if (listEmail.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum email foi selecianado para ser removido"
                    + "\n" + "Por favor Selecione um email!", "Alerta", JOptionPane.ERROR_MESSAGE);
        } else {
            String email = listEmail.getSelectedValue().toString();
            emails.remove(email);
            defaultListaEmail.removeElement(email);
        }
    }//GEN-LAST:event_btRemoveEmailActionPerformed

    private void btAddTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddTelefoneActionPerformed
        defaultListaTelefone.addElement(this.tfTelefone.getText());
        telefones.add(tfTelefone.getText());
        this.listTelefone.setModel(defaultListaTelefone);
        this.tfTelefone.setText(null);
    }//GEN-LAST:event_btAddTelefoneActionPerformed

    private void btRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverTelefoneActionPerformed
        if (listTelefone.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum telefone foi selecionado para ser removido!"
                    + "\n" + "Por favor Selecione um telefone na lista!", "Alerta", JOptionPane.ERROR_MESSAGE);
        } else {
            Object telefone = listTelefone.getSelectedValue();
            telefones.remove(telefone);
            defaultListaTelefone.removeElement(telefone);
        }
    }//GEN-LAST:event_btRemoverTelefoneActionPerformed

    private void btEscolherFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEscolherFotoActionPerformed
         try {
            JFileChooser fc = new JFileChooser("C:\\Users\\Alex\\Desktop");
            fc.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos de Imagem", "jpg", "png", "gif", "icon", "bmp", "tif"));
            fc.setAcceptAllFileFilterUsed(false);
            fc.showDialog(this, "Adicionar");
            foto = getBytes(fc.getSelectedFile());
            icon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
            lbFoto.setIcon(redimensionaImageIcon(icon));
        } catch (NullPointerException n) {
            return;
        }
    }//GEN-LAST:event_btEscolherFotoActionPerformed

    private ImageIcon redimensionaImageIcon(ImageIcon icon) {
        int height = icon.getIconHeight();
        int width = icon.getIconWidth();
        double alturaFinal = 120.0;
        double larguraFinal = 130.0;
        if (height > width) {
            if (height > alturaFinal) {
                double altura = alturaFinal / height;
                larguraFinal = width * altura;
            } else {
                double altura = height / alturaFinal;
                larguraFinal = width * altura;
            }
        } else {
            if (height > 130) {
                double largura = larguraFinal / width;
                alturaFinal = height * largura;
            } else {
                double largura = width / larguraFinal;
                alturaFinal = height * largura;
            }
        }
        icon.setImage(icon.getImage().getScaledInstance((int) larguraFinal, (int) alturaFinal, 100));
        return icon;
    }
    /**
     * @param args the command line arg uments
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
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCadastroUsuario dialog = new FrmCadastroUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAddEmail;
    private javax.swing.JButton btAddTelefone;
    private javax.swing.JButton btEscolherFoto;
    private javax.swing.JButton btRemoveEmail;
    private javax.swing.JButton btRemoverTelefone;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JList listEmail;
    private javax.swing.JList listTelefone;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSerie;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
