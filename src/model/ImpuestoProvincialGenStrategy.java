package model;

public class ImpuestoProvincialGenStrategy implements ImpuestoStrategy {
    @Override
    public double calcularImpuesto(Vehiculo vehiculo) {
        return vehiculo.getMonto() * 0.05; // 5% provincial general
    }
}