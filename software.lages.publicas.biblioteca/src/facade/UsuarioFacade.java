/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.IUsuarioDAO;
import dao.UsuarioDAO;
import entity.Usuario;
import java.util.List;

/**
 *
 * @author Alex
 */
public class UsuarioFacade {

    private IUsuarioDAO dao;

    public UsuarioFacade() {
        this.dao = new UsuarioDAO();
    }

    public int save(Usuario usuario) {
        return dao.save(usuario);
    }

    public int update(Usuario usuario) {
        return dao.update(usuario);
    }

    public int remove(Long id) {
        return dao.remove(id);
    }

    public List<Usuario> finAll() {
        return dao.findAll();
    }
}
