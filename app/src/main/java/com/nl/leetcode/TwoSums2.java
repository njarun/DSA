package com.nl.leetcode;

import java.util.Arrays;

public class TwoSums2 {

    public static void main(String[] args) {

        int[] arr = new int[]{2,7,11,15};
        System.out.println("Indices - " + Arrays.toString(twoSum(arr, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {

            int diff = target - (nums[l] + nums[r]);

            if(diff == 0) {

                return new int[]{l, r};
            }
            else if(diff < 0) {

                r--;
            }
            else {

                l++;
            }
        }

        return new int[0];
    }
}
