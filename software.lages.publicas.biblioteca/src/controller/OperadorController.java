/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.Operador;
import facade.OperadorFacade;
import java.util.List;

/**
 *
 * @author Alex
 */
public class OperadorController {

    private OperadorFacade facade;

    public OperadorController() {
        this.facade = new OperadorFacade();
    }

    public int addOperador(Operador operador) {
        return facade.save(operador);
    }

    public int alterarOperador(Operador operador) {
        return facade.update(operador);
    }

    public int excluirOperador(Long id) {
        return facade.remove(id);
    }

    public Operador buscarOperador(String nome) {
        return facade.search(nome);
    }

    public List<Operador> finAll() {
        return facade.finAll();
    }

}
