package com.nl.codecademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) {

        String s = "this is test input";

        //[2, 1, 0, 1, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4]
        //[2, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4]

        int[] distArr = shortestDistanceToChar(s, 'i');

        System.out.println("distArr - " + Arrays.toString(distArr));
    }

    public static int[] shortestDistanceToChar(String s, char c) {

        List<Integer> posList = new ArrayList();

        for(int i=0; i<s.length(); i++) {

            if(s.charAt(i) == c) {

                posList.add(i);
            }
        }

        int[] distArr = new int[s.length()];

        int posIndex = 0;

        //this is test input

        for(int i=0; i<s.length(); i++) {

            int nextIndex = -1;
            int furtherIndex = -1; //5

            if(posList.size() > posIndex)
                nextIndex = posList.get(posIndex); //2

            if(posList.size() > posIndex+1) {
                furtherIndex = posList.get(posIndex+1);
            }

            char currentChar = s.charAt(i); //t

            if(currentChar == c) {

                distArr[i] = 0;
            }
            else if(furtherIndex == -1) {

                int prevVal = 0;
                if(i>0) {
                    prevVal = distArr[i-1];
                }

                distArr[i] = prevVal+1;
            }
            else {

                if(i==0) {

                    distArr[0] = nextIndex;
                }
                else {

                    int mid = (furtherIndex - nextIndex)/2; //1
                    int prevVal = 0;

                    prevVal = distArr[i-1]; // 0

                    int dist;

                    if(prevVal == mid) {
                        dist = prevVal;
                    }
                    else if(prevVal < mid) {
                        dist = prevVal+1;
                    }
                    else {

                        dist = prevVal-1;
                    }

                    distArr[i] = dist;
                }
            }

            if(i>nextIndex) {
                posIndex++;
            }
        }

        return distArr;
    }
}
