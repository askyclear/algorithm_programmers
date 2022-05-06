package com.programmers.algorigm.year2022.month05;

import java.util.Arrays;

public class DescendingOrderString {
    public String solution(String s) {
        char[] strChars = s.toCharArray();
        char[] reversChars = new char[strChars.length];
        Arrays.sort(strChars);
        int reverseIndex = strChars.length - 1;

        for (char strChar : strChars) {
            reversChars[reverseIndex--] = strChar;
        }

        return new String(reversChars);
    }
}
