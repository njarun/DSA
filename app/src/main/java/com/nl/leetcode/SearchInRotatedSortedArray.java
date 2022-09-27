package com.nl.leetcode;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{4,5,6,7,0,1,2};
        System.out.println("Index - " + search(arr, 0));
    }

    public static int search(int[] nums, int target) {

        int index = -1;
        int l = 0, r = nums.length - 1;

        while(l <= r) {

            int m = (l+r) /2;

            if(nums[m] == target) {
                index = m;
                break;
            }

            if(nums[l] <= nums[m]) {

                if(target > nums[m] || target < nums[l])
                    l = m + 1;
                else r = m - 1;
            }
            else {

                if(target > nums[m] || target > nums[r])
                    r = m - 1;
                else l = m + 1;
            }

        }

        return index;
    }
}
