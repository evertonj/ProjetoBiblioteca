/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.IExemplarDAO;
import dao.ExemplarDAO;
import entity.Exemplar;
import entity.Obra;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alex
 */
public class ExemplarFacade {

    private IExemplarDAO dao;

    public ExemplarFacade() {
        this.dao = new ExemplarDAO();
    }

    public int save(Exemplar exemplar) {
        return dao.save(exemplar);
    }

    public int update(Exemplar exemplar) {
        return dao.update(exemplar);
    }

    public int remove(long id) {
        return dao.remove(id);
    }

    public List<Exemplar> finAll() {
        return dao.finAll();
    }
    public List<Exemplar> buscar (String nome) throws SQLException{
        return dao.buscar(nome);
    }
}
