package com.nl.search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1,4,6,73,89,32,46,24,29,1,77,43,44,87,377,283,12};
        System.out.println("Search index - " + binarySearch(nums, 29, 0, nums.length-1));
    }

    public static int binarySearch(int[] nums, int num, int l, int r) {

        for (int i = 0; i < nums.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < nums.length - 1 - i; j++) {

                if(nums[j] > nums[j+1]) {

                    nums[j] = nums[j] + nums[j+1];
                    nums[j+1] = nums[j] - nums[j+1];
                    nums[j] = nums[j] - nums[j+1];

                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }

        return search(nums, num, l, r);
    }

    public static int search(int[] nums, int num, int l, int r) {

        if(l>=r) {
            return -1;
        }

        int mid = l + (r-l)/2;

        if(nums[mid] == num) {
            return mid;
        }
        else if(nums[mid] < num) {
            return search(nums, num, mid-1, r);
        }
        else {
            return search(nums, num, l, mid+1);
        }
    }
}
