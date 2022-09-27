package com.nl.hacker_rank;

import java.util.Scanner;

public class HackerRank {

    static int solveMeFirst(int a, int b) {

        return a+b;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a: ");
        int a = in.nextInt();
        System.out.println("Enter b: ");
        int b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println("Sum = 1" + sum);
    }
}
