package listaenlazada;

import models.Nodo;

public class ListaLigada <T> {
    private Nodo inicio;
    private int size = 0;

    public ListaLigada() {
        this.inicio = new Nodo();
        this.inicio.setSiguiente(null);
    }

    public void AddNode(T dato) {
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

    public boolean DeleteWord(String palabra){
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
    public boolean AddWordByReference(int pos, String palabra) {
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
    public void DeleteText(){
        this.inicio.setSiguiente(null);
    }

    public int CountWordInText(String palabra){
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

    public void Transversa() {
        Nodo aux = new Nodo();
        aux = inicio;

        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
            System.out.print(aux.getDato() + " ");
        }
    }

}
