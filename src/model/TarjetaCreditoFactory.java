package model;

public class TarjetaCreditoFactory implements FormaPagoFactory {
    @Override
    public FormaPago crearFormaPago() {
        return new TarjetaCredito();
    }
}
