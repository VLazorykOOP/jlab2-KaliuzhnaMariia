import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Matrix {
    private double[][] matrix;

    //Constructors
    public Matrix() {
        matrix = new double[2][2];
    }

    public Matrix(double[][] arr) {
        matrix = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }

    //Methods
    public double determinant() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public Matrix inverse() {
        double d = determinant();
        if (d == 0) {
            System.out.println("Can't build an inverse matrix");
        }
        double invdet = 1 / d;
        double[][] res = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = matrix[(j + 1) % 2][(i + 1) % 2] * invdet;
                if ((i + j) % 2 == 1) {
                    res[i][j] *= -1;
                }
            }
        }
        return new Matrix(res);
    }

    public Matrix multiplyMatrix(Matrix other) {
        double[][] res = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    res[i][j] += matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(res);
    }

    public Matrix add(Matrix other) {
        double[][] res = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(res);
    }

    public Matrix multiplyNumber(double n) {
        double[][] res = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = matrix[i][j] * n;
            }
        }
        return new Matrix(res);
    }

    public void print() {
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < 2; i++) {
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
}