package model;

public class ImpuestoProvAdiStrategy implements ImpuestoStrategy {
    @Override
    public double calcularImpuesto(double montoBase) {
        return montoBase * 0.05; // Ejemplo: 5% adicional
    }
}