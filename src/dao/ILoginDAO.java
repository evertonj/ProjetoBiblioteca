/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Login;

/**
 * 
 * @author Familia
 */
public interface ILoginDAO {

    Login search(String nome);

    boolean login(String nome, String senha);

}
