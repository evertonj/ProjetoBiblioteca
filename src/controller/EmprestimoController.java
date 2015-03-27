/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Emprestimo;
import facade.EmprestimoFacade;

/**
 *
 * @author Beatriz
 */
public class EmprestimoController {
    
    private EmprestimoFacade empFacade;
    
    public EmprestimoController() {
        empFacade = new EmprestimoFacade();
    }
    
    public void emprestimo(Emprestimo emprestimo) {
        empFacade.emprestimo(emprestimo);
    }
}
