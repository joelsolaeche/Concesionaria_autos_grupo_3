package model;

import java.util.Date;

public class TarjetaCredito extends FormaPago {
    private String titular;
    private Date fechaVencimiento;
    private String cvv;
    private String tipoTarjeta;
    private int cuotas;
    private String idTransaccion;

    @Override
    public boolean procesarPago() {
        // Lógica para simular pago con tarjeta
        estadoPago = "Pago con tarjeta aprobado";
        return true;
    }
    @Override
    public String getDescripcion() {
        return "Pago con Tarjeta: " + tipoTarjeta + " en " + cuotas + " cuotas";
    }

}
