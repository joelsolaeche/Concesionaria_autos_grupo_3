package model;

import java.util.List;

public class VendedorFacade implements UsuarioFacade {

    private Vendedor vendedor;
    private List<Vehiculo> catalogo;

    public VendedorFacade(Vendedor vendedor, List<Vehiculo> catalogo) {
        this.vendedor = vendedor;
        this.catalogo = catalogo;
    }

    @Override
    public boolean accederSistema(String nombreUsuario, String contrasena) {
        return vendedor.accederSistema(nombreUsuario, contrasena);
    }

    public List<Vehiculo> obtenerVehiculosDisponibles() {
        return vendedor.verListaVehiculosDisponibles(catalogo);
    }

    public void registrarVenta(Vehiculo vehiculo, Comprador comprador) {
        boolean exito = vendedor.registrarVenta(vehiculo, comprador);
        if (exito) {
            Ventas ventas = new Ventas();
            // Notificamos al área de ventas como parte del flujo
            ventas.notificarArea();
        }
    }

    public List<Comprador> obtenerClientes() {
        return vendedor.verClientes();
    }


}
