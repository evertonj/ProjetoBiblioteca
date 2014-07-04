/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.facade;

import biblioteca.dao.ILoginDAO;
import biblioteca.dao.LoginDAO;
import biblioteca.entity.Login;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LoginFacade {

    private ILoginDAO dao;

    public LoginFacade() {
        this.dao = new LoginDAO();
    }

    public int save(Login login) {
        return dao.save(login);
    }

    public int update(Login login) {
        return dao.update(login);
    }

    public int remove(long id) {
        return dao.remove(id);
    }

    public List<Login> finAll() {
        return dao.finAll();
    }

    public Login search(String nome) {
        return dao.search(nome);
    }
    
    public boolean login(String nome, String senha){
        return dao.login(nome, senha);
    }
}
