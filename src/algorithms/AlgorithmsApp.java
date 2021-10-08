package algorithms;

public class AlgorithmsApp {
    public static void main(String[] args) {
        int[] array = {4,1,5,2,7,3,793,3,1,6,3,7,8,3,10,4,23,123,5,43,523,45,72,4,64,2,35,7,3,4,76,56,8,78,312};
        Algorithms algorithms = new Algorithms();
        //array = algorithms.SelectionSort(array);
        array = algorithms.QuickSort(array, 0, (array.length-1));

        for(int number: array){
            System.out.print("["+ number +"], ");
        }
        int numberIndex = algorithms.BinarySearch(array, 78);
        System.out.println("\nnumberIndex = " + numberIndex);

        System.out.println(algorithms.Euclidean(1680, 640));
        System.out.println(algorithms.RecursiveEuclidean(1680, 640));
    }
}
