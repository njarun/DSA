package com.nl.codecademy;

public class Palindrome {

    public static void main(String[] args) {

        String pali = "axpypxa";
        int len = pali.length();

        boolean isValid = true;

        for (int i = 0; i < len / 2; i++) {

            String start = String.valueOf(pali.charAt(i));
            String end = String.valueOf(pali.charAt(len - i - 1));

            if(!start.equals(end)) {
                isValid = false;
                break;
            }
        }

        System.out.println(pali + " is palindrom - " + isValid);
    }
}
