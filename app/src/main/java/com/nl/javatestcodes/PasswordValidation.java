package com.nl.javatestcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {

    /*public static boolean main(String args[]) {

        boolean isValid = true;

        String password = "FooBar123!";

        Set<String> specialChars = new HashSet<>();
        specialChars.add("!");
        specialChars.add("@");
        specialChars.add("#");
        specialChars.add("$");
        specialChars.add("%");
        specialChars.add("^");
        specialChars.add("&");
        specialChars.add("*");
        specialChars.add("(");
        specialChars.add(")");
        specialChars.add("_");

        if(password.length() < 6) {

            isValid = false;
        }
        else {

            int digitCount = 0;
            int uCharCount = 0;
            int lCharCount = 0;


            for (int i=0; i<password.length(); i++) {

                String pChar = String.valueOf(password.charAt(i));

                if(pChar.equals(" ")) {

                    isValid = false;
                    break;
                }
                else if()
            }

            if(isValid) {


            }
        }


        return isValid;
    }*/

    public static void main(String[] args) {

        String password = "FooBar123!";

        boolean isValid = true;

        if(password.contains(" ")) {

            isValid = false;
        }
        else {

            /*String regex = "(?=\\S+$).{6,}" +
                    "^(?=.*[0-9])" +
                    "(?=.*[a-z])(?=.*[A-Z])" +
                    "(?=.*[!@#$%^&*()_])$";*/

            String regex = "^(?=.*[0-9])"
                    + "(?=.*[!@#$%^&*()_])"
                    + "(?=.*[A-Z])(?=.*[a-z])"
                    + "(?=\\S+$).{6,}$";

            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(password);
            isValid = m.matches();
        }

        System.out.println("isValid - " + isValid);
    }
}
