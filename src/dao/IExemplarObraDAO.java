/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.ExemplarEmprestimo;
import entity.Obra;
import entity.exceptions.NameException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IExemplarObraDAO {
    
    int save(Obra obra);
    
    int update(Obra obra);
    
    int remove(int id);
    
    List<Obra> findAll() throws SQLException, NameException;
    
    List<ExemplarEmprestimo> consulta(String titulo) throws SQLException;
    
    List<ExemplarEmprestimo> consultaPorCodigo(int codigo) throws SQLException;
}
