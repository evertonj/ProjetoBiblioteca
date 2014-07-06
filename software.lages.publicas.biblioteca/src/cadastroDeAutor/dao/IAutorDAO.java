/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadastroDeAutor.dao;

import cadastroDeAutor.entity.Autor;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IAutorDAO {
    int save(Autor autor);
    
    int update(Autor autor);
    
    int remove(long id);
    
    List<Autor> finAll();
    
    Autor buscar(String nome);
      
    
    
}