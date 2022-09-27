package com.nl.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LineCorpTest {

    public static void NumberShuffling(String[] args) {

        int a = 332; //-162534

        StringBuilder newNum = new StringBuilder(a>0 ? "" : "-");
        String num = String.valueOf(Math.abs(a));
        List<String> numList = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            numList.add("" + num.charAt(i));
        }

        for (int i = 0; i < numList.size()/2; i++) {
            newNum.append(numList.get(i)).append(numList.get(numList.size() - i - 1));
        }

        if(numList.size() %2 != 0) {
            newNum.append(numList.get((numList.size()/2)));
        }

        //Arrays.toString(a)

        a = Integer.parseInt(newNum.toString());

        System.out.println("a - " + a);
    }

    public static void FlightFamilySeatAllocation(String[] args) {

        int n = 4;
        String s = "1A 2F 1C 3C 4G 3H";

        int familySeats = n*2;

        if(s.trim().length() > 0) {

            Map<Integer, Set<String>> reservationMap = new TreeMap<>();

            Set<String> resSeatSet = new HashSet<>(Arrays.asList(s.split(" ")));

            List<String> resSeatList = new ArrayList<>(resSeatSet);

            for (int i = 0; i < resSeatList.size(); i++) {

                String reservation = resSeatList.get(i);
                int seatIndex = Integer.parseInt("" + reservation.charAt(0));
                String seat = "" + reservation.charAt(1);

                Set<String> seatSetForRow = reservationMap.get(seatIndex);
                if (seatSetForRow == null) {
                    seatSetForRow = new TreeSet<>();
                }

                seatSetForRow.add(seat);
                reservationMap.put(seatIndex, seatSetForRow);
            }

            for (int i = 0; i < n; i++) {

                int seatRow = i + 1;
                Set<String> seatSetForRow = reservationMap.get(seatRow);

                if (seatSetForRow == null) {
                    continue;
                }

                if (!seatSetForRow.contains("D") &&
                        !seatSetForRow.contains("E") &&
                        !seatSetForRow.contains("F") &&
                        !seatSetForRow.contains("G")) {

                    if (seatSetForRow.contains("B") ||
                            seatSetForRow.contains("C") ||
                            seatSetForRow.contains("H") ||
                            seatSetForRow.contains("J")) {

                        familySeats = familySeats - 1;
                    }
                }
                else if (seatSetForRow.contains("F") ||
                        seatSetForRow.contains("G")) {

                    familySeats = familySeats - 1;

                    if (seatSetForRow.contains("B") ||
                            seatSetForRow.contains("C") ||
                            seatSetForRow.contains("D") ||
                            seatSetForRow.contains("E")) {

                        familySeats = familySeats - 1;
                    }
                }
                else if (seatSetForRow.contains("D") ||
                        seatSetForRow.contains("E")) {

                    familySeats = familySeats - 1;

                    if (seatSetForRow.contains("F") ||
                            seatSetForRow.contains("G") ||
                            seatSetForRow.contains("H") ||
                            seatSetForRow.contains("J")) {

                        familySeats = familySeats - 1;
                    }
                }
            }
        }

        System.out.println("familySeats - " + familySeats);
    }

    static int maxPartitions(int[] arr, int n) {

        int ans = 0, max_so_far = 0;
        for (int i = 0; i < n; ++i) {

            // Find maximum in prefix arr[0..i]
            max_so_far = Math.max(max_so_far, arr[i]);

            // If maximum so far is equal to index, we can
            // make a new partition ending at index i.
            if (max_so_far == i)
                ans++;
        }
        return ans;
    }

    // Driver code
    public static void main(String[] args) {

        int[] arr = {2, 1, 6, 4, 3, 7}; //{2, 4, 1, 6, 5, 9, 7};//{4, 3, 2, 6, 1};
        System.out.println(countGroups(arr));
    }

    public static int countGroups(int[] a) {

        int slices = 0;

        if(a.length == 0) {

            slices = 0;
        }
        else if(a.length == 1) {

            slices = 1;
        }
        else {

            List<Integer> nextSetItem = new ArrayList<>();

            for (int i=1; i<a.length; i++) {

                if (a[i-1] <= a[i]) {
                    nextSetItem.add(i);
                }

                for (int j=i; j>0 && a[j-1] > a[j]; j--) {

                    int k = a[j];
                    a[j] = a[j-1];
                    a[j-1] = k;

                    if (nextSetItem.size() > 0 && nextSetItem.get(nextSetItem.size() - 1) >= j)
                        nextSetItem.remove(nextSetItem.size() - 1);
                }
            }

            slices = nextSetItem.size() + 1;
        }

        return slices;
    }

    /*
    public static void main(String[] args)
    {
        int a[] = new int[]{4, 3, 2, 6, 1}; //{2, 1, 6, 4, 3, 7};
        int slices = a.length == 0 ? 0 : 1;

        if(a.length > 2) {

            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 1; i < a.length; i++) {

                if (a[i] >= a[i - 1]) stack.push(i);

                for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {

                    int Temp = a[j];
                    a[j] = a[j - 1];
                    a[i] = Temp;

                    if (j <= stack.peek()) stack.pop();
                }
            }

            slices = stack.size();
        }

        System.out.println(slices);
    }
     */
}
