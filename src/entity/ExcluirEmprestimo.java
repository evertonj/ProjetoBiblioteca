/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Everton
 */
public class ExcluirEmprestimo {
    private int idUsuario;
    private int idExemplar;
    private String usuario;
    private String titulo;
    private String autor;
    private String edicao;
    private String ano;
    private String editora;
    private Emprestimo emprestimo;

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nome
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the nome to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the edicao
     */
    public String getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @return the emprestimo
     */
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    /**
     * @param emprestimo the emprestimo to set
     */
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    /**
     * @return the idExemplar
     */
    public int getIdExemplar() {
        return idExemplar;
    }

    /**
     * @param idExemplar the idExemplar to set
     */
    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }
}
