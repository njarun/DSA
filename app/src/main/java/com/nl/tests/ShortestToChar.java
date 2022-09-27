package com.nl.tests;

import java.util.Arrays;

public class ShortestToChar {

    public static void main(String[] args) {

        String input = "loveleetcodexxx";
        char c = 'e';

        System.out.println("Shortest path array = " +  Arrays.toString(shortestToChar(input, c)));
    }

    public static int[] shortestToChar(String s, char c) {

        int[] arr = new int[s.length()];
        int index = -s.length()-1;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == c) {
                index = i;
            }

            arr[i] = i-index;
        }

        for (int i = s.length()-1; i >= 0; i--) {

            if(s.charAt(i) == c) {
                index = i;
            }

            arr[i] = Math.min(arr[i], Math.abs(i- index));
        }

        return arr;
    }
}
