import listaenlazada.ListaEnlazada;

public class App {
    public static void main(String[] args) {

        System.out.println("------------Ejemplo String------------");
        ListaEnlazada<String> lista = new ListaEnlazada<String>();
        lista.AgregarNodo("Luis");
        lista.AgregarNodo("Jessica");
        lista.AgregarNodo("Maradona");
        lista.AgregarNodo("Juan");
        lista.AgregarNodo("Alan");
        lista.AgregarNodo("Pele");
        lista.Transversa();
        System.out.println("");
        lista.OrdenarBurbuja();
        lista.Transversa();
        System.out.println("\n");

        System.out.println("------------Ejemplo Integer------------");
        ListaEnlazada<Integer> lst = new ListaEnlazada<Integer>();
        lst.AgregarNodo(10);
        lst.AgregarNodo(27);
        lst.AgregarNodo(1);
        lst.AgregarNodo(6);
        lst.AgregarNodo(4);
        lst.AgregarNodo(3);
        lst.Transversa();
        lst.OrdenarBurbuja();
        System.out.println("");
        lst.Transversa();

    }
}
