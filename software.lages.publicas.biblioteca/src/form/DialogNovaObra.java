/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controller.AssuntoController;
import controller.EditoraController;
import entity.Editora;
import dao.ObraDAO;
import entity.Assunto;
import entity.Obra;
import table.ObraTableModel;
import entity.Autor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DialogNovaObra extends javax.swing.JDialog {

    public DialogNovaObra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarComboBoxEditora();
        carregarComBoboxAssunto();
    }
    public static List<Autor> listaAutores = new ArrayList();
    DefaultTableModel dtm;
    private ImageIcon icon;
    long i = 0;
    TableColumn tc;
    ObraDAO dao = new ObraDAO();
    public static Obra obra;
    byte[] foto;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btAdicionarComboBox = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAutores = new javax.swing.JTable();
        btNovoAutor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfEdicao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbEditora = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        tfAno = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tfISBN = new javax.swing.JTextField();
        btNovaEditora = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btEscolher = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btInserirExemplar = new javax.swing.JButton();
        cbAssunto = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Nova Obra");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 4));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Titulo:");

        tfTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Autor:");

        btAdicionarComboBox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btAdicionarComboBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/insert 16x16.png"))); // NOI18N
        btAdicionarComboBox.setText("Insere Autor");
        btAdicionarComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarComboBoxActionPerformed(evt);
            }
        });

        btRemover.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete16x16.png"))); // NOI18N
        btRemover.setText("Retira Autor");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        tbAutores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tbAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autores"
            }
        ));
        tbAutores.setRowHeight(25);
        jScrollPane2.setViewportView(tbAutores);

        btNovoAutor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btNovoAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new Author.png"))); // NOI18N
        btNovoAutor.setText("Novo Autor");
        btNovoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoAutorActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Edição:");

        tfEdicao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Editora:");

        cbEditora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Ano:");

        tfAno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("ISBN:");

        tfISBN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btNovaEditora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btNovaEditora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/insert 16x16.png"))); // NOI18N
        btNovaEditora.setText("Nova Editora");
        btNovaEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaEditoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfISBN)
                    .addComponent(cbEditora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tfEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btNovaEditora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfAno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btNovaEditora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(13, 13, 13))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Foto da Capa:");

        btEscolher.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btEscolher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/newPicture.png"))); // NOI18N
        btEscolher.setText("Escolher");
        btEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEscolherActionPerformed(evt);
            }
        });

        lbFoto.setBackground(new java.awt.Color(153, 153, 153));
        lbFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btSalvar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/insert.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
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
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btSalvar, btVoltar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btSalvar, btVoltar});

        btInserirExemplar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btInserirExemplar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/novoexemplar.png"))); // NOI18N
        btInserirExemplar.setText("Novo Exemplar");
        btInserirExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirExemplarActionPerformed(evt);
            }
        });

        cbAssunto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Assunto:");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/insert 16x16.png"))); // NOI18N
        jButton1.setText("Novo Assunto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btEscolher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btInserirExemplar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btEscolher)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btInserirExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Código");

        tfCodigo.setEditable(false);
        tfCodigo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTitulo))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btAdicionarComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btNovoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCodigo))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btNovoAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAdicionarComboBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAdicionarComboBox, btNovoAutor, btRemover});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void carregarComboBoxEditora() {
        List<Editora> listaDeEditora = new EditoraController().finAll();
        for (Editora editora : listaDeEditora) {
            cbEditora.removeItem(editora);
            cbEditora.addItem(editora);
        }
        cbEditora.setSelectedIndex(-1);
    }

    public static void carregarComBoboxAssunto() {
        List<Assunto> listAssunto = new AssuntoController().finAll();
        for (Assunto assunto : listAssunto) {
            cbAssunto.removeItem(assunto);
            cbAssunto.addItem(assunto);
        }
        cbAssunto.setSelectedIndex(-1);
    }

    private void getDados() {
        try {
            obra.setTitulo(tfTitulo.getText());
            obra.setAutores(listaAutores);
            obra.setEdicao(tfEdicao.getText());
            obra.setAno(Short.parseShort(tfAno.getText()));
            obra.setEditora((Editora) cbEditora.getSelectedItem());
            obra.setIsbn(tfISBN.getText());
            obra.setAssunto((Assunto) cbAssunto.getSelectedItem());
            obra.setFoto(foto);
            obra.setExemplar(DialogExemplar.listaDeExemplares);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "O Ano inserido é Invalido!!!");
            tfAno.setText(null);
            tfAno.requestFocus();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Favor preencha todos os campos!!!");
        }
    }

    public void setDados(Obra obraAlteracao) {
        DialogNovaObra.obra = obraAlteracao;
        tfCodigo.setText(String.valueOf(obra.getId()));
        tfTitulo.setText(obra.getTitulo());
        tbAutores.setModel(new ObraTableModel(obra.getAutores()));
        listaAutores = obra.getAutores();
        DialogExemplar.listaDeExemplares = obra.getExemplar();
        tfEdicao.setText(obra.getEdicao());
        tfAno.setText(String.valueOf(obra.getAno()));
        cbEditora.setSelectedItem(obra.getEditora());
        tfISBN.setText(obra.getIsbn());
        cbAssunto.setSelectedItem(obra.getAssunto());
        byte[] imgBytes = obra.getFoto();
        foto = obra.getFoto();
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


    private void btAdicionarComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarComboBoxActionPerformed
        DialogAdicionarAutor adicionarAutor = new DialogAdicionarAutor(new javax.swing.JFrame(), true);
        adicionarAutor.setVisible(true);
    }//GEN-LAST:event_btAdicionarComboBoxActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        int indexRow = tbAutores.getSelectedRow();
        if (indexRow > -1) {
            listaAutores.remove(indexRow);
            tbAutores.setModel(new ObraTableModel(listaAutores));
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (obra == null) {
            obra = new Obra();
            this.getDados();
            int result = dao.save(obra);
            if (result == 1) {
                this.dispose();
                JOptionPane.showMessageDialog(this, "inserido com Sucesso!!!");
            }
        } else {
            this.getDados();
            System.out.println(obra.getAutores().get(0).getId()+ ": " + obra.getAutores().get(0));
            System.out.println(obra.getAutores().get(1).getId()+ ": " +obra.getAutores().get(1));
            int result = dao.update(obra);
            if (result == 1) {
                this.dispose();
                JOptionPane.showMessageDialog(this, "Alterado com Sucesso!!!");
                obra = null;
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        //listaAutores.removeAll(listaAutores);
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btNovoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoAutorActionPerformed
        FrmCadastroDeAutor cadastroDeAutor = new FrmCadastroDeAutor(new javax.swing.JFrame(), true);
        cadastroDeAutor.setVisible(true);
    }//GEN-LAST:event_btNovoAutorActionPerformed

    private void btEscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEscolherActionPerformed
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
    }//GEN-LAST:event_btEscolherActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //listaAutores.removeAll(listaAutores);
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FrmCadastroDeAssunto(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btNovaEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaEditoraActionPerformed
        new FrmCadastroDeEditora(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btNovaEditoraActionPerformed

    private void btInserirExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirExemplarActionPerformed
        new DialogExemplar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btInserirExemplarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogNovaObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogNovaObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogNovaObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogNovaObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogNovaObra dialog = new DialogNovaObra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAdicionarComboBox;
    private javax.swing.JButton btEscolher;
    private javax.swing.JButton btInserirExemplar;
    private javax.swing.JButton btNovaEditora;
    private javax.swing.JButton btNovoAutor;
    private javax.swing.JButton btRemover;
    public static javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private static javax.swing.JComboBox cbAssunto;
    private static javax.swing.JComboBox cbEditora;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbFoto;
    public static javax.swing.JTable tbAutores;
    private javax.swing.JFormattedTextField tfAno;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfEdicao;
    private javax.swing.JTextField tfISBN;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables

    private ImageIcon redimensionaImageIcon(ImageIcon icon) {
        int height = icon.getIconHeight();
        int width = icon.getIconWidth();
        double alturaFinal = 160.0;
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

}
