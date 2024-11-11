package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class MainApp {

    static Dama dama;
    static boolean salir = false;

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearDama();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                mostrarDama();
                break;
            case 5:
                despedirse();
                break;
        }
    }

    private static void crearDama() {
        dama = new Dama();
    }

    private static void crearDamaColor() {
        try{
            dama = new Dama(Consola.elegirColor());
            } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mover() {
        try {
            //int numPasos;
            if (dama.esDamaEspecial()) {
                System.out.println("Ahora es dama especial.");
                System.out.println("¿Cuantos pasos quieres mover?");
                //numPasos = Entrada.entero();
                dama.mover(Consola.elegirDireccion(),Consola.elegirPasos());
            }else dama.mover(Consola.elegirDireccion(),Consola.elegirPasos());
            } catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
                System.out.println(e.getMessage());
        }
    }

    private static void mostrarDama() {
        System.out.println(dama);
    }

    private static void despedirse() {
        salir = Consola.despedirse();
    }

    public static void main(String[] args) {
        while (!salir) {
            Consola.mostrarMenu();
            int opcion = Entrada.entero();
            ejecutarOpcion(opcion);
        }
    }
}
