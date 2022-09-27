package com.nl.javatestcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddOccurrencesInArray {

    public static void main(String[] args) {

        int[] a = new int[]{9,3,9,3,9,7,9};
        int unpairedNum = -1;

        Map<Integer, List<Integer>> numIndexPairMap = new HashMap<>();

        for(int i=0; i < a.length; i++) {

            int num = a[i];
            List<Integer> indexList = numIndexPairMap.get(num);

            if(indexList == null)
                indexList = new ArrayList<>();

            indexList.add(i);

            numIndexPairMap.put(num, indexList);
        }

        for(Map.Entry<Integer, List<Integer>> entry : numIndexPairMap.entrySet()) {

            if(entry.getValue().size()%2 != 0) {
                unpairedNum = entry.getKey();
                break;
            }
        }

        System.out.println("unpairedNum - " + unpairedNum);
    }
}
