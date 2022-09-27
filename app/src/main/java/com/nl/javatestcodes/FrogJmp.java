package com.nl.javatestcodes;

public class FrogJmp {

    public static void main(String[] args) {

        int x = 5;
        int y = 1000000000;
        int d = 2;

        int steps = (y-x)/d;

        if((y-x) % d > 0)
            steps++;

        System.out.println("Steps - " + steps);
    }
}