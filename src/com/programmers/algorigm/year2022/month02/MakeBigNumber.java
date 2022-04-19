package com.programmers.algorigm.year2022.month02;

public class MakeBigNumber {
    public String solution(String number, int k) {
        if (number.length() == k) {
            return "";
        }

        char maxDigitNumber = 0;
        int maxDigitIndex = 0;
        int remainK = k;

        for (int i = 0; i<= k; i++) {
            char temp = number.charAt(i);

            if (temp > maxDigitNumber) {
                maxDigitNumber = temp;
                maxDigitIndex = i;
            }
        }

        remainK -= maxDigitIndex;
        if (remainK == 0) {
            return number.substring(maxDigitIndex);
        } else {
            return maxDigitNumber + solution(number.substring(maxDigitIndex + 1), remainK);
        }
    }
}
