package com.nl.codecademy;

import java.util.ArrayList;
import java.util.List;

public class StringReverse {

    public static void main(String[] args) {

        String string = "ArunJose";
        List<String> list = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            list.add(String.valueOf(string.charAt(i)));
        }

        int len = list.size();

        for (int i = 0; i < len / 2; i++) {

            int startPos = i;
            int endPos = len - i - 1;

            String first = list.get(startPos);
            list.set(startPos, list.get(endPos));
            list.set(endPos, first);
        }

        String reversed = String.join("", list);
        System.out.println("Reverse of " + string + " is " + reversed);
    }
}
