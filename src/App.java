import listaenlazada.ListaEnlazada;

public class App {
    public static void main(String[] args) {

        ListaEnlazada<String> lista = new ListaEnlazada<String>();
        lista.AgregarNodo("Luis");
        lista.AgregarNodo("Jessica");
        lista.AgregarNodo("Maradona");
        lista.AgregarNodo("Juan");
        lista.AgregarNodo("Alab");
        lista.AgregarNodo("Pele");
        lista.Transversa();
        System.out.println("");
        lista.OrdenarBurbuja();
        lista.Transversa();
        System.out.println("");
        System.out.println(lista.BuscarPorReferencia(1));
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
