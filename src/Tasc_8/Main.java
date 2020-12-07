package Tasc_8;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = readSomething("Enter the number of lines: ");
        int b = readSomething("Enter the number of line elements: ");
        int[][] matrix = setMatrix(a, b);

        System.out.println("Initial view");
        printMatrixAndSum(matrix);
        sortTheMatrixLines(matrix, b);
        System.out.println("Sorted view");
        printMatrixAndSum(matrix);
    }

    public static int[][] setMatrix(int a, int b) {
        int line = 0;
        int[][] matrix = new int[a][b];
        for (int i = 0; i < matrix.length; i++) {
            int element = 0;
            line++;
            for (int j = 0; j < b; j++) {
                element++;
                matrix[i][j] = readSomething("[" + line + "] line [" + element + "] Element: ");
            }
        }
        System.out.println();
        return matrix;
    }

    public static void sortTheMatrixLines(int[][] matrix, int b) {
        for (int i = 0; i < matrix.length - 1; ) {
            int sum1 = 0;
            int sum2 = 0;
            for (int k = 0; k < b; k++) {
                sum1 += matrix[i][k];
                sum2 += matrix[i + 1][k];
            }
            if (sum1 < sum2) {
                int[] temp = matrix[i + 1];
                matrix[i + 1] = matrix[i];
                matrix[i] = temp;
                if (i != 0) i--;
            }
            i++;
        }
    }

    public static void printMatrixAndSum(int[][] matrix) {
        for (int[] value : matrix) {
            int sum = 0;
            System.out.print(Arrays.toString(value));
            for (int i : value) {
                sum += i;
            }
            System.out.printf(" sum --> %d \n", sum);
        }
        System.out.println();
    }

    public static int readSomething(String name) {
        Scanner scn = new Scanner(System.in);
        System.out.print(name);
        return scn.nextInt();
    }
}
