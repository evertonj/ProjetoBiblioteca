/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CadastroDeEditora.controller;

import CadastroDeEditora.facade.EditoraFacade;
import CadastroDeEditora.entity.Editora;
import java.util.List;

/**
 *
 * @author Alex
 */
public class EditoraController{
    private EditoraFacade facade;
    
    public EditoraController() {
        this.facade = new EditoraFacade();
    }

    public int addEditora(Editora editora) {
        return facade.save(editora);
    }

    public int alterarEditora(Editora editora) {
        return facade.update(editora);
    }

    public int excluirEditora(long id) {
        return facade.remove(id);
    }

    public List<Editora> finAll() {
        return facade.finAll();
    }
    public Editora buscar(String nome){
        return facade.buscar(nome);
    }
    
}
