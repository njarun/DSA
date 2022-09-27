package com.nl.javatestcodes;

public class FindLargestBinaryGap {

    public static void main(String[] args) {

        int n = 805306373;
        //int n = 1073741825;
        //int n = 1610612737;

        String binaryStr = Integer.toBinaryString(n);

        System.out.println(binaryStr);

        int topZeroLen = 0;
        int currentZeroCount = 0;
        boolean isStarted = false;

        for(int i=0; i<binaryStr.length(); i++) {

            Character c = binaryStr.charAt(i);

            if(c.equals('1')) {

                if(currentZeroCount > topZeroLen) {
                    topZeroLen = currentZeroCount;
                }

                currentZeroCount = 0;
            }
            else {

                currentZeroCount++;
            }
        }

        System.out.println(topZeroLen);
    }
}
