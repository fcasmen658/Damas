package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;

public class Consola {

    private Consola () {

    }

    public static void mostrarMenu() {
        System.out.println("======== Damas ========");
        System.out.println("1. Crear Dama por defecto.");
        System.out.println("2. Crear Dama eligiendo el color.");
        System.out.println("3. Mover dama.");
        System.out.println("4. Mostrar dama.");
        System.out.println("5. Salir.");
    }

    public static Color elegirColor() {
        int colorSeleccionado;
        do {
            System.out.println("Menú de selección de color");
            System.out.println("1. Blanco");
            System.out.println("2. Negro");
            System.out.print("Elija una opción (1-2): ");
            colorSeleccionado = Entrada.entero();
        } while (colorSeleccionado < 1 || colorSeleccionado > 2);

        if (colorSeleccionado == 1) {
            return Color.BLANCO;
        } else {
            return Color.NEGRO;
        }
    }

    public static Direccion elegirDireccion() {
        int direccionSeleccionada;
        do {
            System.out.println("Menú de dirección");
            System.out.println("1. Noroeste");
            System.out.println("2. Noreste");
            System.out.println("3. Suroeste");
            System.out.println("4. Sureste");
            System.out.print("Elija una dirección (1-4): ");
            direccionSeleccionada = Entrada.entero();

        }while (direccionSeleccionada < 1 || direccionSeleccionada > 4);

        return switch (direccionSeleccionada) {
            case 1 -> Direccion.NOROESTE;
            case 2 -> Direccion.NORESTE;
            case 3 -> Direccion.SUROESTE;
            default -> Direccion.SURESTE;
        };
    }

    public static int elegirPasos() {
        int numPasos;
        do {
            System.out.print("Elija un número de pasos (1-100): ");
            numPasos = Entrada.entero();
        }while (numPasos < 1 || numPasos > 100);
        return numPasos;
    }

    public static boolean despedirse() {
        System.out.println("Gracias por jugar");
        return true;
    }
}
