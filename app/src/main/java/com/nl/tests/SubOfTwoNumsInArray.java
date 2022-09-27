package com.nl.tests;

import java.util.HashMap;
import java.util.Map;

public class SubOfTwoNumsInArray {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println("Exists - " + sumExists(arr, 69));
    }

    public static boolean sumExists(int[] nums, int k) {

        int l=0;
        int r=nums.length - 1;

        while (l <= r) {

            int diff = k - (nums[l] + nums[r]);

            if(diff == 0) {
                return true;
            }
            else if(diff < 0) {
                r--;
            }
            else {
                l++;
            }
        }

        return false;
    }

    public static boolean sumExistsSet(int[] nums, int k) {

        Map<Integer, Integer> valIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int diff = k - nums[i];

            if(valIndexMap.containsKey(diff)) {
                return true;
            }

            valIndexMap.put(nums[i], i);
        }

        return false;
    }
}