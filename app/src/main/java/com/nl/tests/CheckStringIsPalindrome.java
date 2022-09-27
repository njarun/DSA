package com.nl.tests;

public class CheckStringIsPalindrome {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        //String s = "";
        //String s = "  .";
        //String s = "0P";
        //String s = "+++PP";
        System.out.println("String is palindrome = " + isPalindromeRevise(s));
    }

    public static boolean isPalindromeRevise(String s) {

        if(s == null || s.trim().equals("")) {
            return true;
        }

        int start = 0, end = s.length() - 1;

        while (start <= end) {

            char chrS = s.charAt(start);
            char chrE = s.charAt(end);

            if(Character.isLetterOrDigit(chrS) && Character.isLetterOrDigit(chrE)) {

                if(Character.toLowerCase(chrS) != Character.toLowerCase(chrE)) {
                    return false;
                }

                start++;
                end--;
            }
            else if(!Character.isLetterOrDigit(chrS)) {

                start++;
            }
            else if(!Character.isLetterOrDigit(chrE)) {

                end--;
            }
        }

        return true;
    }

    public static boolean isPalindromeDoubleLoop(String s) {

        String newS = "";

        for(int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            if(c > 64 && c < 91) {
                c += 32;
            }
            else if((c < 97 || c > 122) && (c < 48 || c > 57)) {
                c = 0;
            }

            if(c != 0) {
                newS = newS + c;
            }
        }

        for(int i =0; i<newS.length()/2; i++) {

            char cS = newS.charAt(i);
            char cE = newS.charAt(newS.length() - 1 - i);

            if(cS != cE)
                return false;
        }

        return true;
    }

    public static boolean isPalindromeTwoPointer(String s) {

        if (s.trim().isEmpty()) {
            return true;
        }

        int head = 0, tail = s.length() - 1;
        char cHead, cTail;

        while(head <= tail) {

            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    static int fIndex = 0;
    static int lIndex = 0;

    public static boolean isPalindrome(String s) {

        String newS = "";

        boolean isPalindrome = true;
        fIndex = 0;
        lIndex = s.length() - 1;

        for(int i=0; i<s.length(); i++) {

            char cStart = getCharForIndex(s, fIndex, true);
            char cEnd = getCharForIndex(s, lIndex, false);

            if(cStart != cEnd) {

                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    private static char getCharForIndex(String s, int i, boolean forward) {

        char c = s.charAt(forward ? i : s.length() - 1 - i);

        if(c > 64 && c < 91) {
            c += 32;
        }

        while((c < 97 || c > 122) && (forward ? i < s.length() - 1 : i > 0)) {

            c = s.charAt(forward ? ++i : --i);

            if(c > 64 && c < 91) {
                c += 32;
            }
        }

        if(c < 96 || c > 123) {
            c = 0;
        }

        if(forward)
            fIndex++;
        else lIndex--;

        return c;
    }
}
