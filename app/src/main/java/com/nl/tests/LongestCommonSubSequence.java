package com.nl.tests;

import java.util.Arrays;

public class LongestCommonSubSequence {

    public static void main(String[] args) {


        //String text1 = "abcde";
        //String text2 = "ace";

        String text1 = "ezupkr";
        String text2 = "ubmrapg";

        System.out.println("Longest common sub sequence = " +  longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int rows = text1.length() + 1;
        int cols = text2.length() + 1;
        int[][] matchMatrix = new int[rows][cols];

        for (int[] arr: matchMatrix) {
            Arrays.fill(arr, 0);
        }

        for (int i = rows-2; i >= 0; i--) {

            for (int j = cols - 2; j >= 0; j--) {

                if(text1.charAt(i) == text2.charAt(j)) {
                    matchMatrix[i][j] = 1 + matchMatrix[i+1][j+1];
                }
                else {
                    matchMatrix[i][j] = Math.max(matchMatrix[i][j+1],  matchMatrix[i+1][j]);
                }
            }
        }

        return matchMatrix[0][0];
    }
}
