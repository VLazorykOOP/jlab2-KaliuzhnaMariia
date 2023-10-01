import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class QuickSort {
    //Function for generating random array
    private static int[] generateRandom(int n){
        int[] arr = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++){
            arr[i] = rnd.nextInt(101);
        }
        return arr;
    }
    //Function for Quick Sorting
    private static void quickSort(int[] arr, int begin, int end){
        if(begin < end){
            int pivot = partition(arr, begin, end);
            quickSort(arr, begin, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }
    private static int partition(int[] arr, int begin, int end){
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the n: ");
        int n = in.nextInt();
        int[] arr = generateRandom(n);
        System.out.println("Original array: " + Arrays.toString(arr));
        quickSort(arr, 0, n-1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
