import java.util.Scanner;

public class MatrixMultiplication {

    public static void inputMatrix(int[][] matrix, String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements of matrix " + name + " (4x4):");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix, String name) {
        System.out.println("Matrix " + name + ":");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean areMatricesEqual(int[][] A, int[][] B) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] A = new int[4][4];
        int[][] B = new int[4][4];

        inputMatrix(A, "A");
        inputMatrix(B, "B");

        int[][] AB = multiplyMatrices(A, B);
        int[][] BA = multiplyMatrices(B, A);

        printMatrix(AB, "AB");
        printMatrix(BA, "BA");

        if (areMatricesEqual(AB, BA)) {
            System.out.println("Matrix AB is equal to Matrix BA.");
        } else {
            System.out.println("Matrix AB is not equal to Matrix BA.");
        }
    }
}
