/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Alex
 */
public class Obra {

    private int id;
    private String titulo;
    private List<Autor> autores;
    private String Edicao;
    private short Ano;
    private Editora editora;
    private String isbn;
    private Assunto assunto;
    private ImageIcon fotoIcon;
    private byte[] foto; 
    private List<Exemplar> exemplar;
    
    
      public ImageIcon getFotoAsImageIcon() {

        this.fotoIcon = new ImageIcon();

        if (this.getFoto() != null) {
            this.fotoIcon = new ImageIcon(this.getFoto());
        }

        return this.fotoIcon;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

   

    /**
     * @return the Edicao
     */
    public String getEdicao() {
        return Edicao;
    }

    /**
     * @param Edicao the Edicao to set
     */
    public void setEdicao(String Edicao) {
        this.Edicao = Edicao;
    }

    public short getAno() {
        return Ano;
    }

    public void setAno(short Ano) {
        this.Ano = Ano;
    }

    /**
     * @return the editora
     */
    public Editora getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the exemplar
     */
    public List<Exemplar> getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar the exemplar to set
     */
    public void setExemplar(List<Exemplar> exemplar) {
        this.exemplar = exemplar;
    }

   
    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

   
    /**
     * @return the fotoIcon
     */
    public ImageIcon getFotoIcon() {
        return fotoIcon;
    }

    /**
     * @param fotoIcon the fotoIcon to set
     */
    public void setFotoIcon(ImageIcon fotoIcon) {
        this.fotoIcon = fotoIcon;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getFoto() {
        return foto;
    }

    /**
     * @return the assunto
     */
    public Assunto getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

   
}
