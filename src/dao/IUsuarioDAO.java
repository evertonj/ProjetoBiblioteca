/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Usuario;
import java.util.List;

/**
 *
 * @author Thiago
 */
public interface IUsuarioDAO {
    
    int save(Usuario usuario);
    
    int update(Usuario usuario);
    
    int remove(int id);
    
    List<Usuario> findAll();
    
}
