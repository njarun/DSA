package com.nl.leetcode;

public class MaxProductInSubArray {

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,-2,0,-2,2,4};
        System.out.println("Prod Arr - " + maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {

        Integer res = null;
        int curMax = 1, curMin = 1;

        for(int i = 0; i<nums.length; i++) {

            int num = nums[i];
            int tempMax = curMax * num;

            curMax = Math.max(Math.max(curMax * num, curMin * num), num);
            curMin = Math.min(Math.min(tempMax, curMin * num), num);

            res = res != null ? Math.max(curMax, res) : curMax;
        }

        if(res == null)
            res = 0;

        return res;
    }
}
