package com.nl.tests;

public class MissingNumber {

    public static void main(String[] args) {

        int[] arr = new int[]{8, 3, 5, 2, 4, 6, 0, 1};
        System.out.println("Missing num: " + missingNum(arr));
    }

    public static int missingNum(int[] arr) {

        int sum = arr.length;
        for (int i = 0; i < arr.length; i++) {
            sum += i - arr[i];
        }

        return sum;
    }
}