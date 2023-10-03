import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Java Lab 2 ");
        System.out.println("Enter the number of task (1 - Data; 2 - Matrix; 3 - Quick Sort): ");
        int choice = in.nextInt();
        switch (choice){
            case 1: {
                Date();
                break;
            }
            case 2:{
                Matrix();
                break;
            }
            case 3:{
                QuickSort();
                break;
            }
            default:{
                System.out.println("No such task. Please choose from 1 to 3!");
            }
        }
    }
    public static void Date(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first data (year.month.day): ");
        String inputDate1 = in.nextLine();
        Date date1 = new Date(inputDate1);
        System.out.print("Enter the second data (year.month.day): ");
        String inputDate2 = in.nextLine();
        Date date2 = new Date(inputDate2);

        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);

        System.out.println("Is Date 1 before Date 2: " + date1.isBefore(date1, date2));
        System.out.println("Is Date 1 after Date 2: " + date1.isAfter(date1, date2));
        System.out.println("Is Date 1 equal to Date 2: " + date1.isEqual(date1, date2));

        System.out.println("Enter the number of days: ");
        int d = in.nextInt();
        Date addate1 = date1.addDays(d);
        Date addate2 = date2.addDays(d);
        System.out.println("Date 1 after adding: " + addate1);
        System.out.println("Date 2 after adding: " + addate2);
        Date mindate1 = date1.minusDays(d);
        Date mindate2 = date2.minusDays(d);
        System.out.println("Date 1 after minus: " + mindate1);
        System.out.println("Date 2 after minus: " + mindate2);

        System.out.println("Is year of Date 1 leap: " + date1.isLeap(date1));
        System.out.println("Is year of Date 2 leap: " + date2.isLeap(date2));

        int db = date1.daysBetween(date1, date2);
        System.out.println("Amount of days between Date 1 and Date 2: " + db);
    }
    public static void Matrix(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the elements of the Matrix 1: ");
        double[][] matrix1d = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("A["+ i + "][" + j + "] = ");
                matrix1d[i][j] = in.nextDouble();
            }
        }
        Matrix matrix1 = new Matrix(matrix1d);
        System.out.println("Matrix 1:");
        System.out.println(matrix1);
        matrix1.print();

        System.out.println("Enter the elements of the Matrix 2: ");
        double[][] matrix2d = new double[2][2];
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                System.out.print("A["+ i + "][" + j + "] = ");
                matrix2d[i][j] = in.nextDouble();
            }
        }
        Matrix matrix2 = new Matrix(matrix2d);
        System.out.println("Matrix 2:");
        System.out.println(matrix2d);
        matrix2.print();

        System.out.println("Determinant of the Matrix 1: " + matrix1.determinant());
        System.out.println("Determinant of the Matrix 2: " + matrix2.determinant());

        System.out.println("Inverse of Matrix1:");
        matrix1.inverse().print();

        System.out.println("Matrix1 + Matrix2:");
        matrix1.add(matrix2).print();

        System.out.println("Matrix1 * Matrix2:");
        matrix1.multiplyMatrix(matrix2).print();

        System.out.println("Matrix * number: ");
        System.out.print("Enter the number: ");
        double n = in.nextDouble();
        matrix1.multiplyNumber(n).print();
    }
    public static void QuickSort(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the n: ");
        int n = in.nextInt();
        int[] arr = QuickSort.generateRandom(n);
        System.out.println("Original array: " + Arrays.toString(arr));
        QuickSort quickSort = new QuickSort(arr);
        QuickSort.quickSort(arr, 0, n-1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
