package model;

import java.util.List;

public class AdministradorFacade implements UsuarioFacade {

    private Administrador admin;
    private List<Usuario> usuarios;
    private List<Vehiculo> vehiculos;
    private List<PedidoCompra> pedidos;

    public AdministradorFacade(Administrador admin, List<Usuario> usuarios, List<Vehiculo> vehiculos, List<PedidoCompra> pedidos) {
        this.admin = admin;
        this.usuarios = usuarios;
        this.vehiculos = vehiculos;
        this.pedidos = pedidos;
    }

    public void verTodosLosClientes() {
        admin.gestionarUsuarios(usuarios);
    }


    public void generarReportePedidos() {
        Reporte r = admin.verEstadisticas(pedidos);
        r.mostrar();
    }

    @Override
    public boolean accederSistema(String usuario, String contrasena) {
        return admin.iniciarSesion(usuario, contrasena);
    }
}