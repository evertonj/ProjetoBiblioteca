/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.IOperadorDAO;
import dao.OperadorDAO;
import entity.Operador;
import java.util.List;

/**
 *
 * @author Alex
 */
public class OperadorFacade {

    private IOperadorDAO dao;

    public OperadorFacade() {
        this.dao = new OperadorDAO();
    }

    public int save(Operador operador) {
        return dao.save(operador);
    }

    public int update(Operador operador) {
        return dao.update(operador);
    }

    public int remove(int id) {
        return dao.remove(id);
    }
    
    public Operador search(String nome) {
        return dao.search(nome);
    }
    
    public Operador searchOperadorAuthentication(String nome, String senha) {
        return dao.searchOperadorAuthentication(nome, senha);
    }
    
    public List<Operador> listaDeOperadores(String name) {
        return dao.listOfOperator(name);
    }

    public List<Operador> finAll() {
        return dao.findAll();
    }
}
