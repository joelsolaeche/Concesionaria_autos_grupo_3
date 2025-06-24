package model;

public class ImpuestoProvAdiStrategy implements ImpuestoStrategy {

    @Override
    public double calcularImpuesto(double montoBase) {
        return montoBase * 0.03; // 3% adicional
    }
}