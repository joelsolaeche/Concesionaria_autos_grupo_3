package model;

import java.util.Date;

public class Usuario implements UsuarioFacade{

    //atributos
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String email;
    protected String contrasena;
    protected Date fechaRegistro;

    protected RolUsuario rol;


    // Constructor
    public Usuario(int id, String nombre, String apellido, String dni, String email, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.contrasena = contrasena;
        this.fechaRegistro = new Date(); // Fecha de creación
    }

    public boolean iniciarSesion(String email, String contrasena) {
        // Verifica si el email y contraseña ingresados coinciden con los del usu
        return this.email.equals(email) && this.contrasena.equals(contrasena);
    }

    public void cerrarSesion() {
        // Cierra la sesión simulando un mensaje
        System.out.println("Sesión cerrada correctamente para el usuario: " + this.nombre + " - Email: " + this.email);
    }

    public void actualizarDatos(Usuario nuevosDatos) {
        // Copia todos los datos del nuevo usuario
        this.nombre = nuevosDatos.nombre;
        this.apellido = nuevosDatos.apellido;
        this.dni = nuevosDatos.dni;
        this.email = nuevosDatos.email;
        this.contrasena = nuevosDatos.contrasena;
        System.out.println("Datos del usuario actualizados correctamente.");
    }

    public Usuario verPerfil() {
        // Devuelve el mismo objeto para ser mostrado en pantalla
        return this;
    }


    // Metodo de la interfaz
    @Override
    public boolean accederSistema(String nombreUsuario, String contrasena) {
        // Encapsula la lógica de acceso usando iniciarSesion()
        return iniciarSesion(nombreUsuario, contrasena);
    }


    // Getters and Setters
    public void setRol(RolUsuario rol) {this.rol = rol;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getcontrasena() {return contrasena;}
    public void setcontrasena(String contrasena) {this.contrasena = contrasena;}
    public Date getFechaRegistro() {return fechaRegistro;}
    public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro;}
}
