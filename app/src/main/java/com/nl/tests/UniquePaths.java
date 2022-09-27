package com.nl.tests;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {

        System.out.println("Max unique paths = " + uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];
        for (int[] arr: dp) {
            Arrays.fill(arr, 0);
        }

        dp[m-1][n-1] = 1;

        for (int i = m-1; i >= 0; i--) {

            for (int j = n-1; j >= 0; j--) {

                if(i == m-1 && j == n-1)
                    continue;

                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}