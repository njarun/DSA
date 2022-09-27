package com.nl.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KClosestNumbersToXInArray {

    public static void main(String[] args) {

        //int[] arr = new int[]{2, 4, 5, 6, 9};
        //int[] arr = new int[]{4, 5, 9, 11, 15, 3, 17};
        //int[] arr = new int[]{1, 3, 7, 2, 5, 4};
        //int[] arr = new int[]{1,2,-3,-4,5};
        //int[] arr = new int[]{1, 3, 7, 2, 5, 4};
        //int[] arr = new int[]{1,2,3,4,5};
        //int[] arr = new int[]{0,0,1,2,3,3,4,7,7,8};
        //int[] arr = new int[]{1,1,1,10,10,10};
        //int[] arr = new int[]{1};
        //int[] arr = new int[]{1,2,2,2,5,5,5,8,9,9};
        int[] arr = new int[]{3,5,8,10};

        System.out.println("Closest numbers = " + findClosestElements(arr, 2, 15));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {


        //find index or closest index
        //find k elements using two pointer

        Arrays.sort(arr);

        int index = arr.length - 1;

        for(int i=0; i<arr.length; i++) {

            if(arr[i] == x) {

                index = i;
                break;
            }
            else if(arr[i] > x) {

                if(i == 0) {

                    index = i;
                }
                else {

                    int left = arr[i-1];
                    int right = arr[i];

                    if(Math.abs(x - left) <= Math.abs(right - x)) {

                        index = i-1;
                    }
                    else index = i;
                }

                break;
            }
        }

        List<Integer> cArr = new ArrayList<>();
        cArr.add(arr[index]);
        int closeIndex = 1;

        int l = index - 1;
        int r = index + 1;

        while(closeIndex < k) {

            int left = Integer.MIN_VALUE;
            if(l >= 0) {
                left = arr[l];
            }

            int right = Integer.MIN_VALUE;
            if(r < arr.length) {
                right = arr[r];
            }

            if(left != Integer.MIN_VALUE &&
                    (right == Integer.MIN_VALUE ||
                            Math.abs(x - left) <= Math.abs(right - x))) {

                cArr.add(left);
                l--;
            }
            else {

                cArr.add(right);
                r++;
            }

            closeIndex++;
        }

        Collections.sort(cArr);

        return cArr;
    }

    public static List<Integer> findClosestElementsWrong(int[] arr, int k, int x) {

        Arrays.sort(arr);

        int index = 0;
        int l = 0, r = arr.length - 1;
        int minDiff = Math.max(x, arr[r]);

        if(x < arr[0]) {

            index = l;
        }
        else if(x > arr[r]) {

            index = arr.length - k;
        }
        else {

            for (int i = 0; i < arr.length; i++) {

                int diff = x - arr[i];
                if (diff <= 0 || diff > minDiff) {

                    index = i + k > r ? i - k : i + 1;

                    if(index > r)
                        index = r - k;

                    if(index < 0)
                        index = 0;

                    break;
                }

                minDiff = diff;
            }
        }

        List<Integer> closestNums = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            closestNums.add(index + i > arr.length - 1 ? 0 : arr[index + i]);
        }

        Collections.sort(closestNums);

        return closestNums;
    }
}