/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.controller;

import biblioteca.entity.Usuario;
import biblioteca.facade.UsuarioFacade;
import java.util.List;

/**
 *
 * @author Alex
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

    public int excluirUsuario(Long id) {
        return facade.remove(id);
    }

    public List<Usuario> finAll() {
        return facade.finAll();
    }
    
}
