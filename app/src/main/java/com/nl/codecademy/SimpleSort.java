package com.nl.codecademy;

import java.util.Arrays;

public class SimpleSort {

    public static void main(String[] args) {

        int[] array = {7, 2, 5, 8, -3};
        mainAsc(array);

        //int[] array2 = {7, 2, 5, 8, -3};
        //mainDesc(array2);
    }

    public static void mainAsc(int[] arr) {

        System.out.println("Array " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1; j++) {

                if(arr[j] > arr[j+1]) {

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("Asc Array " + Arrays.toString(arr));
    }

    public static void mainDesc(int[] arr) {

        System.out.println("Array " + Arrays.toString(arr));



        System.out.println("Desc Array " + Arrays.toString(arr));
    }
}
