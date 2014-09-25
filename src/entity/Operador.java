/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exception.NameException;
import entity.exception.PasswordException;



/**
 *
 * @author Bya
 */
public class Operador {

    private long id;
    private String nome;
    private String senha;

    public Operador() {
    }

    public Operador(long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Operador(String nome, String senha) throws NameException, PasswordException {
        this.nome = nome;
        this.senha = senha;
        validarLogin();
    }

    private void validarLogin() throws NameException, PasswordException {
        if (this.nome.isEmpty()) {
            throw new NameException("O Campo nome é obrigatório ser prenchido!");
        }
        if (this.senha.isEmpty()) {
            throw new PasswordException("O Campo senha é obrigatório ser prenchido!");
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Operador other = (Operador) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
