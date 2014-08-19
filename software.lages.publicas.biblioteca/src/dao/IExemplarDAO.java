/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Exemplar;
import entity.Obra;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IExemplarDAO {
    int save(List<Exemplar> exemplares, Obra obra);
    
    int update(Exemplar exemplar);
    
    int remove(long id);
    
    List<Exemplar> finAll();
    
    Exemplar buscar(String nome)throws SQLException;
      
    
    
}