package model;

public class ImpuestoNacionalStrategy implements ImpuestoStrategy {
    @Override
    public double calcularImpuesto(double montoBase) {
        return montoBase * 0.21; // Ejemplo: 21% nacional
    }
}