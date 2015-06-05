/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controller.UsuarioController;
import dao.UsuarioDAO;
import entity.Email;
import entity.EnumSituacaoUsuario;
import entity.Telefone;
import entity.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import table.EmailTableModel;
import table.TelefoneTableModel;
import table.UsuarioCellRenderer;

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
    
    UsuarioDAO dao = new UsuarioDAO();

    private void refreshTableEmail() {

        if (emails != null) {
            tbEmail.setModel(new EmailTableModel(emails));
            tbEmail.setDefaultRenderer(Object.class, new UsuarioCellRenderer());
        }
    }

    private void refreshTableTelefone() {

        if (telefones != null) {
            tbTelefone.setModel(new TelefoneTableModel(telefones));
            tbTelefone.setDefaultRenderer(Object.class, new UsuarioCellRenderer());
        }
    }
    Usuario usuario;
    List<Usuario> usuarioList;
    int idUsuario = 0;
    private DefaultListModel defaultListaEmail = new DefaultListModel();
    private DefaultListModel defaultListaTelefone = new DefaultListModel();
    private ImageIcon icon;
    private String endImage;
    private ImageIcon fotoEspecie;
    byte[] foto;
    List<Email> emails = new ArrayList<>();
    List<Telefone> telefones = new ArrayList<>();

    private void onCancelar() {
        tfNome.setText(null);
        tfTelefone.setText(null);
        tfSerie.setText(null);
        tfEmail.setText(null);
        lbFoto.setIcon(null);
        tbEmail.setModel(new DefaultTableModel());
        tbTelefone.setModel(new DefaultTableModel());
    }

    private boolean verificaEmail(String nome) {
        String aux;
        if (!emails.isEmpty()) {
            for (int i = 0; i < emails.size(); i++) {
                aux = emails.get(i).getEmail();
                if (nome.equals(aux)) {
                    return false;
                }

            }
            return true;

        }
        return true;
    }

    private boolean validaEmail(String email) {

        int atpos = email.indexOf("@");
        int dotpos = email.lastIndexOf(".");
        if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length()) {
            return false;
        }
        return true;
    }

    private boolean verificaTelefone(String nome) {
        String aux;
        if (!telefones.isEmpty()) {
            for (int i = 0; i < telefones.size(); i++) {
                aux = telefones.get(i).getTelefone();
                if (nome.equals(aux)) {
                    return false;
                } else {
                    return true;
                }

            }

        }
        return true;
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
        jLabel2 = new javax.swing.JLabel();
        panelFoto = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        btEscolherFoto = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTelefone = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbEmail = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));

        btSalvar.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/insert.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomeKeyTyped(evt);
            }
        });

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
        tfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefoneKeyTyped(evt);
            }
        });

        tfEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEmailKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("E-mail:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Série:");

        tfSerie.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSerieKeyTyped(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tbTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbTelefone);

        tbEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbEmail);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("(Apenas numeros)");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("(Apenas numeros)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTelefone))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfSerie)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNome)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAddTelefone)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btRemoveEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAddEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                            .addComponent(btRemoverTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEscolherFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(btEscolherFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btAddEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btRemoveEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btAddTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btRemoverTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(24, 24, 24)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAddEmail, btRemoveEmail});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
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
        int result, atualizar = 0;
        if(tfNome.getText().isEmpty() || tfSerie.getText().isEmpty() || emails.isEmpty() || telefones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios, exceto a foto");
            return;
        }
        usuario = new Usuario(idUsuario, tfNome.getText(), tfSerie.getText(), emails, telefones, foto, EnumSituacaoUsuario.ATIVO, new Date());
        if (idUsuario == 0) {
            result = new UsuarioController().addUsuario(usuario);
        } else {
            usuario.setId(idUsuario);
            result = new UsuarioController().alterarUsuario(usuario);
            atualizar = 1;
            idUsuario = 0;
        }
        if (result == 1) {
            if (atualizar == 1) {
                JOptionPane.showMessageDialog(this, "Usuario Atualizado com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario inserido com Sucesso!");
            }
            onCancelar();
            emails.clear();
            telefones.clear();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        onCancelar();
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btAddEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddEmailActionPerformed
        if (validaEmail(tfEmail.getText())) {
            if (this.verificaEmail(tfEmail.getText())) {
                Email email = new Email();
                email.setEmail(tfEmail.getText());
                emails.add(email);
                this.refreshTableEmail();
                tfEmail.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Email já cadastrado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email inválido");
        }

    }//GEN-LAST:event_btAddEmailActionPerformed

    private void btRemoveEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveEmailActionPerformed
        int rowIndex = tbEmail.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o Email a ser Removido!!!");
            return;
        }
        Email email = new EmailTableModel(emails).get(rowIndex);
        int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusão ?", "Excluir Email", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }
        
        if (emails.remove(email)) {
            dao.removerEmail(email);
            JOptionPane.showMessageDialog(this, "Email removido com Sucesso!");
            this.refreshTableEmail();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
        }
    }//GEN-LAST:event_btRemoveEmailActionPerformed

    private void btAddTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddTelefoneActionPerformed
        if (this.verificaTelefone(tfTelefone.getText())) {
            Telefone tel = new Telefone();
            tel.setTelefone(tfTelefone.getText());
            telefones.add(tel);
            this.refreshTableTelefone();
            tfTelefone.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Telefone já cadastrado");
        }

    }//GEN-LAST:event_btAddTelefoneActionPerformed

    private void btRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverTelefoneActionPerformed
        int rowIndex = tbTelefone.getSelectedRow();
        if (rowIndex == -1) { 
            JOptionPane.showMessageDialog(this, "Selecione o Telefone a ser Removido!!!");
            return;
        }
        Telefone telefone = new TelefoneTableModel(telefones).get(rowIndex);
        int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusão ?", "Excluir Telefone", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }

        if (telefones.remove(telefone)) {
            dao.removerTelefone(telefone);
            JOptionPane.showMessageDialog(this, "telefone removido com Sucesso!");
            this.refreshTableEmail();
        } else {
            JOptionPane.showMessageDialog(this, "Tente novamente!");
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

    private void tfEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEmailKeyTyped
      
verificaCampos();
         
    }//GEN-LAST:event_tfEmailKeyTyped

    private void tfSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSerieKeyTyped
        String caracteres="0987654321-";
       if(caracteres.contains(evt.getKeyChar()+"")){
           
       }else{
           evt.consume();
       }
    }//GEN-LAST:event_tfSerieKeyTyped

    private void tfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefoneKeyTyped
      String caracteres="0987654321-";
       if(caracteres.contains(evt.getKeyChar()+"")){
           
       }else{
           evt.consume();
       }
       verificaCampos();
    }//GEN-LAST:event_tfTelefoneKeyTyped

    private void tfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyTyped
        verificaCampos();
    }//GEN-LAST:event_tfNomeKeyTyped

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
 void verificaCampos(){
     if(!tfEmail.getText().equals("")&&!tfNome.getText().equals("")&&!tfSerie.getText().equals("")&&!tfTelefone.getText().equals("")){
         btSalvar.setEnabled(true);
     }else{
         btSalvar.setEnabled(false);
     }
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JTable tbEmail;
    private javax.swing.JTable tbTelefone;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSerie;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables

    public void setDados(Usuario novoUsuario) {
        this.usuario = novoUsuario;
        tfNome.setText(usuario.getNome());
        tfSerie.setText(usuario.getSerie());

        emails = usuario.getListEmail();
        this.refreshTableEmail();
        byte[] imgBytes = usuario.getFoto();
        telefones = usuario.getListTelefone();
        this.refreshTableTelefone();
        foto = usuario.getFoto();
        try {/*
             Gravar A Imagem no disco.
             FileOutputStream fos = new FileOutputStream("Foto " + tfTitulo.getText() + ".jpg");
             fos.write(imgBytes);
             FileDescriptor fd = fos.getFD();
             fos.flush();
             fd.sync();
             fos.close();*/

            icon = new ImageIcon(imgBytes);
            lbFoto.setIcon(redimensionaImageIcon(icon));
        } catch (Exception e) {
            String erro = e.toString();
        }
        idUsuario = usuario.getId();

    }
}
