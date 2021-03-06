/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ILoginDAO;
import dao.LoginDAO;
import entity.Login;

/**
 * 
 * @author Familia
 */
public class LoginFacade {

    private ILoginDAO dao;

    public LoginFacade() {
        this.dao = new LoginDAO();
    }

    public Login search(String nome) {
        return dao.search(nome);
    }

    public boolean login(String nome, String senha) {
        return dao.login(nome, senha);
    }
}
