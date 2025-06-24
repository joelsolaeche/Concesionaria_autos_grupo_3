package model;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario {

    private List<String> permisos;
    private boolean activo;

    public Administrador(int id, String nombre, String apellido, String dni, String email, String contraseña) {
        super(id, nombre, apellido, dni, email, contraseña);
        this.permisos = new ArrayList<>();
        this.activo = true;
    }

    public void gestionarUsuarios(List<Usuario> usuarios) {
        // Imprime todos los usuarios del sistema
        System.out.println("Lista de usuarios registrados:");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + " - " + u.getNombre() + " " + u.getApellido() + " - Email: " + u.getEmail());
        }
    }

    public Reporte verEstadisticas(List<PedidoCompra> pedidos) {
        // Crea un reporte consolidado a partir de la lista de pedidos
        Reporte reporte = new Reporte();
        reporte.generarDesdePedidos(pedidos);
        return reporte;
    }


    public void modificarVehiculos(List<Vehiculo> vehiculos, int nroChasis, String nuevoColor, String nuevaMarca, String nuevoModelo, String nuevoMotor, TipoVehiculo nuevoTipo) {
        // Busca vehículo por chasis y actualiza datos
        for (Vehiculo v : vehiculos) {
            if (v.getNroChasis() == nroChasis) {
                v.setColor(nuevoColor);
                v.setMarca(nuevaMarca);
                v.setModelo(nuevoModelo);
                v.setNroMotor(nuevoMotor);
                v.setTipoVehiculo(nuevoTipo);
                System.out.println("Vehículo modificado correctamente.");
                return;
            }
        }
        System.out.println("Vehículo con chasis " + nroChasis + " no encontrado.");
    }

    public void asignarRoles(List<Usuario> usuarios, int usuarioId, RolUsuario nuevoRol) {
        for (Usuario u : usuarios) {
            if (u.getId() == usuarioId) {
                u.setRol(nuevoRol);
                System.out.println("Rol asignado: " + nuevoRol);
                return;

            }
        }
        System.out.println("Usuario con ID " + usuarioId + " no encontrado.");
    }

    public boolean isActivo() {return activo;}
    public void setActivo(boolean activo) {this.activo = activo;}
    public List<String> getPermisos() {return permisos;}
    public void agregarPermiso(String permiso) {
        this.permisos.add(permiso);
    }
}
