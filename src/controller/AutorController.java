/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import entity.Autor;
import facade.AutorFacade;
import java.util.List;

/**
 *
 * @author Everton Spindola
 */
public class AutorController{
    private AutorFacade facade;
    
    public AutorController() {
        this.facade = new AutorFacade();
    }
    public Autor buscaNomeSobrenome(String nome, String sobrenome){
       return facade.buscaNomeSobrenome(nome, sobrenome);
        
    
}

    public int addAutor(Autor autor) {
        return facade.save(autor);
    }

    public int alterarAutor(Autor autor) {
        return facade.update(autor);
    }

    public int excluirAutor(long id) {
        return facade.remove(id);
    }

    public List<Autor> finAll() {
        return facade.finAll();
    }
    public List<Autor> buscar(String nome){
        return facade.buscar(nome);
    }
    
}
