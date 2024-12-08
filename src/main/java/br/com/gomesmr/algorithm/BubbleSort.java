package br.com.gomesmr.algorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] array = {5, 2, 9, 1, 5, 6};

        System.out.println("Array before sorting: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Array after sorting: " + Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("\nIteration " + (i + 1) + ": " + Arrays.toString(array));
            for (int j = 0; j < arrayLength - 1; j++){
                System.out.println("Comparing " + array[j] + " and " + array[j + 1]);
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                    System.out.println("\nSwaped: " + Arrays.toString(array) + "\n\n");
                }

            }
        }
    }
}
