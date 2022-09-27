package com.nl.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] nums = {5, 9, 2, 4, 1, 3, 6, 7, 8};

        InsertionSort(nums);

        System.out.println("Arr = " + Arrays.toString(nums));
    }

    public static void InsertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }
}
