/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Everton
 */
public class InfoDevolucao {
    private String nomeUsuario;
    private String serieUsuario;
    private int numeroSequencial;
    private String tituloObra;
    private LocalDate dataDevolucao;
    private String nomeOperador;

    public InfoDevolucao(String nomeUsuario, String serieUsuario, int numeroSequencial, String tituloObra, LocalDate dataDevolucao, String nomeOperador) {
        this.nomeUsuario = nomeUsuario;
        this.serieUsuario = serieUsuario;
        this.numeroSequencial = numeroSequencial;
        this.tituloObra = tituloObra;
        this.dataDevolucao = dataDevolucao;
        this.nomeOperador = nomeOperador;
    }

    public InfoDevolucao() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nomeUsuario);
        hash = 71 * hash + Objects.hashCode(this.serieUsuario);
        hash = 71 * hash + this.numeroSequencial;
        hash = 71 * hash + Objects.hashCode(this.tituloObra);
        hash = 71 * hash + Objects.hashCode(this.dataDevolucao);
        hash = 71 * hash + Objects.hashCode(this.nomeOperador);
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
        final InfoDevolucao other = (InfoDevolucao) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        if (!Objects.equals(this.serieUsuario, other.serieUsuario)) {
            return false;
        }
        if (this.numeroSequencial != other.numeroSequencial) {
            return false;
        }
        if (!Objects.equals(this.tituloObra, other.tituloObra)) {
            return false;
        }
        if (!Objects.equals(this.dataDevolucao, other.dataDevolucao)) {
            return false;
        }
        if (!Objects.equals(this.nomeOperador, other.nomeOperador)) {
            return false;
        }
        return true;
    }

    
    
    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the serieUsuario
     */
    public String getSerieUsuario() {
        return serieUsuario;
    }

    /**
     * @param serieUsuario the serieUsuario to set
     */
    public void setSerieUsuario(String serieUsuario) {
        this.serieUsuario = serieUsuario;
    }

    /**
     * @return the numeroSequencial
     */
    public int getNumeroSequencial() {
        return numeroSequencial;
    }

    /**
     * @param numeroSequencial the numeroSequencial to set
     */
    public void setNumeroSequencial(int numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    /**
     * @return the tituloObra
     */
    public String getTituloObra() {
        return tituloObra;
    }

    /**
     * @param tituloObra the tituloObra to set
     */
    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    /**
     * @return the dataDevolucao
     */
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the nomeOperador
     */
    public String getNomeOperador() {
        return nomeOperador;
    }

    /**
     * @param nomeOperador the nomeOperador to set
     */
    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }
}
