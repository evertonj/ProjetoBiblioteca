/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author Alex
 */
public class Usuario{

    private int id;
    private String nome;
    private String serie;
    private List<Email> listEmail;
    private List<Telefone> listTelefone;
    private ImageIcon fotoIcon;
    private byte[] foto; 

    public Usuario() {
    }

    public Usuario(String nome, String serie, List<Email> listEmail, List<Telefone> listTelefone) {
        this.nome = nome;
        this.serie = serie;
        this.listEmail = listEmail;
        this.listTelefone = listTelefone;
    }

    public Usuario(int id, String nome, String serie, List<Email> listEmail, List<Telefone> listTelefone, byte[]foto) {
        this.id = id;
        this.nome = nome;
        this.serie = serie;
        this.listEmail = listEmail;
        this.listTelefone = listTelefone;
        this.foto = foto;
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

    public List<Email> getListEmail() {
        return listEmail;
    }

    public void setListEmail(List<Email> listEmail) {
        this.listEmail = listEmail;
    }

    public List<Telefone> getListTelefone() {
        return listTelefone;
    }

    public void setListTelefone(List<Telefone> listTelefone) {
        this.listTelefone = listTelefone;
    }
    
    public ImageIcon getFotoIcon() {
        return fotoIcon;
    }

    public void setFotoIcon(ImageIcon fotoIcon) {
        this.fotoIcon = fotoIcon;
    }
    
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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
    
    public ImageIcon getFotoAsImageIcon() {

        this.fotoIcon = new ImageIcon();

        if (this.getFoto() != null) {
            this.fotoIcon = new ImageIcon(this.getFoto());
        }

        return this.fotoIcon;
    }
}
