package listaenlazada;

import com.sun.istack.internal.NotNull;
import interfaces.IEstructureOperations;
import models.Nodo;

import java.util.Comparator;

public class ListaEnlazada<T> implements  IEstructureOperations<T>{
    private Nodo inicio;
    private int size = 0;

    public ListaEnlazada() {
        this.inicio = new Nodo();
        this.inicio.setSiguiente(null);
    }

    public ListaEnlazada(T dato) {
        this.inicio = new Nodo();
        this.inicio.setDato(dato);
        this.inicio.setSiguiente((null));
    }

    @Override
    public boolean IsVacia() {
        return this.inicio == null ? true : false;
    }

    @Override
    public void Transversa() {
        Nodo aux = new Nodo();
        aux = inicio;

        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
            System.out.print("[" + aux.getDato()+ "], ");
        }
    }

    @Override
    public void AgregarNodo(T dato) {
        Nodo aux = new Nodo();
        aux = inicio;
        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        Nodo temp = new Nodo();
        temp.setDato(dato);
        temp.setSiguiente(null);
        aux.setSiguiente(temp);
        this.size++;
    }

    @Override
    public T BuscarPorReferencia(int pos) throws NullPointerException{
        if(pos > this.size){
            throw new NullPointerException("Fuera del rango");
        }
        Nodo aux = new Nodo();
        int cont = 0;
        if(pos == 0){
            aux = inicio;
            aux = aux.getSiguiente();
            return (T)aux.getDato();
        }
        if(pos >= 1 && pos < this.size){
            aux = inicio;
            while(cont <= pos){
                aux = aux.getSiguiente();
                cont ++;
            }
            return (T)aux.getDato();
        }
        if(pos == this.size){
            aux = inicio;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            return (T)aux.getDato();
        }
        return null;
    }

    @Override
    public void EditarPorReferencia(int pos, T data) throws NullPointerException{
        if(pos > this.size){
            throw new NullPointerException("Fuera del rango");
        }
        Nodo aux = new Nodo();
        //Inicio de la lista
        if(pos == 0){
            aux = inicio;
            aux = aux.getSiguiente();
            aux.setDato(data);
            return;
        }
        if(pos >= 1 || pos <= size){
            aux = inicio;
            aux = aux.getSiguiente();
            int cont = 1;
            //posicionamos el
            while (cont <= pos ){
                aux = aux.getSiguiente();
                cont ++;
            }
            aux.setDato(data);
            return;
        }
        if(pos == size){
            aux = inicio;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setDato(data);
            return;
        }

        System.out.println("No existe la posición");
    }

    @Override
    public void EliminarPorReferencia(int pos)throws NullPointerException{
        if(pos > this.size){
            throw new NullPointerException("Fuera del rango");
        }
        Nodo aux = new Nodo();
        //Inicio de la lista
        if(pos == 0){
            aux = inicio;
            aux = aux.getSiguiente();
            inicio.setSiguiente(aux.getSiguiente());
            this.size--;
            return;
        }
        if(pos >= 1 && pos <= size){
            aux = inicio;
            int cont = 0;
            //posicionamos el Nodo
            Nodo temp = new Nodo();
            temp = inicio;
            while (cont <= pos ){
                if(cont <= (pos - 1)){
                    temp = temp.getSiguiente();
                }
                aux = aux.getSiguiente();
                cont ++;
            }
            temp.setSiguiente(aux.getSiguiente());
            this.size--;
            return;
        }
        if(pos == size){
            aux = inicio;
            Nodo temp = new Nodo();
            temp = inicio;
            int cont = 0;
            while(aux.getSiguiente() != null){
                if(cont >= (size - 1)){
                    //Referencia al nodo anterior
                    temp = temp.getSiguiente();
                }
                aux = aux.getSiguiente();
                cont ++;
            }
            temp.setSiguiente(null);
            this.size--;
            return;
        }

        System.out.println("No existe la posición");
    }

    @Override
    public int Size() {
        return this.size;
    }

    @Override
    public void OrdenarBurbuja() {
        Nodo aux = new Nodo();
        aux = inicio;

        while (aux.getSiguiente() != null){
            Nodo temp = aux;
            aux = aux.getSiguiente();

            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();
                if(Compare((T)aux.getDato(), (T)temp.getDato())){
                    T aux2 = (T) aux.getDato();
                    aux.setDato(temp.getDato());
                    temp.setDato(aux2);
                }
            }
        }
    }

    //Método para saber el tipo de dato
    public void PrintType(){
        Nodo aux = this.inicio;
        aux = aux.getSiguiente();
        System.out.println(aux.getDato().getClass().getName());
    }

    public boolean Compare(@NotNull T data, @NotNull T data2){
        //Ordenar strings de acuerdo a la primera letra de la cadena
        if(data.getClass().getName() == "java.lang.String"){
            String d1 = (String)data;
            String d2 = (String)data2;
            return d1.charAt(0) > d2.charAt(0);
        }

        if(data.getClass().getName() == "java.lang.Integer"){
            return  (Integer)data > (Integer) data2;
        }
        if(data.getClass().getName() == "java.lang.Double"){
            return  (Double)data > (Double) data2;
        }
        if(data.getClass().getName() == "java.lang.Float"){
            return  (Float)data > (Float) data2;
        }
        if(data.getClass().getName() == "java.lang.Long"){
            return  (Long)data > (Long) data2;
        }
        return false;
    }
}
