package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;

public class Dama {

    //atributos
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    //Constructor por defecto
    public Dama() {
        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial(color);
        this.esDamaEspecial = false;
    }

    public Dama(Color color) {
        if (color == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        this.color = color;
        this.posicion = crearPosicionInicial(color);
        this.esDamaEspecial = false;
    }

    //getters y setters
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("ERROR: La posición no puede ser nula.");
        }
        this.posicion = posicion;
    }

    public boolean getEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) throws OperationNotSupportedException {
        if (this.esDamaEspecial != esDamaEspecial) {
            throw new OperationNotSupportedException("ERROR: ");
        }
    }

    //Dama especial
    public boolean esDamaEspecial() {
        //comprobamos que la dama blanca es especial
        if (getPosicion().getFila()==8 && color == Color.BLANCO && !this.esDamaEspecial)
        {
            this.esDamaEspecial=true;
        }
        //comprobamos que la dama negra es especial
        if (getPosicion().getFila()==1 && color == Color.NEGRO && !this.esDamaEspecial) {
            this.esDamaEspecial=true;
        }
        return esDamaEspecial;
    }

    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        if (pasos < 1) {
            throw new IllegalArgumentException("ERROR: El número de pasos no puede ser menor que 1.");
        }
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        if (getColor() == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        if (!esDamaEspecial) {
            if (((pasos != 1) && (getColor()==Color.BLANCO)) && (direccion == Direccion.NORESTE || direccion == Direccion.NOROESTE)
                    ||
                    ((pasos != 1) && (getColor()==Color.NEGRO)) && (direccion == Direccion.SURESTE || direccion == Direccion.SUROESTE)) {
                throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");
            }  // movimiento permitido
        }

        // Calcular la nueva posición
        int nuevaFila = this.posicion.getFila();
        char nuevaColumna = this.posicion.getColumna();

        switch (direccion) {
            case NORESTE:
                nuevaFila += pasos;
                nuevaColumna += (char) pasos;
                break;
            case SURESTE:
                nuevaFila -= pasos;
                nuevaColumna += (char) pasos;
                break;
            case SUROESTE:
                nuevaFila -= pasos;
                nuevaColumna -= (char) pasos;
                break;
            case NOROESTE:
                nuevaFila += pasos;
                nuevaColumna -= (char) pasos;
                break;
            }

        // Actualizar la posición de la dama
        try
        {
        posicion = new Posicion(nuevaFila, nuevaColumna);
        }
        catch(IllegalArgumentException e)
        {
            throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
        }
    }

    //Posición inicial aleatoria
    private Posicion crearPosicionInicial (Color color){
        int fila;
        char columna;

        if (color == Color.BLANCO) {
            fila = (int) (Math.random() * 3) + 1; // Filas 1, 2 y 3 para las blancas
        } else {
            fila = (int) (Math.random() * 3) + 6; // Filas 6, 7 y 8 para las negras
        }

        do {
            columna = (char) ('a' + (int) (Math.random() * 8)); // Columna aleatoria entre 'a' y 'h'
        } while ((fila + (columna - 'a')) % 2 == 0); // Nos aseguramos que sea una casilla negra ('a' 'c' 'e' 'g' son las columnas negras para las blancas)

        return new Posicion(fila, columna);
    }

    @Override
    public String toString() {
        return "color=" + color + ", posicion=(" + posicion + ")";
    }
}
