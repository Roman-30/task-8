package ru.vsu.cs;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] arr = readFile();
        int[][] matrix = setMatrix(arr);

        System.out.println("Initial view");
        printMatrixAndSum(matrix);
        sortTheMatrixLines(matrix, arr);
        System.out.println("Sorted view");
        printMatrixAndSum(matrix);
        writeFile(matrix);
    }

    public static int[][] setMatrix(int[] arr) {
        int numbers = 2;
        int[][] matrix = new int[arr[0]][arr[1]];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = arr[numbers];
                numbers++;
            }
        }
        System.out.println();
        return matrix;
    }

    public static void sortTheMatrixLines(int[][] matrix, int [] arr) {
        for (int i = 0; i < matrix.length - 1; ) {
            int sum1 = 0;
            int sum2 = 0;
            for (int k = 0; k < arr[1]; k++) {
                sum1 += matrix[i][k];
                sum2 += matrix[i + 1][k];
            }
            if (sum1 < sum2) {
                int[] cell = matrix[i + 1];
                matrix[i + 1] = matrix[i];
                matrix[i] = cell;
                if (i != 0) i--;
            } else i++;
        }
    }

    public static void printMatrixAndSum(int[][] matrix) {
        for (int[] lines : matrix) {
            int sum = 0;
            System.out.print(Arrays.toString(lines));
            for (int elements : lines) {
                sum += elements;
            }
            System.out.printf(" sum --> %d \n", sum);
        }
        System.out.println();
    }

    public static int[] readFile() throws Exception {
        FileReader reader = new FileReader(readSomething("Enter file name: "));
        Scanner scanner = new Scanner(reader);
        String numbers = scanner.nextLine();
        reader.close();
        return ArrayUtils.toIntArray(numbers);
    }

    public static void writeFile(int[][] matrix) throws Exception {
        FileWriter writer = new FileWriter("answer.txt");
        for (int[] lines : matrix) {
            writer.write("[");
            for (int elements : lines) {
                writer.write(elements + " ");
            }
            writer.write("]\n");  // filewriter.write(Arrays.deepToString(matrix));
        }
        writer.close();
    }

    public static String readSomething(String name) {
        Scanner scn = new Scanner(System.in);
        System.out.print(name);
        return scn.nextLine();
    }
}
