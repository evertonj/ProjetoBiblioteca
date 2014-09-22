/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import facade.AssuntoFacade;
import entity.Assunto;
import java.util.List;

/**
 *
 * @author Alex
 */
public class AssuntoController{
    private AssuntoFacade facade;
    
    public AssuntoController() {
        this.facade = new AssuntoFacade();
    }

    public int addAssunto(Assunto assunto) {
        return facade.save(assunto);
    }

    public int alterarAssunto(Assunto assunto) {
        return facade.update(assunto);
    }

    public int excluirAssunto(int id) {
        return facade.remove(id);
    }

    public List<Assunto> finAll() {
        return facade.finAll();
    }
    public Assunto buscar(String nome){
        return facade.buscar(nome);
    }
    
}
