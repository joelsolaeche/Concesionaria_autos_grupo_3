package model;

public class ImpuestoProvAdiStrategy implements ImpuestoStrategy {

    @Override
    public double calcularImpuesto(Vehiculo vehiculo) {
        switch (vehiculo.getTipoVehiculo()) {
            case CAMION:
            case CAMIONETA:
                return vehiculo.getMonto() * 0.02;
            case AUTO:
            case MOTO:
                return vehiculo.getMonto() * 0.01;
            default:
                return 0;
        }
    }
}