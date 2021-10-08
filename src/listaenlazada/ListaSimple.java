package listaenlazada;

import com.sun.istack.internal.NotNull;
import interfaces.IStructureOperations;
import models.Nodo;

import java.util.Comparator;

public class ListaSimple<T> implements  IStructureOperations<T>{
    private Nodo inicio;
    private int size = 0;

    public ListaSimple() {
        this.inicio = new Nodo();
        this.inicio.setSiguiente(null);
    }

    public ListaSimple(T dato) {
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
            System.out.print(aux.getDato() + " ");
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
            return (T)aux;
        }
        if(pos >= 1 && pos < this.size){
            aux = inicio;
            while(cont <= pos){
                aux = aux.getSiguiente();
                cont ++;
            }
            return (T)aux;
        }
        if(pos == this.size){
            aux = inicio;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            return (T)aux;
        }
        return null;
    }

    @Override
    public boolean EditarPorReferencia(int pos, T data) throws NullPointerException{
        if(pos > this.size){
            throw new NullPointerException("Fuera del rango");
        }
        Nodo aux = new Nodo();
        //Inicio de la lista
        if(pos == 0){
            aux = inicio;
            aux = aux.getSiguiente();
            aux.setDato(data);
            return true;
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
            return true;
        }
        if(pos == size){
            aux = inicio;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setDato(data);
            return true;
        }

        return false;
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
            //posicionamos el Nodo
            aux = (Nodo)this.BuscarPorReferencia(pos);
            Nodo temp = (Nodo) this.BuscarPorReferencia(pos - 1);
            temp.setSiguiente(aux.getSiguiente());
            this.size--;
            return;
        }
        if(pos == size){
            aux = (Nodo)this.BuscarPorReferencia(pos - 1);
            aux.setSiguiente(null);
            this.size--;
            return;
        }

        System.out.println("No existe la posición");
    }
    public boolean ElminarPalabra(String palabra){
        if(this.size == 0){
            System.out.println("Lista Vacía");
            return false;
        }
        Nodo aux = inicio;
        Nodo temp = inicio;
        int actual = 0;
        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
            if(aux.getDato().equals(palabra)){
                temp = (Nodo)this.BuscarPorReferencia(actual == 0 ? actual : actual - 1);//Obtenemos el nodo anterior
                //En caso de que la palabra esté al principio de la lista
                if(actual == 0){
                    inicio.setSiguiente(aux.getSiguiente());
                    return true;
                }
                //Eliminamos la referencia al nodo auxiliar
                temp.setSiguiente(aux.getSiguiente());
                System.out.println(aux.getDato());
                return true;
            }
            actual ++;
        }
       return false;
    }

    public T BinarySearch(int pos, String dataToFind){
        this.OrdenarBurbuja();
        int low = 0;
        int high = this.size - 1;
        int middle = (low + high) / 2;
        while (low <= high){
            Nodo guess = (Nodo)this.BuscarPorReferencia(middle);
            if((String)guess.getDato() == dataToFind){
                return (T)guess;
            }
            if(GetSizeBytesWord((String)guess.getDato()) > GetSizeBytesWord(dataToFind)){
                high = middle - 1;
            }else{
                low = middle + 1;
            }
        }
        return null;
    }

    public int GetSizeBytesWord(String word){
        int sum = 0;
        for(int i = 0; i < word.length(); i++){
            sum += word.charAt(i);
        }
        return sum;
    }

    public boolean AgregarPorReferencia(int pos, String palabra) {
        if(this.size == 0){
            System.out.println("Lista Vacía");
            return false;
        }
        Nodo aux = inicio;
        if (pos == 0) {
            aux = (Nodo) this.BuscarPorReferencia(pos);
            Nodo new_nodo = new Nodo();
            new_nodo.setSiguiente(aux);
            new_nodo.setDato(palabra);
            inicio.setSiguiente(new_nodo);
            return true;
        }

        if(pos > 0 && pos < this.size){
            Nodo temp = (Nodo)this.BuscarPorReferencia(pos - 1);
            aux = (Nodo) this.BuscarPorReferencia(pos);
            Nodo new_nodo = new Nodo();
            new_nodo.setDato(palabra);
            new_nodo.setSiguiente(aux);
            temp.setSiguiente(new_nodo);
            return true;
        }

        if (pos == this.size) {
            Nodo new_nodo = new Nodo();
            new_nodo.setSiguiente(null);
            new_nodo.setDato(palabra);
            Nodo temp = (Nodo) this.BuscarPorReferencia(pos);
            temp.setSiguiente(new_nodo);
            return true;
        }
        return  false;
    }
    public void EliminarTexto(){
        this.inicio.setSiguiente(null);
    }

    public int ContarPalabraEnTexto(String palabra){
        Nodo aux = inicio;
        int cont = 0;
        while (aux.getSiguiente() != null){
            aux = aux.getSiguiente();
            if(aux.getDato().equals(palabra)){
                cont ++;
            }
        }
        return cont;
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
