/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Alex
 */
public class Exemplar {

    public Exemplar(Date dataDeCadastro, String fornecedor, Date dataDeAquisicao, int numeroSequencial,
            EnumSituacaoExemplar situacao, String descricao) {
        this.dataDeCadastro = dataDeCadastro;
        this.fornecedor = fornecedor;
        this.dataDeAquisicao = dataDeAquisicao;
        this.numeroSequencial = numeroSequencial;
        this.situacao = situacao;
        this.descricao = descricao;
    }

    public Exemplar() {
    }
    
    

    private int id;
    private Date dataDeCadastro;
    private String fornecedor;
    private Date dataDeAquisicao;
    private int idObra;
    private int numeroSequencial;
    private EnumSituacaoExemplar situacao;
    private String descricao;

    public Exemplar(int id, Date dataDeCadastro, String fornecedor, Date dataDeAquisicao, int idObra, int numeroSequencial,
            EnumSituacaoExemplar situacao, String descricao) {
        this.id = id;
        this.dataDeCadastro = dataDeCadastro;
        this.fornecedor = fornecedor;
        this.dataDeAquisicao = dataDeAquisicao;
        this.idObra = idObra;
        this.numeroSequencial = numeroSequencial;
        this.situacao = situacao;
        this.descricao = descricao;
    }            

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
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
        final Exemplar other = (Exemplar) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
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
     * @return the dataDeCadastro
     */
    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     * @param dataDeCadastro the dataDeCadastro to set
     */
    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    /**
     * @return the fornecedor
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the dataDeAquisicao
     */
    public Date getDataDeAquisicao() {
        return dataDeAquisicao;
    }

    /**
     * @param dataDeAquisicao the dataDeAquisicao to set
     */
    public void setDataDeAquisicao(Date dataDeAquisicao) {
        this.dataDeAquisicao = dataDeAquisicao;
    }

    /**
     * @return the idObra
     */
    public int getIdObra() {
        return idObra;
    }

    /**
     * @param idObra the idObra to set
     */
    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    /**
     * @return the numeroSequencial
     */
    public int getNumeroSequancial() {
        return numeroSequencial;
    }

    /**
     * @param numeroSequencial the numeroSequencial to set
     */
    public void setNumeroSequancial(int numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    /**
     * @return the situacao
     */
    public EnumSituacaoExemplar getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(EnumSituacaoExemplar situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
