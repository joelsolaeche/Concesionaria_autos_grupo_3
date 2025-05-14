package model;

import java.util.Date;

public class Usuario {

    //atributos
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String email;
    protected String contraseña;
    protected Date fechaRegistro;




    // Constructor
    public boolean iniciarSesion(String email, String contraseña) {
        // Lógica de autenticación
        return true;
    }

    public void cerrarSesion() {
        // Lógica de cierre de sesión
    }

    public void actualizarDatos(Usuario nuevosDatos) {
        // Lógica para actualizar datos del usuario
    }

    public Usuario verPerfil() {
        return this;
    }

    public void accederSistema() {
        // Lógica para acceder al sistema
    }


}
