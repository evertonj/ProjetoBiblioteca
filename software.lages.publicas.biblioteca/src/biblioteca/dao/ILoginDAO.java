/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.dao;

import biblioteca.entity.Login;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface ILoginDAO {

    int save(Login login);

    int update(Login login);

    int remove(long id);

    List<Login> finAll();

    Login search(String nome);

    boolean login(String nome, String senha);

}
