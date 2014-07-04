/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadastroDeEditora.facade;

import CadastroDeEditora.dao.IEditoraDAO;
import CadastroDeEditora.dao.EditoraDAO;
import CadastroDeEditora.entity.Editora;
import java.util.List;

/**
 *
 * @author Alex
 */
public class EditoraFacade {

    private IEditoraDAO dao;

    public EditoraFacade() {
        this.dao = new EditoraDAO();
    }

    public int save(Editora obra) {
        return dao.save(obra);
    }

    public int update(Editora obra) {
        return dao.update(obra);
    }

    public int remove(long id) {
        return dao.remove(id);
    }

    public List<Editora> finAll() {
        return dao.finAll();
    }
    public Editora buscar (String nome){
        return dao.buscar(nome);
    }
}
