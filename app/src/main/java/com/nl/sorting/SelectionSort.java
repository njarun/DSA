package com.nl.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = {5, 9, 2, 4, 1, 3, 6, 7, 8};

        SelectionSort(nums);

        System.out.println("Arr = " + Arrays.toString(nums));
    }

    public static void SelectionSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            int index = i;

            for (int j = i+1; j < nums.length; j++) {

                if(nums[j] < nums[index]) {
                    index = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
}
