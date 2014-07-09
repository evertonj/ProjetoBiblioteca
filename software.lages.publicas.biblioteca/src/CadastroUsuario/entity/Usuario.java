/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CadastroUsuario.entity;

/**
 *
 * @author Alex
 */
public class Usuario implements Comparable<Usuario>{
    private Long id;
    private String nome;
    private String serie;
    private String email;
    private String telefone;

    public Usuario() {
    }
    
    

    public Usuario(String nome, String serie, String email, String telefone) {
        this.nome = nome;
        this.serie = serie;
        this.email = email;
        this.telefone = telefone;
    }
    
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Usuario t) {
        return Long.valueOf(id).compareTo(Long.valueOf(t.id));
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
