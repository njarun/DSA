package com.nl.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {

        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> flowList = pacificAtlantic(heights);
        System.out.println("Flow list - " + flowList);
    }

    public ArrayList<Integer> findingMinMax(ArrayList<Integer> arr) {

        /*Collections.sort(arr);
        return new ArrayList<>(Arrays.asList(arr.get(0), arr.get(arr.size() - 1)));*/

        ArrayList<Integer> maxMinArr = (ArrayList<Integer>) Arrays.asList(arr.get(0), arr.get(0));

        if(arr.size() < 2)
            return maxMinArr;

        for(int i=0; i<arr.size(); i++) {

            maxMinArr.set(0, Math.max(maxMinArr.get(0), arr.get(i)));
            maxMinArr.set(1, Math.min(maxMinArr.get(1), arr.get(i)));
        }

        return maxMinArr;
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        Map<Integer, List<Integer>> routeMap = new HashMap<>();
        int index = 0;

        List<List<Integer>> routeList = new ArrayList<>();

        int r = heights.length;
        int c = heights[0].length;

        dfs(r, c, index, heights, routeMap, routeList);

        return routeList;
    }

    private static void dfs(int r, int c, int index, int[][] heights, Map<Integer,
            List<Integer>> routeMap, List<List<Integer>> routeList) {

        if(routeMap.containsKey(index)) {
            routeList.add(routeMap.get(index));
            return;
        }
    }
}