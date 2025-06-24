package model;


public class ImpuestoNacionalStrategy implements ImpuestoStrategy {
    @Override
    public double calcularImpuesto(Vehiculo vehiculo) {
        switch (vehiculo.getTipoVehiculo()) {
            case AUTO:
                return vehiculo.getMonto() * 0.21;
            case CAMIONETA:
                return vehiculo.getMonto() * 0.10;
            default:
                return 0;
        }
    }
}