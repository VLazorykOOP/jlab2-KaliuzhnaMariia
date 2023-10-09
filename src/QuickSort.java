import java.util.Arrays;
import java.util.Random;
public class QuickSort {
    private int[] array;
    private int[] sortedArray;

    //Constructor
    public QuickSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        this.sortedArray = Arrays.copyOf(this.array, this.array.length);
        quickSort(0, this.sortedArray.length - 1);
        return this.sortedArray;
    }
    //Methods
    private void quickSort(int begin, int end){
        if (begin < end) {
            int pivot = partition(begin, end);
            quickSort(begin, pivot-1);
            quickSort(pivot+1, end);
        }
    }
    private int partition(int begin, int end){
        int pivot = this.sortedArray[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++){
            if(this.sortedArray[j] < pivot){
                i++;
                int temp = this.sortedArray[i];
                this.sortedArray[i] = this.sortedArray[j];
                this.sortedArray[j] = temp;
            }
        }
        int temp = this.sortedArray[i + 1];
        this.sortedArray[i + 1] = this.sortedArray[end];
        this.sortedArray[end] = temp;
        return i + 1;
    }

    public static int[] generateRandom(int n){
        int[] arr = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++){
            arr[i] = rnd.nextInt(101);
        }
        return arr;
    }
}
