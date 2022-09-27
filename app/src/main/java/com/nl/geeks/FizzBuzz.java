package com.nl.geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {

        List<String> fizzBuzzArr = fizzBuzzFewLines(15);

        System.out.println(Arrays.toString(fizzBuzzArr.toArray()));
    }

    public static List<String> fizzBuzzFewLines(int n) {

        List<String> list = new ArrayList<>();

        IntStream.rangeClosed(1, n)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
                .forEach(i -> {
                    list.add("" + i);
                });

        return list;
    }

    public static List<String> fizzBuzzFast(int n) {

        List<String> list = new ArrayList<>();

        String s = "";
        int f3 = 0;
        int b5 = 0;

        for (int a = 1; a <= n; a++) {

            f3++;
            b5++;

            if (f3 == 3) {

                s += "Fizz";
                f3 = 0;
            }

            if (b5 == 5) {

                s += "Buzz";
                b5 = 0;
            }

            if (s.isEmpty()) {
                list.add("" + a);
            } else list.add(s);

            s = "";
        }

        return list;

    }

    public static List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();

        for (int a = 1; a <= n; a++) {

            if (a % 15 == 0) {

                list.add("FizzBuzz");
            } else if (a % 5 == 0) {

                list.add("Buzz");
            } else if (a % 3 == 0) {

                list.add("Fizz");
            } else {

                list.add("" + a);
            }
        }

        return list;

    }
}
