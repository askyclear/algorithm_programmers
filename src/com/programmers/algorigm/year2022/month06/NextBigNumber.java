package com.programmers.algorigm.year2022.month06;

public class NextBigNumber {
    public int solution(int n) {
        int oneCount = getConvertedDecimalTo2ThOneCount(n);
        int calCount = 0;
        while (oneCount != calCount) {
            calCount = getConvertedDecimalTo2ThOneCount(++n);
        }
        return n;
    }

    private int getConvertedDecimalTo2ThOneCount(int n) {
        int oneCount = 0;
        while (n > 0) {
            oneCount += (n % 2);
            n = n / 2;
        }
        return oneCount;
    }
}
