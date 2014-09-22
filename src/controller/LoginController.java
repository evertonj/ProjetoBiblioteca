/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.LoginFacade;


/**
 * 
 * @author Familia
 */
public class LoginController {

    private LoginFacade facade;

    public boolean login(String nome, String senha) {
        return facade.login(nome, senha);
    }

}
