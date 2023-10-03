import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Matrix {
    private double[][] matrix;
    //Constructors
    public Matrix() {
        matrix = new double[2][2];
    }
    public Matrix(double a, double b, double c, double d) {
        matrix = new double[][]{{a, b}, {c, d}};
    }
    //Methods
    public void setElement(int row, int col, double value) {
        matrix[row][col] = value;
    }
    public double determinant(){
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
    public Matrix inverse() {
        double d = determinant();
        if (d == 0) {
            System.out.print("Can`t build inverse matrix");
        }
        double invdet = 1/d;
        return new Matrix(matrix[1][1] * invdet, -matrix[0][1] * invdet, -matrix[1][0] * invdet, matrix[0][0] * invdet);
    }
    public Matrix multiplyMatrix(Matrix other){
        double[][] res = new double[2][2];
        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                res[i][j] = 0;
                for (int k = 0; k < 2; k++){
                    res[i][j] += matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(res[0][0], res[0][1], res[1][0], res[1][1]);
    }
    public Matrix add(Matrix other){
        double[][] res = new double[2][2];
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(res[0][0], res[0][1], res[1][0], res[1][1]);
    }
    public Matrix multiplyNumber(double n){
        double[][] res = new double[2][2];
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = matrix[i][j] * n;
            }
        }
        return new Matrix(res[0][0], res[0][1], res[1][0], res[1][1]);
    }
    public void print(){
        DecimalFormat df = new DecimalFormat("#.##");
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(df.format(matrix[i][j]) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the elements of the Matrix 1: ");
        Matrix matrix1 = new Matrix();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                System.out.print("Enter the [" + i + "]: ");
                double value1 = in.nextDouble();
                matrix1.setElement(i, j, value1);
            }
        }
        System.out.println("Matrix 1:");
        matrix1.print();
        System.out.println("Enter the elements of the Matrix 2: ");
        Matrix matrix2 = new Matrix();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                System.out.print("Enter the [" + i + "]: ");
                double value2 = in.nextDouble();
                matrix2.setElement(i, j, value2);
            }
        }
        System.out.println("Matrix 2:");
        System.out.println(matrix2);

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
}
