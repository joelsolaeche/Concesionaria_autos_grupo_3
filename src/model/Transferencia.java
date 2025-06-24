package model;

import java.time.LocalDate;

public class Transferencia extends FormaPago {
    private String cbuDestino;
    private String bancoEmisor;
    private String codigoOperacion;
    private LocalDate fechaTransferencia;
    private String nombreTitularCuenta;
    private String idTransaccion;

    @Override
    public boolean procesarPago() {
        // Lógica para simular una transferencia
        estadoPago = "Transferencia realizada";
        return true;
    }
    @Override
    public String getDescripcion() {
        return "Pago por Transferencia Bancaria";
    }

}
