/**
 * Programa principal de calculadora para consola.
 *
 * Este programa demuestra el manejo de menús y flujos de control.
 *
 * Autor: Fernando Fernández.
 */
package com.comodoropet4.main;

import com.comodoropet4.calculadora.Calculadora;

import com.comodoropet4.utilidades.MenuConsola;
import com.comodoropet4.utilidades.UtilidadesGeneralesConsola;
import com.comodoropet4.utilidades.UtilidadesEntrada;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);

        String nombreEncabezado = "Calculadora";
        String textoInstrucciones = "Seleccione una de las siguientes opciones: ";

        String[] opcionesMenu = {
            "1. Sumar (+)",
            "2. Restar (-)",
            "3. Multiplicar (*)",
            "4. Dividir (/)",
            "5. Salir (🫡)"
        };

        MenuConsola menuCalculadora = new MenuConsola(textoInstrucciones, opcionesMenu);

        byte opcionMenu = (byte) 0;

        do {
            UtilidadesGeneralesConsola.limpiarPantalla();
            UtilidadesGeneralesConsola.mostrarEncabezado(nombreEncabezado);

            menuCalculadora.mostrarMenu();

            try {
                opcionMenu = escaner.nextByte();
            } catch (InputMismatchException excepcionEntradaInvalida) {
                System.out.println("¡Entrada no válida!");
                System.out.println("Por favor, ingresa un valor entre 1 y 5.");

                escaner.next();
                continue;
            }

            UtilidadesGeneralesConsola.limpiarPantalla();
            UtilidadesGeneralesConsola.mostrarEncabezado(nombreEncabezado);

            if ((opcionMenu >= 1) && (opcionMenu <= 4)) {
                String nombreOperacion = "";
                char operador = '0';

                switch (opcionMenu) {
                    case 1:
                        nombreOperacion = "Suma";
                        operador = '+';
                        break;
                    case 2:
                        nombreOperacion = "Resta";
                        operador = '-';
                        break;
                    case 3:
                        nombreOperacion = "Multiplicación";
                        operador = '*';
                        break;
                    case 4:
                        nombreOperacion = "División";
                        operador = '/';
                        break;
                }

                UtilidadesGeneralesConsola.mostrarSubEncabezado(nombreOperacion);

                double[] valores = UtilidadesEntrada.obtenerValores(escaner);

                operar(valores, opcionMenu, nombreOperacion, operador);

                UtilidadesGeneralesConsola.presionarEnterParaContinuar();
            } else if (opcionMenu == 5) {
                despedirse();
            } else {
                System.out.println("⛔ ¡Opción equivocada!");
                System.out.println("Intenta escoger una opción válida.");

                UtilidadesGeneralesConsola.presionarEnterParaContinuar();
            }
        } while (opcionMenu != 5);

        escaner.close();
    }

    private static void despedirse() {
        System.out.println("\n¡Hasta luego! 👋");
    }

    /*private static void mostrarMenu() {
        System.out.println("\nSeleccione una de las siguientes opciones para realizar una operación: \n");

        System.out.println("1. Sumar (+)");
        System.out.println("2. Restar (-)");
        System.out.println("3. Multiplicar (*)");
        System.out.println("4. Dividir (/)\n");

        System.out.println("5. Salir (🫡)\n");
    }*/

    private static void operar(double[] valoresEntregados, int opcionMenu, String nombreOperacion, char operador) {
        double resultado = 0;
        boolean resultadoValido = true;

        switch (opcionMenu) {
            case 1:
                resultado = Calculadora.sumar(valoresEntregados[0], valoresEntregados[1]);
                break;
            case 2:
                resultado = Calculadora.restar(valoresEntregados[0], valoresEntregados[1]);
                break;
            case 3:
                resultado = Calculadora.multiplicar(valoresEntregados[0], valoresEntregados[1]);
                break;
            case 4:
                try {
                    resultado = Calculadora.dividir(valoresEntregados[0], valoresEntregados[1]);
                } catch (ArithmeticException excepcionDividirPorCero) {
                    System.out.println(excepcionDividirPorCero.getMessage());
                    resultadoValido = false;
                }
                break;
        }

        if (resultadoValido == true) {
            String resultadoMostrado = UtilidadesGeneralesConsola.darFormatoANumero(resultado);
            String valorMostrado1 = UtilidadesGeneralesConsola.darFormatoANumero(valoresEntregados[0]);
            String valorMostrado2 = UtilidadesGeneralesConsola.darFormatoANumero(valoresEntregados[1]);

            System.out.printf("\nEl resultado de la %s es el siguiente:\n", nombreOperacion.toLowerCase());
            System.out.printf("%s %c %s = %s\n", valorMostrado1, operador, valorMostrado2, resultadoMostrado);
        }
    }
}