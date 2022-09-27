package com.nl.leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("Max area - " + maxArea(arr));
    }

    public static int maxArea(int[] height) {

        int maxArea = 0;

        int l=0, r= height.length - 1;

        while (l < r) {

            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);

            if(height[l] < height[r]) {
                l++;
            }
            else r--;
        }

        return maxArea;
    }

    public static int maxAreaBrutForce(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i+1; j < height.length; j++) {

                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
