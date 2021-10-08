import listaenlazada.ListaSimple;

import java.awt.*;
import java.util.Scanner;

public class App {
    private static Scanner reader = new Scanner(System.in);
    private static ListOperations listOperations = new ListOperations();

    public static void main(String[] args) {
        System.out.println("------------Ejemplo Char------------");
        int option = 0;
        do{
            option = Menu();
            switch (option){
                case 1:
                    listOperations.InsertWord();
                    break;
                case 2:
                    listOperations.DeleteWord();
                    break;
                case 3:
                    listOperations.InsertWordByReference();
                    break;
                case 4:
                    listOperations.DeleteText();
                    break;
                case 5:
                    listOperations.ShowWords();
                    break;
                case 6:
                    listOperations.CountWordInText();
                    break;
                default:
                    break;
            }
        }while(option != 7);
    }

    public static int Menu(){
        int resp;

        System.out.println("------------Menú------------");
        System.out.println("1.-Crear Palabra");
        System.out.println("2.-Eliminar Palabra");
        System.out.println("3.-Insertar Palabra por Referencia");
        System.out.println("4.-Elminar Todo el Texto");
        System.out.println("5.-Mostrar Texto");
        System.out.println("6.- Contar Palabra en la lista");
        System.out.println("7.-Salir");
        System.out.println("----------------------------\n");
        try{
            resp = reader.nextInt();
            return resp;
        }catch(Exception ex){
            System.out.println("No se insertó un número!!!");
        }
        return -1;
    }
}
