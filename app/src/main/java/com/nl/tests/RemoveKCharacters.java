package com.nl.tests;

public class RemoveKCharacters {

    public static void main(String[] args) {

        //System.out.println("Arr = " + removeKdigits("1432219", 3)); //"1219"
        //System.out.println("Arr = " + removeKdigits("10200", 1)); //"1219"
        //System.out.println("Arr = " + removeKdigits("112", 1)); //"11"
        //System.out.println("Arr = " + removeKdigits("1173", 2)); //"11"
        System.out.println("Arr = " + removeKdigits("5337", 2)); //"1219"
    }

    public static String removeKdigits(String num, int s) {

        if(num.length() == s) {
            return "0";
        }

        int index = 0;
        String smm = "";
        int lastIndexAdded = -1;

        while(index < num.length() - 1) {

            if(num.length() - index == s)
                break;

            char cur = num.charAt(index);
            char nextChar = num.charAt(index + 1);

            char returned = cur != nextChar ? (char) Math.min(cur, nextChar) : cur;
            int newIndex = returned != cur || cur == nextChar ? index + 1 : index;

            if(lastIndexAdded == newIndex || s == 0) {
                newIndex = index+1;
                cur = s> 0 ? (char) Math.min(cur, nextChar) : nextChar;
                returned = cur;
            }

            boolean firstRemoved = returned != cur;
            if(firstRemoved && s > 0)
                s--;

            if(firstRemoved && smm.endsWith(""+ cur))
                smm = smm.substring(0, smm.length() - 1);

            if(lastIndexAdded != newIndex) {

                smm += returned;
                lastIndexAdded = newIndex;
            }

            index++;
        }

        return "" + Integer.parseInt(smm);
    }
}
