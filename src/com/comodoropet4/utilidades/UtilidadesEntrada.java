package com.comodoropet4.utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilidadesEntrada {
    public static double[] obtenerValores(Scanner escanerCreado) {
        double[] valoresAEntregar = new double[2];
        boolean entradaValida = false;

        while (entradaValida == false) {
            try {
                System.out.print("\nIngrese el primer valor a evaluar: ");
                valoresAEntregar[0] = escanerCreado.nextDouble();

                System.out.print("Ingrese el segundo valor a evaluar: ");
                valoresAEntregar[1] = escanerCreado.nextDouble();

                entradaValida = true;
            } catch (InputMismatchException excepcionNumeroInvalido) {
                System.out.println("\n¡Entrada no válida!");
                System.out.println("Por favor, ingrese números válidos.");

                escanerCreado.next();
            }
        }

        return valoresAEntregar;
    }
}
