package com.nl.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] nums = {5, 9, 2, 4, 1, 3, 6, 7, 8};

        BubbleSort(nums);

        System.out.println("Arr = " + Arrays.toString(nums));
    }

    public static void BubbleSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < nums.length - 1 - i; j++) {

                if(nums[j] > nums[j+1]) {

                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;

                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }
}
