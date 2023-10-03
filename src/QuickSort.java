import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class QuickSort {
    private int[] array;
    //Constructor
    public QuickSort(int[] array) {
        this.array = array;
    }
    public static int[] generateRandom(int n){
        int[] arr = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++){
            arr[i] = rnd.nextInt(101);
        }
        return arr;
    }
    //Methods
    public static void quickSort(int[] arr, int begin, int end){
        if (begin < end) {
            int pivot = partition(arr, begin, end);
            quickSort(arr, begin, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }
    public static int partition(int[] arr, int begin, int end){
        int pivot = arr[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }
}
