package com.nl.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {

        String s = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));

        /*String s = "neetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("neet", "code"));*/

        System.out.println(s + "can be segmented = " +  wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[dp.length -1] = true;

        for (int i = s.length() - 1; i >= 0; i--) {

            for (String word: wordDict) {

                if(i+ word.length() <= s.length() && s.startsWith(word, i)) {
                    dp[i] = dp[i + word.length()];
                }

                if(dp[i])
                    break;
            }
        }

        return dp[0];
    }

    public static boolean wordBreakIReadWrong(String s, List<String> wordDict) {

        boolean mismatchFound = false;
        Set<String> brokenWordsSet = new HashSet<>();

        for (String word: wordDict) {

            if(s.contains(word)) {

                s = s.replaceAll(word, "");
                brokenWordsSet.add(word);
            }
            else {

                for (String brokenWords: brokenWordsSet) {

                    if(!brokenWords.contains(word)) {
                        mismatchFound = true;
                        break;
                    }
                }
            }
        }

        if(!mismatchFound && s.length() > 0){
            mismatchFound = true;
        }

        return !mismatchFound;
    }
}
