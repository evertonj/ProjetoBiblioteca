/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import org.joda.time.Instant;

/**
 *
 * @author Everton
 */
public class Emprestimo {
    
    List<Integer> _obra_id; 
    int usuario_id;
    Instant data_emprestimo;
    Instant data_devolucao;
    int diasParaDevolucao;

    public int getDiasParaDevolucao() {
        return diasParaDevolucao;
    }

    public void setDiasParaDevolucao(int diasParaDevolucao) {
        this.diasParaDevolucao = diasParaDevolucao;
    }

    public List<Integer> getObra_id() {
        return _obra_id;
    }

    public void setObra_id(List<Integer> _obra_id) {
        this._obra_id = _obra_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Instant getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Instant data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Instant getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Instant data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

}
