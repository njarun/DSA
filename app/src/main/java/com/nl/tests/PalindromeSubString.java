package com.nl.tests;

public class PalindromeSubString {

    public static void main(String[] args) {

        String str = "aaa"; //10
        System.out.println("PSS = " + countSubstrings(str));
    }

    public static int countSubstrings(String str) {

        int res = 0;

        for (int i = 0; i < str.length(); i++) {

            String subS = String.valueOf(str.charAt(i));
            String concat = subS;
            String concatRev = subS;

            for (int j = i + 1; j < str.length(); j++) {

                String nextS = String.valueOf(str.charAt(j));
                concat = concat + nextS;
                concatRev = nextS + concatRev;
                
                if(concat.equals(concatRev)) {
                    res++;
                }
            }

            res++;
        }

        return res;
    }
}
