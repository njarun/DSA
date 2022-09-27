package com.nl.codecademy;

import java.util.Arrays;

public class InsertionSorts {

    public static void main(String[] args) {

        int[] array = {7, 2, 5, 8, -3};
        mainAsc(array);

        int[] array2 = {7, 2, 5, 8, -3};
        mainDesc(array2);
    }

    public static void mainAsc(int[] arr) {

        System.out.println("Array " + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            for (; j >= 0 && key < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = key;
        }

        System.out.println("Asc Array " + Arrays.toString(arr));
    }

    public static void mainDesc(int[] arr) {

        System.out.println("Array " + Arrays.toString(arr));

        for (int i = arr.length - 2; i >= 0; i--) {

            int key = arr[i];
            int j = i + 1;

            for (; j < arr.length && key < arr[j]; j++) {
                arr[j - 1] = arr[j];
            }

            arr[j - 1] = key;
        }

        System.out.println("Desc Array " + Arrays.toString(arr));
    }
}
