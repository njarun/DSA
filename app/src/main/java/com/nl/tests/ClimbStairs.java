package com.nl.tests;

public class ClimbStairs {

    public static void main(String[] args) {

        int destination = 5;
        System.out.println("Steps = " + climbStairsEfficientRevise(destination));
    }

    public static int climbStairsEfficientRevise(int n) {

        int e=0, s=1;
        for (int i = n-1; i >=0; i--) {

            int temp = s;
            s = e+s;
            e = temp;
        }

        return s;
    }

    public static int climbStairsEfficient(int n) {

        int e = 0, s = 1;

        for(int i=n-1; i >= 0; i--) {

            int temp = s;
            s = s + e;
            e = temp;
        }

        return s;
    }

    public static int climbStairs(int n) {

        int e = 0, s = 1;
        int[] stepsArr = new int[n];

        for(int i=n-1; i >= 0; i--) {

            stepsArr[i] = s + e;
            int temp = s;
            s = stepsArr[i];
            e = temp;
        }

        return stepsArr[0];
    }
}
