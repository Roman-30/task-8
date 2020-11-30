package Tasc_8;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[][] arr = new int[5][5];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = rnd.nextInt(10);
            }
        }
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        for (int j = 0; j < arr.length; j++) {
            int sum = 0;
            int sum1 = 0;
            for (int[] ints : arr) {
                sum += ints[j];
                sum1 += ints[j + 1];
                System.out.println(sum + " " + sum1);
            }
        }
    }
}
