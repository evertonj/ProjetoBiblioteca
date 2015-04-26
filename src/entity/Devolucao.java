/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Everton
 */
public class Devolucao {
    
    private int exemplar_id;
    private int usuario_id;
    private LocalDateTime data_devolucao;
    private int operador_id;
    
    public Devolucao(int exemplar_id, int usuario_id, LocalDateTime data_devolucao, int operador_id) {
        this.exemplar_id = exemplar_id;
        this.usuario_id = usuario_id;
        this.data_devolucao = data_devolucao;
        this.operador_id = operador_id;
    }

    public Devolucao() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.exemplar_id;
        hash = 59 * hash + this.usuario_id;
        hash = 59 * hash + Objects.hashCode(this.data_devolucao);
        hash = 59 * hash + this.operador_id;
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
        final Devolucao other = (Devolucao) obj;
        if (this.exemplar_id != other.exemplar_id) {
            return false;
        }
        if (this.usuario_id != other.usuario_id) {
            return false;
        }
        if (!Objects.equals(this.data_devolucao, other.data_devolucao)) {
            return false;
        }
        if (this.operador_id != other.operador_id) {
            return false;
        }
        return true;
    }

    
    /**
     * @return the exemplar_id
     */
    public int getExemplar_id() {
        return exemplar_id;
    }

    /**
     * @param exemplar_id the exemplar_id to set
     */
    public void setExemplar_id(int exemplar_id) {
        this.exemplar_id = exemplar_id;
    }

    /**
     * @return the usuario_id
     */
    public int getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * @return the data_devolucao
     */
    public LocalDateTime getData_devolucao() {
        return data_devolucao;
    }

    /**
     * @param data_devolucao the data_devolucao to set
     */
    public void setData_devolucao(LocalDateTime data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    /**
     * @return the operador_id
     */
    public int getOperador_id() {
        return operador_id;
    }

    /**
     * @param operador_id the operador_id to set
     */
    public void setOperador_id(int operador_id) {
        this.operador_id = operador_id;
    }
}
