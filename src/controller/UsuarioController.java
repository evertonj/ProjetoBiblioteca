/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import entity.Usuario;
import facade.UsuarioFacade;
import java.util.List;

/**
 *
 * @author Thiago
 */
public class UsuarioController {
    
    private UsuarioFacade facade;
    
    public UsuarioController() {
        this.facade = new UsuarioFacade();
    }

    public int addUsuario(Usuario usuario) {
        return facade.save(usuario);
    }

    public int alterarUsuario(Usuario usuario) {
        return facade.update(usuario);
    }

    public int excluirUsuario(int id) {
        return facade.remove(id);
    }

    public List<Usuario> finAll() {
        return facade.finAll();
    }
}
