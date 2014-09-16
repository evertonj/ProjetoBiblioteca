/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import facade.ExemplarFacade;
import entity.Exemplar;
import entity.Obra;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alex
 */
public class ExemplarController{
    private ExemplarFacade facade;
    
    public ExemplarController() {
        this.facade = new ExemplarFacade();
    }

    public int save(Exemplar exemplar) {
        return facade.save(exemplar);
    }

    public int alterarExemplar(Exemplar exemplar) {
        return facade.update(exemplar);
    }

    public int excluirExemplar(long id) {
        return facade.remove(id);
    }

    public List<Exemplar> finAll() {
        return facade.finAll();
    }
    public List<Exemplar> buscar(String nome) throws SQLException{
        return facade.buscar(nome);
    }
    
}
