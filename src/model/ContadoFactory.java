package model;

public class ContadoFactory implements FormaPagoFactory {
    @Override
    public FormaPago crearFormaPago() {
        return new Contado();
    }
}

