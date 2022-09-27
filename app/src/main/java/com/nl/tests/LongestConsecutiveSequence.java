package com.nl.tests;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        //int[] nums = {100,4,200,1,3,2};
        //int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println("Longest sequence = " + longestConsecutiveEfficient(nums));
    }

    public static int longestConsecutiveEfficient(int[] num) {

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : num) {

            if (!map.containsKey(n)) {

                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);

                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);

                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }

    public static int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int len = 1;
        int max = len;

        for(int i=1; i<nums.length; i++) {

            if(nums[i] == (nums[i-1] + 1) || nums[i] == nums[i-1]) {

                if(nums[i] == nums[i-1] && len > 0)
                    continue;

                len++;
            }
            else {

                max = Math.max(max, len);
                len = 1;
            }
        }

        return Math.max(max, len);
    }
}
