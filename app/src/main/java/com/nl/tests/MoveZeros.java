package com.nl.tests;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12,0,0};
        moveZeroes(nums);
        System.out.println("String is palindrome = " + Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {

        int index=0;

        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) nums[index++]=nums[i];
        }
        while(index<nums.length){
            nums[index++]=0;
        }

    }
}
