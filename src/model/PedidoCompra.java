package model;

import java.util.Date;
import java.util.List;

public class PedidoCompra {

    private int nroPedido;
    private Date fecha;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double costoTotal;
    private FormaPago formaPago;
    private Area areaResponsableActual;
    private List<HistorialPedidoCompra> historialPedidoCompra;
    private EstadoPedido estadoPedido;
    // Publicador para manejar observadores
    private PublicadorPedidoCompra publicador = new PublicadorPedidoCompra();


    public PedidoCompra(int nroPedido, Date fecha, Cliente cliente, Vehiculo vehiculo, double costoTotal,
            FormaPago formaPago, Area areaResponsableActual, List<HistorialPedidoCompra> historialPedidoCompra,
            EstadoPedido estadoPedido) {
        this.nroPedido = nroPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.costoTotal = costoTotal;
        this.formaPago = formaPago;
        this.areaResponsableActual = areaResponsableActual;
        this.historialPedidoCompra = historialPedidoCompra;
        this.estadoPedido = estadoPedido;
    }

    public PedidoCompra() {}

    public void procesarMontoTotal (double costoTotal, double impuestoTotal) {
        this.costoTotal = costoTotal + impuestoTotal;
    }

    // Permitirá registrar cada cambio de estado en la lista
    public void agregarAlHistorial(EstadoPedido nuevoEstado, Area nuevaArea) {
        HistorialPedidoCompra registro = new HistorialPedidoCompra(new Date(), nuevoEstado, nuevaArea);
        historialPedidoCompra.add(registro);
    }

    public void procesarDatosFacturacion(String nombre, int cuit, String direccion) {
        System.out.println("Generando factura para: " + nombre);
        System.out.println("CUIT: " + cuit + " | Dirección: " + direccion);
    }


    public String toCSV() {
        return nroPedido + "," +
                fecha + "," +
                cliente.getNombre() + "," +
                vehiculo.getTipoVehiculo() + "," +
                costoTotal + "," +
                formaPago.getDescripcion() + "," +
                areaResponsableActual.getNombreArea() + "," +
                estadoPedido.getNumeroPedido();
    }

    public String toPDF() {
        // Placeholder for PDF generation
        return "PedidoCompra PDF: \n" +
                "Número de Pedido: " + nroPedido + "\n" +
                "Fecha: " + fecha + "\n" +
                "Cliente: " + cliente.getNombre() + "\n" +
                "Vehículo: " + vehiculo.getTipoVehiculo() + "\n" +
                "Costo Total: " + costoTotal + "\n" +
                "Forma de Pago: " + formaPago.getDescripcion() + "\n" +
                "Área Responsable: " + areaResponsableActual.getNombreArea() + "\n" +
                "Estado Pedido: " + estadoPedido.getNumeroPedido();
    }

    //Metodo para registrar áreas observadoras
    public void registrarArea(Area area) {
        publicador.agregarObservador(area);
    }

    // Cambia el estado del pedido y dispara notificaciones
    public void cambiarEstado(EstadoPedido nuevoEstado, Area nuevaArea) {
        this.estadoPedido = nuevoEstado;
        this.areaResponsableActual = nuevaArea;
        agregarAlHistorial(nuevoEstado, nuevaArea);
        System.out.println("Pedido #" + nroPedido + " actualizado a estado: " + nuevoEstado.getNumeroPedido());
        publicador.notificarObservadores();
    }



    // Getters and Setters
    public int getNroPedido() {
        return nroPedido;
    }
    public void setNroPedido(int nroPedido) {
        this.nroPedido = nroPedido;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public double getCostoTotal() {
        return costoTotal;
    }
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    public FormaPago getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    public Area getAreaResponsableActual() {
        return areaResponsableActual;
    }
    public void setAreaResponsableActual(Area areaResponsableActual) {this.areaResponsableActual = areaResponsableActual;}
    public List<HistorialPedidoCompra> getHistorialPedidoCompra() {
        return historialPedidoCompra;
    }
    public void setHistorialPedidoCompra(List<HistorialPedidoCompra> historialPedidoCompra) {this.historialPedidoCompra = historialPedidoCompra;}
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }
    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}
