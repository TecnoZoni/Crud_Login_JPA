package com.mycompany.login.persistencia;

import com.mycompany.login.logica.Rol;
import com.mycompany.login.logica.Usuario;
import com.mycompany.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    UsuarioJpaController userJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        return userJpa.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    public void crearUsuario(Usuario usu) {
        userJpa.create(usu);
    }

    public void borrarUsuarios(int idUsuario) {
        try {
            userJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int idUsuario) {
        return userJpa.findUsuario(idUsuario);
    }

    public void editarUsuario(Usuario us) {
        try {
            userJpa.edit(us);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
