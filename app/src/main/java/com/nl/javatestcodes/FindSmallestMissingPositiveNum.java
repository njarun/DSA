package com.nl.javatestcodes;

public class FindSmallestMissingPositiveNum {

    public static void main(String[] args) {

        System.out.println("" + System.currentTimeMillis());

        int[] a = new int[]{1,4,0,6,3,2};

        for(int i = 0; i< a.length; i++) {

            for(int j=i+1; j<a.length; j++) {

                if(a[i] > a[j]) {

                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        int nextNum = 0;

        for (int i = 0; i < a.length; i++) {

            if(i<a.length - 1) {

                if((a[i+1] != a[i] + 1) && (a[i] + 1) > 0) {
                    nextNum = a[i] + 1;
                }
            }
            else if(nextNum == 0) {

                nextNum = a[i] + 1;
            }
        }

        nextNum = nextNum <= 0 ? 1 : nextNum;

        for (int i: a) {
            System.out.println("i = " + i);
        }

        System.out.println("Next num = " + nextNum);

        System.out.println("" + System.currentTimeMillis());
    }
}
