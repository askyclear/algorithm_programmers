package com.programmers.algorigm.year2022.month05;

public class StringToNumberConverter {
    public int solution(String s) {
        int sign = 0;
        if (!Character.isDigit(s.charAt(0))) {
            sign = Character.toString(s.charAt(0)).equals("-") ? -1 : 1;
        }

        if (sign == 0) {
            return Integer.parseInt(s);
        } else {
            return sign * Integer.parseInt(s.substring(1));
        }
    }
}
