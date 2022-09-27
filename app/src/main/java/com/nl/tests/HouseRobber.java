package com.nl.tests;

public class HouseRobber {

    public static void main(String[] args) {

        int[] nums = new int[]{2,1,1,2};
        System.out.println("Max cash = " + rob2(nums));
    }

    public static int rob(int[] nums) {

        int rob1 = 0, rob2 = 0;

        for (int num : nums) {

            int currentRob = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = currentRob;
        }

        return rob2;
    }

    public static int rob2(int[] nums) { //When houses are in circled

        int max = 0;
        int len = nums.length;

        if(len > 0) {

            if(len > 1) {

                max = Math.max(findMaxRobCash(nums, 0, len - 1),
                        findMaxRobCash(nums, 1, nums.length));
            }
            else {

                max = nums[0];
            }
        }

        return max;
    }

    private static int findMaxRobCash(int[] nums, int start, int end) {

        int rob1 = 0, rob2 = 0;

        for (int i = start; i < end; i++) {

            int currentRob = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = currentRob;
        }

        return rob2;
    }
}