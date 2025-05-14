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




    public void procesarMontoTotal (double costoTotal, double impuestoTotal) {
        this.costoTotal = costoTotal + impuestoTotal;
    }

    public void procesarDatosFacturacion(String nombre, int cuit, String direccion) {
        //logica para procesar los datos de facturacion
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
                "Área Responsable: " + areaResponsableActual.getNombre() + "\n" +
                "Estado Pedido: " + estadoPedido.getNumeroPedido();
    }

    //getters setters

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

    public void setAreaResponsableActual(Area areaResponsableActual) {
        this.areaResponsableActual = areaResponsableActual;
    }

    public List<HistorialPedidoCompra> getHistorialPedidoCompra() {
        return historialPedidoCompra;
    }

    public void setHistorialPedidoCompra(List<HistorialPedidoCompra> historialPedidoCompra) {
        this.historialPedidoCompra = historialPedidoCompra;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}
