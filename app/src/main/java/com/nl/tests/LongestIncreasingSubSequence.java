package com.nl.tests;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {

        //int[] nums = new int[]{10,9,2,5,3,7,101,18};
        //int[] nums = new int[]{0,3,1,6,2,2,7};
        //int[] nums = new int[]{5,4,3,2,1,0};
        //int[] nums = new int[]{1,5,2,7,3};
        int[] nums = new int[]{13,0,1,3,4,8,4};
        System.out.println("Longest sub sequence = " +  lengthOfLIS(nums));
        //System.out.println("Longest sub sequence = " +  lengthOfLISContiguous(nums));
    }

    public static int lengthOfLISDecreasing(int[] nums) {

        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int lLis = 1;

        for(int i=n-1; i>=0; i--) {

            for (int j = i-1; j >= 0; j--) {

                if(nums[i] > nums[j]) {

                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                    lLis = Math.max(lLis, lis[i]);
                }
            }
        }

        return lLis;
    }

    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int lLis = 1;

        for(int i=n-1; i>=0; i--) {

            for (int j = i+1; j < n; j++) {

                if(nums[i] < nums[j]) {

                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                    lLis = Math.max(lLis, lis[i]);
                }
            }
        }

        return lLis;
    }
    
    public static int lengthOfLISContiguous(int[] nums) {

        int n = nums.length;
        int[] lis = new int[n];
        lis[n-1] = 1;

        int lLis = 0;

        for(int i=n-2; i>=0; i--) {

            lis[i] = (nums[i] > nums[i+1]) ? 1 : 1 + lis[i+1];
            lLis = Math.max(lLis, lis[i]);
        }

        return lLis;
    }
}
