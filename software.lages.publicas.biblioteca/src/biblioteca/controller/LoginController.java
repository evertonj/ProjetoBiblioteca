/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.controller;

import biblioteca.entity.Login;
import biblioteca.facade.LoginFacade;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LoginController{
    private LoginFacade facade;
    
    public LoginController() {
        this.facade = new LoginFacade();
    }

    public int addLogin(Login login) {
        return facade.save(login);
    }

    public int alterarLogin(Login login) {
        return facade.update(login);
    }

    public int excluirLogin(long id) {
        return facade.remove(id);
    }

    public List<Login> finAll() {
        return facade.finAll();
    }
    public Login search(String nome){
        return facade.search(nome);
    }
    public boolean login(String nome, String senha){
        return facade.login(nome, senha);
    }
    
}
