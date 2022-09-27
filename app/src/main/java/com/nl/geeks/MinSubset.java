package com.nl.geeks;

import java.util.Arrays;

public class MinSubset {

    public static void main(String[] args) {



    }

    int minSubset(int[] arr,int n) {

        Arrays.sort(arr);

        /*for(int i=0; i<n; i++) {

            for(int j=i; j<n; j++) {

                if(arr[i] > arr[j]) {

                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }*/

        long totalSum = 0;

        for(int i=0; i<n; i++) {
            totalSum += arr[i];
        }

        long minSum = 0;
        int count = 1;

        for(int i=n-1; i>=0; i--) {

            totalSum -= arr[i];
            minSum += arr[i];

            if(totalSum >= minSum) {

                count++;
            }
            else {

                break;
            }
        }

        return count;
    }
}
