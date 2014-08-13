/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Cadastro de Autor
package entity;

import entity.exceptions.NameException;
import java.sql.Date;

/**
 *
 * @author Alex
 */
public class Autor  {
    private int id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;

    public Autor(String nome, String sobrenome, Date dataNascimento) throws NameException{
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }

    public Autor(int id, String nome, String sobrenome, Date dataNascimento) throws NameException{
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return sobrenome + ", " + nome;
    }

   

    
   

    
    public final void verificarDados() throws NameException {
        if (this.getNome().isEmpty()) {
            throw new NameException("É obrigado ter o nome da autor...");
        }
       
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
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
