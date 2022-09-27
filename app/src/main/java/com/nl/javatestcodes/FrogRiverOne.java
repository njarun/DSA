package com.nl.javatestcodes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public static void main(String[] args) {

        int[] a = new int[]{1, 3, 1, 3, 2, 1, 3};
        int x = 3;

        int index = -1;
        Set<Integer> indexSet = new HashSet<Integer>();

        for(int i=0; i< a.length; i++) {

            indexSet.add(a[i]);

            if(indexSet.contains(x) && indexSet.size() == x) {

                boolean allArranged = true;

                for (int j = 0; j < indexSet.size(); j++) {

                    if(!indexSet.contains(j+1)) {

                        allArranged = false;
                        break;
                    }
                }

                if(allArranged) {

                    index = i;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println("x = " + x);
        System.out.println("Index = " + index);
    }
}
