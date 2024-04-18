package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public Usuario comprobarUsuario(String usuario, String contraseña) {

        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        Usuario usr = null;

        for (Usuario user : listaUsuarios) {
            if (user.getNombre().equals(usuario)) {
                if (user.getContrasenia().equals(contraseña)) {
                    usr = user;
                    return usr;
                } else {
                    usr = null;
                    return usr;
                }
            }
        }

        return usr;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String ususario, String contra, String rolRecibido) {
        Usuario usu = new Usuario();

        usu.setNombre(ususario);
        usu.setContrasenia(contra);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }

        controlPersis.crearUsuario(usu);

    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();

        for (Rol rol : listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    public void borarUsuario(int idUsuario) {
        controlPersis.borrarUsuarios(idUsuario);
    }

    public Usuario traerUsuario(int idUsuario) {
        return controlPersis.traerUsuario(idUsuario);
    }

    public void editarUsuario(Usuario us, String ususario, String contra, String rolRecibido) {

        us.setNombre(ususario);
        us.setContrasenia(contra);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            us.setUnRol(rolEncontrado);
        }
        controlPersis.editarUsuario(us);
    }

}
