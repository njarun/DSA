package com.nl.tests;

public class StringSegamentation {

    public static void main(String[] args) {

        String[] arr = new String[]{"apple", "pen"};
        String str = "applepenapple";
        System.out.println("Exists - " + sumExists(arr, str));
    }

    public static boolean sumExists(String[] arr, String str) {

        for (int i = 0; i < arr.length; i++) {
            str = str.replaceAll(arr[i], "");
        }

        return str.length() <= 0;
    }
}