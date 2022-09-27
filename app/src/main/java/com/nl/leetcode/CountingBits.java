package com.nl.leetcode;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {

        System.out.println("Bits count - " + Arrays.toString(countBits(5)));
    }

    public static int[] countBitsWithOffset(int n) {

        int[] onesArr = new int[n+1];
        onesArr[0] = 0;
        int offset = 1;

        for(int i=1; i<=n; i++) {

            if(offset * 2 == i)
                offset = i;

            onesArr[i] = 1 + onesArr[i - offset];
        }

        return onesArr;
    }

    public static int[] countBits(int n) {

        int[] onesArr = new int[n+1];

        for(int i=0; i<=n; i++) {

            int ones = 0;
            int nextNum = i;

            while(nextNum != 0) {

                ones++;
                nextNum &= (nextNum - 1);
            }

            onesArr[i] = ones;
        }

        return onesArr;
    }
}