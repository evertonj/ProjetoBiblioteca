/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CadastroDeObra.dao;

import CadastroDeObra.model.Obra;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IObraDAO {
    
    int save(Obra obra);
    
    int update(Obra obra);
    
    int remove(int id);
    
    List<Obra> findAll();
    
    List<Obra> consulta(String titulo);
    
    List<Obra> consulta(int codigo);
}
