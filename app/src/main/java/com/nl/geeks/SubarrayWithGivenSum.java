package com.nl.geeks;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,7,5};
        ArrayList<Integer> subArr = subarraySum(arr, 5, 12);

        System.out.println(Arrays.toString(subArr.toArray()));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        ArrayList<Integer> subArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            int a = arr[i];
            int sum = a;
            int j = i+1;

            for (; sum < s && j < arr.length; j++) {

                int b = arr[j];
                sum += b;
            }

            if(sum == s && sum != 0) {

                subArr.add(i+1);
                subArr.add(j);
                break;
            }
        }

        if(subArr.isEmpty())
            subArr.add(-1);

        return subArr;
    }
}
