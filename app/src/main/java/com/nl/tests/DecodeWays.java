package com.nl.tests;

public class DecodeWays {

    public static void main(String[] args) {

        String s = "2101";
        System.out.println("Decode ways = " + numDecodings(s));
    }

    public static int numDecodings(String s) {

        if(s.trim().isEmpty() || s.startsWith("0")) {
            return 0;
        }

        int dp1=1, dp2=0, n=s.length();
        for(int i=n-1;i>=0;i--) {
            int dp=s.charAt(i)=='0'?0:dp1;
            if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
                dp+=dp2;
            dp2=dp1;
            dp1=dp;
        }
        return dp1;
    }

    public static int numDecodingsWrong(String s) {

        if(s.trim().isEmpty() || s.startsWith("0")) {
            return 0;
        }

        int maxWays = 0;

        for (int i = 0; i < s.length(); i++) {

            int first = Integer.parseInt(String.valueOf(s.charAt(i)));

            if(first <= 0) {
                maxWays--;
                continue;
            }

            maxWays++;

            if( i < s.length() - 1) {

                int second = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
                int firstAndSecond = Integer.parseInt(first + "" + second);

                if(second > 0 && firstAndSecond > 0 && firstAndSecond < 27) {
                    maxWays++;
                }
                else {
                    maxWays--;
                }

                i++;
            }
            else {
                maxWays--;
            }
        }

        return Math.max(0, maxWays);
    }
}