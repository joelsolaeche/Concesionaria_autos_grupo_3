package model;

public class TransferenciaFactory implements FormaPagoFactory {
    @Override
    public FormaPago crearFormaPago() {
        return new Transferencia();
    }
}
