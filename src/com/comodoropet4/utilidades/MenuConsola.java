package com.comodoropet4.utilidades;

public class MenuConsola {
    private String instrucciones;
    private String[] opciones;

    public MenuConsola(String instrucciones, String[] opciones) {
        this.instrucciones = instrucciones;
        this.opciones = opciones;
    }

    public void mostrarMenu() {
        System.out.printf("\n%s\n\n", instrucciones);

        for (int indiceOpcion = 0; indiceOpcion < opciones.length; indiceOpcion++) {
            System.out.println(opciones[indiceOpcion]);

            if (indiceOpcion == opciones.length - 2) {
                System.out.println("");
            }
        }

        System.out.println();
    }
}
