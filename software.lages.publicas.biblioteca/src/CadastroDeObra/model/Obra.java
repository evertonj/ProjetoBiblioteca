/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadastroDeObra.model;

import CadastroDeEditora.entity.Editora;
import java.io.File;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Obra {

    private int id;
    private String titulo;
    private List<String> autores;
    private String Edicao;
    private short Ano;
    private Editora editora;
    private String isbn;
    private String assunto;
    private File foto;

    private List<Exemplar> exemplar;

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
     * @return the autores
     */
    public List<String> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<String> autores) {
        this.autores = autores;
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
     * @return the assunto
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
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

    /**
     * @return the foto
     */
    public File getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(File foto) {
        this.foto = foto;
    }

   
}
