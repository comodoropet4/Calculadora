package com.comodoropet4.calculadora;

/**
 * Clase que proporciona operaciones matemáticas básicas.
 * Todas las operaciones soportan números decimales.
 */
public class Calculadora {
    public static double sumar(double sumando1, double sumando2) {
        return sumando1 + sumando2;
    }

    public static double restar(double minuendo, double sustraendo) {
        return minuendo - sustraendo;
    }

    public static double multiplicar(double multiplicando, double multiplicador) {
        return multiplicando * multiplicador;
    }

    public static double dividir(double dividendo, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir entre 0.");
        } else {
            return dividendo / divisor;
        }
    }
}
