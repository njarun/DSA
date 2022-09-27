package com.nl.leetcode;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4};
        System.out.println("Prod Arr - " + Arrays.toString(productExceptSelf(arr)));
    }

    public static Integer[] productExceptSelf(int[] nums) {

        int prefix = 1;
        int postfix = 1;

        Integer[] prodArr = new Integer[nums.length];
        Arrays.fill(prodArr, null);

        for(int i=0; i<nums.length; i++) {

            int sNum = nums[i];
            prodArr[i] = prodArr[i] != null ? prodArr[i] * prefix : prefix;
            prefix *= sNum;

            int lPos = nums.length - 1 - i;
            int lNum = nums[lPos];
            prodArr[lPos] = prodArr[lPos] != null ? prodArr[lPos] * postfix : postfix;
            postfix *= lNum;
        }

        return prodArr;
    }
}
