package com.nl.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    public static void main(String[] args) {


        //int[] arr = new int[]{9,6,4,2,3,5,7,0,1};
        //System.out.println("Missing No - " + missingNumberWithXOR(arr));
    }

    public static int missingNumberWithXOR(int[] nums) {

        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res ^= (i ^ nums[i]);
        }

        return res;
    }

    public static int missingNumberWithAddition(int[] nums) {

        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res += (i - nums[i]);
        }

        return res;
    }

    public static int missingNumberWithSet(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();

        for (int i = 0; i <= nums.length; i++) {
            numsSet.add(i);
        }

        for(int i=0; i<nums.length; i++) {
            numsSet.remove(nums[i]);
        }

        return numsSet.size() > 0 ? (int) numsSet.toArray()[0] : -1;
    }

    public static int missingNumberWithSorting(int[] nums) {

        int misNum = -1;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {

            if(nums[i] != i) {
                misNum = i;
                break;
            }
        }

        if(misNum == -1 && nums.length != nums[nums.length - 1])
            misNum = nums.length;

        return misNum;
    }
}