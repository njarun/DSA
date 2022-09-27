package com.nl.hacker_rank;

import static java.util.stream.Collectors.toList;

import android.annotation.SuppressLint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

@SuppressLint("NewApi")
public class BirthdayCakeCandles {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = birthdayCakeCandles(candles);

        System.out.println("count - " + result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
    
    public static int birthdayCakeCandles(List<Integer> candles) {

        int tallestCandle = 0;
        Map<Integer, Integer> countMap = new TreeMap<>();

        for (int i = 0; i < candles.size(); i++) {

            int candle = candles.get(i);
            Integer candleCount = countMap.get(candle);
            if(candleCount == null)
                candleCount = 0;

            countMap.put(candle, candleCount+1);

            if(candle > tallestCandle)
                tallestCandle = candle;
        }

        Integer count = countMap.get(tallestCandle);
        if(count == null)
            count = 0;

        return count;
    }
}