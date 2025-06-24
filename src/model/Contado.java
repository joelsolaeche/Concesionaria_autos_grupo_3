package model;

public class Contado extends FormaPago {
    private double montoPagado;

    @Override
    public boolean procesarPago() {
        // Simulación de pago en efectivo
        estadoPago = "Pagado en efectivo";
        return true;
    }

    @Override
    public String getDescripcion() {
        return "Pago en Contado";
    }
}


