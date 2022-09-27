package com.nl.tests;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 6, 7};
        int target = 7;

        System.out.println("Combinations = " +  combinationSum(arr, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();

        dfs(0, 0, candidates, target, curList, combList);

        return combList;
    }

    private static void dfs(int cur, int pos, int[] candidates, int target, List<Integer> curList, List<List<Integer>> combList) {

        if(cur == target) {
            combList.add(new ArrayList<>(curList));
            return;
        }

        if(pos >= candidates.length || cur > target) {
            return;
        }

        curList.add(candidates[pos]);
        dfs(cur + candidates[pos], pos, candidates, target, curList, combList);
        curList.remove(curList.size() - 1);

        dfs(cur, pos+1, candidates, target, curList, combList);
    }
}
