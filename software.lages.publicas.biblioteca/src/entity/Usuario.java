/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Usuario{

    private int id;
    private String nome;
    private String serie;
    private List<String> listEmail;
    private List<String> listTelefone;

    public Usuario() {
    }

    public Usuario(String nome, String serie, List<String> listEmail, List<String> listTelefone) {
        this.nome = nome;
        this.serie = serie;
        this.listEmail = listEmail;
        this.listTelefone = listTelefone;
    }

    public Usuario(int id, String nome, String serie, List<String> listEmail, List<String> listTelefone) {
        this.id = id;
        this.nome = nome;
        this.serie = serie;
        this.listEmail = listEmail;
        this.listTelefone = listTelefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public List<String> getListEmail() {
        return listEmail;
    }

    public void setListEmail(List<String> listEmail) {
        this.listEmail = listEmail;
    }

    public List<String> getListTelefone() {
        return listTelefone;
    }

    public void setListTelefone(List<String> listTelefone) {
        this.listTelefone = listTelefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    } 
}
