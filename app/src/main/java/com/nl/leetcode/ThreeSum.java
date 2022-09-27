package com.nl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] arr = new int[]{-1,0,1,2,-1,-4};
        System.out.println("Index - " + threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> indexHolderList = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {

            int a = nums[i];
            if(i> 0 && a == nums[i-1]) {
                continue;
            }

            int l=i+1, r = nums.length - 1;

            while(l < r) {

                int diff = a + nums[l] + nums[r];

                if(diff == 0) {

                    indexHolderList.add(Arrays.asList(a, nums[l], nums[r]));
                    l++;

                    while(nums[l] == nums[l-1] && l<r)
                        l++;
                }
                else if(diff > 0) {

                    r--;
                }
                else {

                    l++;
                }
            }
        }

        return indexHolderList;
    }
}
