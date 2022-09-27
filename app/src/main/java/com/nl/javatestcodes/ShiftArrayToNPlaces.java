package com.nl.javatestcodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiftArrayToNPlaces {

    public static void main(String[] args) {

        int[] a = new int[]{3, 8, 9, 7, 6}; // [9, 7, 6, 3, 8]
        int k = 3;
        int[] b = new int[a.length];

        while(k > 0) {

            for(int i=0; i<a.length; i++) {

                int swapA = i;
                int swapB = i == 0 ? a.length - 1 : i-1;

                b[swapA] = a[swapB];
            }

            a = b;
            b= new int[a.length];
            k--;
        }

        System.out.println(Arrays.toString(a));

        Map<Integer, List<Integer>> numIndexPairMap = new HashMap<>();
    }
}
