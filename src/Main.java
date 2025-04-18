/**
 * Programa principal de calculadora para consola.
 *
 * Este programa demuestra el manejo de menús y flujos de control.
 *
 * Autor: Fernando Fernández.
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);

        byte opcionMenu = (byte) 0;

        do {
            limpiarPantalla();
            mostrarEncabezado();

            mostrarMenu();

            try {
                opcionMenu = escaner.nextByte();
            } catch (InputMismatchException excepcionEntradaInvalida) {
                System.out.println("¡Entrada no válida!");
                System.out.println("Por favor, ingresa un valor entre 1 y 5.");

                escaner.next();
                continue;
            }

            limpiarPantalla();
            mostrarEncabezado();

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

                mostrarEncabezado(nombreOperacion);

                int[] valores = obtenerValores(escaner);

                operar(valores, opcionMenu, nombreOperacion, operador);

                presionarEnterParaContinuar();
            } else if (opcionMenu == 5) {
                despedirse();
            } else {
                System.out.println("⛔ ¡Opción equivocada!");
                System.out.println("Intenta escoger una opción válida.");
                break;
            }
        } while (opcionMenu != 5);

        escaner.close();
    }

    private static void presionarEnterParaContinuar() {
        System.out.println("\nPresione la tecla Enter/Intro para continuar...");

        try {
            System.in.read();
        } catch (IOException excepcionTecla) {
            excepcionTecla.printStackTrace();
        }
    }

    private static void despedirse() {
        System.out.println("\n¡Hasta luego! 👋");
    }

    private static void mostrarMenu() {
        System.out.println("\nSeleccione una de las siguientes opciones para realizar una operación: \n");

        System.out.println("1. Sumar (+)");
        System.out.println("2. Restar (-)");
        System.out.println("3. Multiplicar (*)");
        System.out.println("4. Dividir (/)\n");

        System.out.println("5. Salir (🫡)\n");
    }

    private static void limpiarPantalla() {
        for (int lineaConsola = 0; lineaConsola < 50; lineaConsola++) {
            System.out.println();
        }
    }

    private static void mostrarEncabezado() {
        System.out.println("\nCalculadora");
        System.out.println("===========");
    }

    private static void mostrarEncabezado(String nombreOperacion) {
        System.out.printf("\n%s\n", nombreOperacion);
    }

    private static int[] obtenerValores(Scanner escanerCreado) {
        int[] valoresAEntregar = new int[2];

        boolean entradaValida = false;

        while (entradaValida == false) {
            try {
                System.out.print("\nIngrese el primer valor a evaluar: ");
                valoresAEntregar[0] = escanerCreado.nextInt();

                System.out.print("Ingrese el segundo valor a evaluar: ");
                valoresAEntregar[1] = escanerCreado.nextInt();

                entradaValida = true;
            } catch (InputMismatchException excepcionNumeroInvalido) {
                System.out.println("\n¡Entrada no válida!");
                System.out.println("Por favor, ingrese números válidos.");

                escanerCreado.next();
            }
        }

        return valoresAEntregar;
    }

    private static void operar(int[] valoresEntregados, int opcionMenu, String nombreOperacion, char operador) {
        int resultado = 0;
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
            System.out.printf("\nEl resultado de la %s es el siguiente:\n", nombreOperacion.toLowerCase());
            System.out.printf("%d %c %d = %d\n", valoresEntregados[0], operador, valoresEntregados[1], resultado);
        }
    }
}