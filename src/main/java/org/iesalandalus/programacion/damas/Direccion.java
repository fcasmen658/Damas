package org.iesalandalus.programacion.damas;

public enum Direccion {
    NORESTE("Noreste"), SURESTE("Sureste"), SUROESTE("Suroeste"), NOROESTE("Noroeste");

    private String cadenaAMostrar;
    private Direccion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return "Direccion {" + "cadenaAMostrar='" + cadenaAMostrar + '\'' + '}';
    }
}
