package model;

import java.util.Date;

public class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String direccion;
    private long cuit;
    private Date fechaAlta;

    public Cliente(int id, String nombre, String apellido, String dni, String email, String telefono, String direccion, long cuit, Date fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuit = cuit;
        this.fechaAlta = fechaAlta;
    }


    // Metodo para validar que el cliente tenga datos completos
    public boolean esClienteValido() {
        return nombre != null && apellido != null && email != null && dni != null && !email.isBlank();
    }

    // Metodo opcional para mostrar resumen de cliente
    public String obtenerResumen() {
        return nombre + " " + apellido + " (DNI: " + dni + ") – Email: " + email;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public double getCuit() { return cuit; }
    public void setCuit(long cuit) { this.cuit = cuit; }
    public Date getFechaAlta() { return fechaAlta; }
}
