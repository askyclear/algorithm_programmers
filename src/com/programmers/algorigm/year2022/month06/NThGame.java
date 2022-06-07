package com.programmers.algorigm.year2022.month06;

public class NThGame {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int curDecimal = 0;
        int curPosition = 1;
        while (answer.length() < t) {
            String convertN = convertToN(n, curDecimal);

            for (int i = 0; i < convertN.length(); i++) {
                String temp = "";
                if (answer.length() == t) {
                    break;
                }
                if (curPosition % m == 0 && m == p) {
                    temp = Character.toString(convertN.charAt(i));
                } else if (curPosition % m == p) {
                    temp = Character.toString(convertN.charAt(i));
                }
                answer = answer + temp;
                curPosition++;
            }
            curDecimal++;
        }
        return answer;
    }

    public String convertToN(int n, int decimal) {
        if (decimal == 0) {
            return "0";
        }
        int current = decimal;
        String kString = "";
        while (current > 0) {
            if (current % n < 10) {
                kString = (current % n) + kString;
            } else {
                kString = (char) ("A".charAt(0) + current % n - 10) + kString;
            }
            current = current / n;
        }
        return kString;
    }
}
