package com.nl.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] nums = {5, 9, 2, 4, 1, 3, 6, 7, 8};

        MergeSort(nums, 0, nums.length-1);

        System.out.println("Arr = " + Arrays.toString(nums));
    }

    public static void MergeSort(int[] nums, int l, int r) {

        if(l < r) {

            int m=(l+r)/2;

            MergeSort(nums, l, m);
            MergeSort(nums, m+1, r);

            merge(nums, l, m, r);
        }
    }

    private static void merge(int[] nums, int l, int m, int r) {

        int n1 = m-l+1;
        int n2 = r-m;

        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = nums[l+i];
        }

        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = nums[m+1+i];
        }

        int i=0, j=0, k=l;
        while (i<n1 && j<n2) {

            if(arr1[i] <= arr2[j]) {
                nums[k] = arr1[i]; i++;
            }
            else {
                nums[k] = arr2[j]; j++;
            }

            k++;
        }

        while (i < n1) {

            nums[k] = arr1[i];
            i++;
            k++;
        }

        while (j < n2) {

            nums[k] = arr2[j];
            j++;
            k++;
        }
    }
}
