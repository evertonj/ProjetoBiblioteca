/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.IAssuntoDAO;
import dao.AssuntoDAO;
import entity.Assunto;
import java.util.List;

/**
 *
 * @author Alex
 */
public class AssuntoFacade {

    private IAssuntoDAO dao;

    public AssuntoFacade() {
        this.dao = new AssuntoDAO();
    }

    public int save(Assunto assunto) {
        return dao.save(assunto);
    }

    public int update(Assunto assunto) {
        return dao.update(assunto);
    }

    public int remove(int id) {
        return dao.remove(id);
    }

    public List<Assunto> finAll() {
        return dao.finAll();
    }
    public Assunto buscar (String nome){
        return dao.buscar(nome);
    }
}
