package com.nl.hacker_rank;

import static java.util.stream.Collectors.toList;

import android.annotation.SuppressLint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SuppressLint("NewApi")
public class MiniMaxSum {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the array:");

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        for (int i = 0; i < arr.size(); i++) {

            for (int j = i+1; j < arr.size(); j++) {

                if(arr.get(i) > arr.get(j)) {

                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }

        miniMaxSum(arr);

        bufferedReader.close();
    }

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {

        long max = 0;
        long min = 0;

        for (int i = 0; i < arr.size(); i++) {

            if(i != 0)
                max += arr.get(i);

            if(i != arr.size() - 1)
                min += arr.get(i);
        }

        System.out.println("Asc Array " + Arrays.toString(arr.toArray()));
        System.out.println("Max = " + max + ", Min = " + min);
    }
}