package model;

public class ImpuestoProvincialGenStrategy implements ImpuestoStrategy {
    @Override
    public double calcularImpuesto(double montoBase) {
        return montoBase * 0.05; // 5% provincial general
    }
}