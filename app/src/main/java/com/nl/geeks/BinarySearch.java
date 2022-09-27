package com.nl.geeks;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};
        int pos = binarysearchCopied(arr, 5, 4);

        System.out.println("pos - " + pos);
    }

    private static int binarysearchCopied(int[] arr, int n, int k) {

        int l=0;
        int r = n-1;
        while(l<=r) {
            
            int mid = (l+r)/2;

            if(k==arr[mid])
            {
                return mid;
            }
            else if(k<arr[mid])
            {
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        return -1;
    }
}
