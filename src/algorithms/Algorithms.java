package algorithms;

public class Algorithms {

    ///summay
    //Retunrs index of desired number if exists within the array, else, return -1, since -1
    //is not a valid index
    public int BinarySearch(int[] array, int numberToFind){
        int guess = 0;
        int low = 0;
        int high = array.length - 1;
        int middle = 0;
        while(low <= high){
            middle = (low + high);
            guess = array[middle];

            if(guess == numberToFind){
                return middle;
            }
            if(guess > numberToFind){
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public int[] SelectionSort(int[]array){
        int min = 0;

        for (int i = 0; i < array.length; i ++){
            min = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            int aux = array[i];
            array[i] = array[min];
            array[min] = aux;
        }
        return  array;
    }

    public int[] QuickSort(int[] array, int low, int high){
        int middle = (low + high) / 2;
        int pivot = array[middle];
        int indexLeft = low;
        int indexRight = high;
        do{
            while(array[indexLeft] < pivot) indexLeft++;
            while(array[indexRight] > pivot) indexRight--;

            if(indexLeft <= indexRight){
                int aux = array[indexLeft];
                array[indexLeft] = array[indexRight];
                array[indexRight] = aux;
                indexLeft ++;
                indexRight --;
            }

        }while(indexLeft <= indexRight );

        if(low < indexRight){
            QuickSort(array, low, indexRight);
        }
        if(indexLeft < high){
            QuickSort(array, indexLeft, high);
        }

        return  array;
    }

    public int Euclidean(int a, int b){
        int maximumCommonDivisor = 0;
        int residue = 0;
        do{
            residue = a % b;
            if(residue == 0){
                maximumCommonDivisor = b;
                break;
            }
            if(residue != 0){
                a = b;
                b = residue;
            }
        }while(residue != 0);

        return maximumCommonDivisor;
    }

    public int RecursiveEuclidean(int a, int b){
       return b == 0 ?  a :  RecursiveEuclidean(b, a % b);
    }
}
