package model;

public class ImpuestoProvincialGenStrategy implements ImpuestoStrategy {
    @Override
    public double calcularImpuesto(double montoBase) {
        return montoBase * 0.10; // Ejemplo: 10% provincial general
    }
}