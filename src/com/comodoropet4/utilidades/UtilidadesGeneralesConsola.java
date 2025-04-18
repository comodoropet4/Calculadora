package com.comodoropet4.utilidades;

import java.math.BigDecimal;

public class UtilidadesGeneralesConsola {
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void presionarEnterParaContinuar() {
        System.out.println("\nPresione la tecla Enter/Intro para continuar...");

        try {
            System.in.read();
        } catch (Exception excepcionTecla) {
            excepcionTecla.printStackTrace();
        }
    }

    public static void despedirse() {
        System.out.println("\n¡Hasta luego! 👋");
    }

    public static void mostrarEncabezado(String encabezado) {
        System.out.printf("\n%s\n", encabezado);
        System.out.println("===========");
    }

    public static void mostrarSubEncabezado(String subEncabezado) {
        System.out.printf("%s\n", subEncabezado);
    }

    public static String darFormatoANumero(double numeroADarFormato) {
        BigDecimal numeroGranDecimal = new BigDecimal(numeroADarFormato);
        BigDecimal numeroGranDecimalRedondeado = numeroGranDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);

        String numeroGranDecimalComoString = numeroGranDecimalRedondeado.stripTrailingZeros().toPlainString();

        return numeroGranDecimalComoString;
    }
}
