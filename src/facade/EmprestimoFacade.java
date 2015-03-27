/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EmprestimoDAO;
import dao.IEmprestimoDAO;
import entity.Emprestimo;

/**
 *
 * @author Beatriz
 */
public class EmprestimoFacade {

    private IEmprestimoDAO dao;
    
    public EmprestimoFacade() {
        dao = new EmprestimoDAO();
    }
    
    public void emprestimo(Emprestimo emprestimo) {
        dao.emprestimo(emprestimo);
    }
}
