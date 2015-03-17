/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import entity.exceptions.NameException;



/**
 *
 * @author Alex
 */
public class Editora  {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String cidade;
  
    private String rua;
    private String bairro;
    private String numero;
    
    public Editora(Editora editora) throws NameException {
        this.id = editora.getId();
        this.nome = editora.getNome();
        this.telefone = editora.getTelefone();
        this.email = editora.getEmail();
        this.cidade = editora.getCidade();
        this.rua = editora.getRua();
        this.bairro = editora.getBairro();
        this.numero = editora.getNumero();
        verificarDados();
    }

    public Editora(String nome, String telefone, String email, String cidade, String rua, String bairro, String numero)throws NameException {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        verificarDados();
    }

    public Editora(int id, String nome, String telefone, String email, String cidade, String rua, String bairro, String numero) throws NameException{
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        verificarDados();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Editora other = (Editora) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return nome;
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
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the endereco
     */
   

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
    public final void verificarDados() throws NameException {
        if (this.nome.isEmpty()) {
            throw new NameException("É obrigado ter o nome da editora...");
        }
       
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
}

   
