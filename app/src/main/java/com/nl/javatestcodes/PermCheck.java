package com.nl.javatestcodes;

import java.util.Arrays;

public class PermCheck {

    public static void main(String[] args) {

        int[] a = new int[]{4, 1, 3};

        int isValid = 1;

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {

            if(a[i] != i+1) {
                isValid = 0;
                break;
            }
        }

        /*Set<Integer> numSet = new TreeSet<>();
        int max = 0;

        for (int j : a) {

            if(numSet.contains(j)) {
                isValid = 0;
                break;
            }

            numSet.add(j);
            max = Math.max(max, j);
        }

        if(isValid == 1) {

            if (numSet.size() != max) {
                isValid = 0;
            }
            else {

                for (int i = 1; i <= max; i++) {

                    if (!numSet.contains(i)) {
                        isValid = 0;
                        break;
                    }
                }
            }
        }*/

        System.out.println(Arrays.toString(a) + " - " + isValid);
    }
}
