package com.nl.leetcode;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1, 3, nums2, 3);

        System.out.println("Arr = " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int a = m-1;
        int b = n-1;
        int index = m+n-1;

        while (b >= 0) {

            if(a >= 0 && nums1[a] > nums2[b]) {

                nums1[index] = nums1[a];
                a--;
            }
            else {

                nums1[index] = nums2[b];
                b--;
            }

            index--;
        }
    }
}
