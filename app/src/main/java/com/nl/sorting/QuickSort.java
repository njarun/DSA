package com.nl.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = {2,5,3,8,6,0,1,4,7,9};

        QuickSort(nums, 0, nums.length - 1);

        System.out.println("Arr - " + Arrays.toString(nums));
    }

    public static void QuickSort(int[] nums, int l, int r) {

        if(l<r) {

            int p = findPartition(nums, l, r);

            QuickSort(nums, l, p-1);
            QuickSort(nums, p+1, r);
        }
    }

    private static int findPartition(int[] nums, int l, int r) {

        int pivot = nums[r];
        int i = (l-1);

        for (int j = l; j < r; j++) {

            if(nums[j] < pivot) {

                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i+1, r);

        return i+1;
    }

    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}