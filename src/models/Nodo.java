package models;

import java.util.Comparator;
import java.util.Objects;

public class Nodo<T> {
    private T dato;
    private Nodo siguiente;


    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo nodo) {
        this.siguiente = nodo;
    }
}
