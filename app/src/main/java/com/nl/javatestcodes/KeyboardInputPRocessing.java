package com.nl.javatestcodes;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("NewApi")
public class KeyboardInputPRocessing {

    public static void main(String[] args) {

        String string = "aCaBBCCCab";

        List<String> list = new ArrayList<>();
        for (int i=0; i<string.length(); i++) {
            list.add(String.valueOf(string.charAt(i)));
        }

        StringBuilder formattedStr = new StringBuilder();
        boolean capsStated = false;

        for(int i=0; i< list.size(); i++) {

            String actionOrChar = list.get(i);
            String nextChar = "";

            if(actionOrChar.equals("C")) {

                if(capsStated) {
                    capsStated = false;
                    continue;
                }

                capsStated = true;

                if(i < list.size() - 1) {

                    nextChar = list.get(i+1);

                    if(!nextChar.equals("C")) {

                        nextChar = nextChar.toUpperCase();
                        formattedStr.append(nextChar);
                        i++;
                    }
                }
            }
            else if(actionOrChar.equals("B")) {

                if(formattedStr.length() > 0)
                    formattedStr.deleteCharAt(formattedStr.length() - 1);
            }
            else {

                nextChar = capsStated ? actionOrChar.toUpperCase() : actionOrChar;
                formattedStr.append(nextChar);
            }
        }

        System.out.println("formattedStr - " + formattedStr);
    }
}
