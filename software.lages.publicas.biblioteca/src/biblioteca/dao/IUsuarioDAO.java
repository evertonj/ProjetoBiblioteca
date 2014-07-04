/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.dao;

import biblioteca.entity.Usuario;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IUsuarioDAO {
    
    int save(Usuario usuario);
    
    int update(Usuario usuario);
    
    int remove(Long id);
    
    List<Usuario> findAll();
}
