import listaenlazada.ListaLigada;

import java.util.Scanner;

public class ListOperations {
    private Scanner reader = new Scanner(System.in);
    private ListaLigada<String> listaSimple = new ListaLigada<>();

    public void InsertWord(){
        String enterKey = "";
        System.out.println("Teclee las palabras que quiera agregear a la lista, presione enter para continuar....");
        enterKey = reader.nextLine();

        //Seperamos las palabras
        String[] entered_words_array = enterKey.split(" ");

        for(String entered_word: entered_words_array){
            listaSimple.AddNode((String) entered_word);;
        }
        System.out.println("Las palabras han sido agregada con éxito!");
    }

    public void ShowWords(){
        listaSimple.Transversa();
        System.out.println("\n");
    }

    public void DeleteWord(){
        String wordToDelete;
        System.out.println("Ingrese la palabra a eliminar: ");
        wordToDelete = reader.nextLine();
        if(wordToDelete.isEmpty()){
            System.out.println("No se ingresó una palabra, regresando al menú.");
        }

        if(!listaSimple.DeleteWord(wordToDelete)){
            System.out.println("La palabra no se encontraba en la lista!!");
            return;
        }
        System.out.println("La palabra Fue elminada!!!");
    }

    public void InsertWordByReference(){
        int pos;
        String wordToInsert;

        System.out.println("Ingrese la palabra: ");
        wordToInsert = reader.nextLine();

        System.out.println("\nInserte la posición: ");
        pos = reader.nextInt();
        String[] words_array_split = wordToInsert.split(" ");
        System.out.println(words_array_split.length);
        int aux = 0;

        if(pos == 0){
            for(int i = words_array_split.length - 1; i >=  pos; i--){
                if(!listaSimple.AddWordByReference(pos, words_array_split[i])){
                    System.out.println("La posicion no se encontraba en la lista!!");
                    return;
                }
            }
            System.out.println("La palabra o las palabras Fueron agregadas!!!");
            return;
        }


        for(int i = pos; i < words_array_split.length + pos; i++){
            if(!listaSimple.AddWordByReference(pos, words_array_split[aux])){
                System.out.println("La posicion no se encontraba en la lista!!");
                return;
            }
            aux++;
        }

        System.out.println("La palabra o las palabras Fueron agregadas!!!");

    }
    public void DeleteText(){
        listaSimple.DeleteText();
        System.out.println("Texto Eliminado");
    }

    public void CountWordInText(){
        String wordToCount;
        System.out.println("Escriba la palbra a contar en el texto: ");
        wordToCount = reader.nextLine();
        int timesWordInText = listaSimple.CountWordInText(wordToCount);

        if(timesWordInText == 0){
            System.out.println("La palabra no se encontraba en el texto!!!");
            return;
        }
        System.out.println("La palabra [" + wordToCount + "] se encontraba [" + timesWordInText + "] veces en el texto!!");
    }
}
