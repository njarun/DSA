package com.nl.tests;

public class MaxSumInArray {

    public static void main(String[] args) {

        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Sum = " + maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr) {

        if(arr.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        int l = 0;

        while (l < arr.length) {

            int num = arr[l];

            if(curSum < 0)
                curSum = 0;

            curSum = curSum + num;
            maxSum = Math.max(maxSum, curSum);

            l++;
        }

        return maxSum;
    }

    public int maxSubArrayEfficient(int[] nums) {

        int currSum = 0;
        Integer maxSum = null;

        for(int i=0; i<nums.length; i++) {

            int num = nums[i];

            if(currSum < 0)
                currSum = 0;

            currSum += num;

            maxSum = maxSum == null ? currSum : Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
