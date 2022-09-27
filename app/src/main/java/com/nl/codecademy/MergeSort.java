package com.nl.codecademy;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = {7, 2, 5, 8, -3};
        mainAsc(array);
    }

    public static void mainAsc(int[] arr) {

        System.out.println("Array " + Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        System.out.println("Asc Array " + Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {

        if(l < r) {

            int m = l + (r-l)/2;

            sort(arr, l, m);
            sort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[m + 1 + i];
        }

        int i=0, j=0;
        int k = l;

        while(i<n1 && j<n2) {

            if(arr1[i]  <= arr2[j]) {

                arr[k] = arr1[i];
                i++;
            }
            else {

                arr[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < n1) {

            arr[k] = arr1[i];
            k++;
            i++;
        }

        while (j < n2) {

            arr[k] = arr2[j];
            k++;
            j++;
        }
    }
}
