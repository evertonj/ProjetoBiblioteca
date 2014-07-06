/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroDeAutor.facade;

import cadastroDeAutor.dao.IAutorDAO;
import cadastroDeAutor.dao.AutorDAO;
import cadastroDeAutor.entity.Autor;
import java.util.List;

/**
 *
 * @author Alex
 */
public class AutorFacade {

    private IAutorDAO dao;

    public AutorFacade() {
        this.dao = new AutorDAO();
    }

    public int save(Autor autor) {
        return dao.save(autor);
    }

    public int update(Autor autor) {
        return dao.update(autor);
    }

    public int remove(long id) {
        return dao.remove(id);
    }

    public List<Autor> finAll() {
        return dao.finAll();
    }
    public Autor buscar (String nome){
        return dao.buscar(nome);
    }
}
