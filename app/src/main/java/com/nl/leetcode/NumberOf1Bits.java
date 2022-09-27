package com.nl.leetcode;

public class NumberOf1Bits {

    public static void main(String[] args) {

        System.out.println("1's count = " + hammingWeightNand(11));
    }

    public static int hammingWeight(int n) {

        int count = 0;
        String str = Integer.toBinaryString(n);

        for(int i=0; i<str.length(); i++) {

            if(str.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    public static int hammingWeightByReplace(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }

    public static int hammingWeightNand(int n) {

        int count = 0;

        while(n!=0) {

            count++;
            n &= (n -1);
        }

        return count;
    }

    public static int hammingWeightRightShift(int n) {

        int count = 0;

        while(n!=0) {

            count += n%2;
            n = n >> 1;
        }

        return count;
    }
}
