/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;



/**
 *
 * @author Everton
 */
public class Emprestimo {


    
    int exemplar_id; 
    int usuario_id;
    LocalDate data_emprestimo;
    LocalDate data_devolucao;
    int diasParaDevolucao;
    int editora_id;
    int obra_id;
    int autor_id;
    private Long operador_id;

    public int getExemplar_id() {
        return exemplar_id;
    }

    public void setExemplar_id(int exemplar_id) {
        this.exemplar_id = exemplar_id;
    }
    
    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }
    
    public int getEditora_id() {
        return editora_id;
    }

    public void setEditora_id(int editora_id) {
        this.editora_id = editora_id;
    }

    public int getObra_id() {
        return obra_id;
    }

    public void setObra_id(int obra_id) {
        this.obra_id = obra_id;
    }
    
    public int getDiasParaDevolucao() {
        return diasParaDevolucao;
    }

    public void setDiasParaDevolucao(int diasParaDevolucao) {
        this.diasParaDevolucao = diasParaDevolucao;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    /**
     * @return the operador_id
     */
    public Long getOperador_id() {
        return operador_id;
    }

    /**
     * @param operador_id the operador_id to set
     */
    public void setOperador_id(Long operador_id) {
        this.operador_id = operador_id;
    }

}
