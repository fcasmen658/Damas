package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {

    private int fila;
    private char columna;


    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    public Posicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
        }
        setFila(posicion.getFila());
        setColumna(posicion.getColumna());
    }

    private void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
        this.fila = fila;
    }

    public int getFila() {
        return this.fila;
    }

    private void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
        this.columna = columna;
    }

    public char getColumna() {
        return this.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFila(), getColumna());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicion posicion)) return false;
        return getFila() == posicion.getFila() && getColumna() == posicion.getColumna();
    }

    @Override
    public String toString() {
        return "fila=" + this.fila + ", columna=" + this.columna;
    }
}