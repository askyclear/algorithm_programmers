package com.programmers.algorigm.year2022.month05;

public class NumberOfPAndYInString {
    boolean solution(String s) {
        int yCount = 0;
        int pCount = 0;

        for(int i = 0; i < s.length(); i++) {
            String subStr = s.substring(i, i + 1);
            if (subStr.toUpperCase().equals("P")) {
                pCount++;
            } else if (subStr.toUpperCase().equals("Y")) {
                yCount++;
            }
        }

        return yCount == pCount;
    }
}
