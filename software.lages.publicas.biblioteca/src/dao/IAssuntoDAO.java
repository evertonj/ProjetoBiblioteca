/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Assunto;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IAssuntoDAO {
    int save(Assunto assunto);
    
    int update(Assunto assunto);
    
    int remove(long id);
    
    List<Assunto> finAll();
    
    Assunto buscar(String nome);
      
    
    
}