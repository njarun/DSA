package com.nl.javatestcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBillCalculator {

    public static void main(String[] args) {

        String bill = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";

        List<String> billList = new ArrayList<>(Arrays.asList(bill.split("\n")));

        List<String> phoneBillList = new ArrayList<>();
        String topBilledNum = null;

        Map<String, Integer> totalMinForNum = new HashMap<>();

        for (int i = 0; i < billList.size(); i++) {

            String nextBill = billList.get(i);
            String[] timePhoneArr = nextBill.split(",");
            String timeStr = timePhoneArr[0];
            String phoneStr = timePhoneArr[1];

            String[] timeArr = timeStr.split(":");
            int h = Integer.parseInt(timeArr[0]);
            int m = Integer.parseInt(timeArr[1]);
            int s = Integer.parseInt(timeArr[2]);

            int totalMin = m + (h * 60);
            int totalSec = s + (totalMin * 60);

            int billForCall = 0;

            if(totalSec < 300) { //less than 5 mins

                billForCall += (totalSec*3);
            }
            else {

                int standardMins = s == 0 ? totalMin : (totalMin+1);
                billForCall += (standardMins*150);
            }

            Integer totalCallMinsForNum = totalMinForNum.get(phoneStr);
            int totalDuration = totalCallMinsForNum == null ? billForCall : billForCall + totalCallMinsForNum;
            totalMinForNum.put(phoneStr, totalDuration);

            Integer max = topBilledNum != null ? totalMinForNum.get(topBilledNum) : null;
            if(max == null)
                max = 0;

            phoneBillList.add(phoneStr + "___" + billForCall);

            if(topBilledNum == null || totalDuration > max) {

                topBilledNum = phoneStr;
            }
            else if(max == totalDuration && !topBilledNum.equals(phoneStr)) {

                int currentPhoneSum = getSumOfPhoneNum(phoneStr);
                int topPhoneSum = getSumOfPhoneNum(topBilledNum);

                topBilledNum = currentPhoneSum > topPhoneSum ? topBilledNum : phoneStr;
            }
        }

        int totalBill = 0;

        for (String phoneBillStr: phoneBillList) {

            if(phoneBillStr.startsWith(topBilledNum)) { //Promotion - Free call number

                continue;
            }
            else {

                totalBill += Integer.parseInt(phoneBillStr.split("___")[1]);
            }
        }

        System.out.println("totalBill - " + totalBill);
    }

    public static int getSumOfPhoneNum(String phoneNum) {

        int phoneNumSum = 0;

        String[] phoneArr = phoneNum.split("-");
        for (String num: phoneArr) {
            phoneNumSum += Integer.parseInt(num);
        }

        return phoneNumSum;
    }
}
