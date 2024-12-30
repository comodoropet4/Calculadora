import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static byte opcionMenu = 0;
    private static int valor1 = 0;
    private static int valor2 = 0;
    private static int total = 0;

    private static final Scanner escaner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            limpiarPantalla();
            mostrarEncabezadoCalculadora();

            mostrarMenu();

            try{
                opcionMenu = escaner.nextByte();
            } catch (InputMismatchException excepcionEntradaInvalida) {
                System.out.println("¡Entrada no válida!");
                System.out.println("Por favor, ingresa un valor entre 1 y 5.");

                escaner.next();
                continue;
            }

            limpiarPantalla();
            mostrarEncabezadoCalculadora();

            switch (opcionMenu) {
                case 1:
                    sumar();
                    break;
                case 2:
                    restar();
                    break;
                case 3:
                    multiplicar();
                    break;
                case 4:
                    dividir();
                    break;
                case 5:
                    despedirse();
                    break;
                default:
                    System.out.println("⛔ ¡Opción equivocada!");
                    System.out.println("Intenta escoger una opción válida.");
                    break;
            }

            if (opcionMenu != 5) {
                System.out.println("\nPresione la tecla Enter/Intro para continuar...");

                try {
                    System.in.read();
                } catch (IOException excepcionTecla) {
                    excepcionTecla.printStackTrace();
                }
            }
        } while (opcionMenu != 5);
    }

    private static void despedirse() {
        System.out.println("¡Hasta luego! 👋");
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione una de las siguientes opciones para realizar una operación: \n");

        System.out.println("1. Sumar (+)");
        System.out.println("2. Restar (-)");
        System.out.println("3. Multiplicar (*)");
        System.out.println("4. Dividir (/)\n");

        System.out.println("5. Salir (🫡)");
    }

    private static void limpiarPantalla() {
        for (int lineaConsola = 0; lineaConsola < 50; lineaConsola++) {
            System.out.println();
        }
    }

    private static void mostrarEncabezadoCalculadora() {
        System.out.println("Calculadora");
        System.out.println("===========\n");
    }

    private static void obtenerValores() {
        boolean entradaValida = false;

        while (entradaValida == false) {
            try {
                System.out.print("Ingrese el primer valor a evaluar:");
                valor1 = escaner.nextInt();

                System.out.print("Ingrese el segundo valor a evaluar:");
                valor2 = escaner.nextInt();

                entradaValida = true;
            } catch (NumberFormatException excepcionNumeroInvalido) {
                System.out.println("¡Entrada no válida!");
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private static void sumar() {
        System.out.println("Suma \n");

        obtenerValores();

        total = valor1 + valor2;

        System.out.println("\nEl resultado de la operación es el siguiente:");
        System.out.printf("%d + %d = %d%n", valor1, valor2, total);
    }

    private static void restar() {
        System.out.println("Resta \n");

        obtenerValores();

        total = valor1 - valor2;

        System.out.println("\nEl resultado de la operación es el siguiente:");
        System.out.printf("%d - %d = %d%n", valor1, valor2, total);
    }

    private static void multiplicar() {
        System.out.println("Multiplicación \n");

        obtenerValores();

        total = valor1 * valor2;

        System.out.println("\nEl resultado de la operación es el siguiente:");
        System.out.printf("%d * %d = %d%n", valor1, valor2, total);
    }

    private static void dividir() {
        System.out.println("División \n");

        obtenerValores();

        total = valor1 / valor2;

        System.out.println("\nEl resultado de la operación es el siguiente:");
        System.out.printf("%d / %d = %d%n", valor1, valor2, total);
    }
}