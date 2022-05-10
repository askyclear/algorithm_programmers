package com.programmers.algorigm.year2022.month05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortedNumber {
    public long solution(long n) {
        long answer = 0;
        List<Long> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        digits.sort(Comparator.reverseOrder());

        for (long digit : digits) {
            answer = answer * 10 + digit;
        }

        return answer;
    }

}
