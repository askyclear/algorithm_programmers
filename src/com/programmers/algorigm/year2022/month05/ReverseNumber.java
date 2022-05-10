package com.programmers.algorigm.year2022.month05;

import java.util.ArrayList;
import java.util.List;

public class ReverseNumber {
    public int[] solution(long n) {
        List<Integer> answer = new ArrayList<>();

        while (n > 0) {
            answer.add((int) (n % 10));
            n = n / 10;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
