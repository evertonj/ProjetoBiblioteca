/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Operador;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IOperadorDAO {
    
    int save(Operador usuario);
    
    int update(Operador usuario);
    
    int remove(Long id);
    
    Operador search(String nome);
    
    List<Operador> findAll();
}
