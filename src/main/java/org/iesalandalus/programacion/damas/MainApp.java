package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.damas.Direccion;
//import org.iesalandalus.programacion.damas.modelo.Color;
//import org.iesalandalus.programacion.damas.modelo.Direccion;
//import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {

    public static void main(String[] args) {
        //Dirección
        Direccion direccion = Direccion.NORESTE;
        System.out.println(direccion);

        //Color
        Color color = Color.BLANCO;
        System.out.println(color);
    }
}
