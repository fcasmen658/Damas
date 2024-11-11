package org.iesalandalus.programacion.damas.modelo;

public enum Direccion {

    NOROESTE("Noroeste"),
    NORESTE("Noreste"),
    SUROESTE("Suroeste"),
    SURESTE("Sureste");

    private final String cadenaAMostrar;

    Direccion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}