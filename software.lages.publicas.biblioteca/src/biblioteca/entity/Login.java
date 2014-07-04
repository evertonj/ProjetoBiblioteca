/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.entity;

import CadastroDeEditora.entity.exceptions.NameException;

/**
 *
 * @author Bya
 */
public class Login {

    private long id;
    private String nome;
    private String senha;

    public Login(long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Login(String nome, String senha) throws NameException {
        this.nome = nome;
        this.senha = senha;
        validarLogin();
    }
  
    private void validarLogin() throws NameException{
        if (this.nome.isEmpty()){
            throw new NameException("O Campo nome é obrigatório ser prenchido!");
        }   
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
