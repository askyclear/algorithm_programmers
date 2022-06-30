package com.programmers.algorigm.year2022.month06;

public class NumberBlock {
    public int[] solution(long begin, long end) {
        int length = (int) (end - begin) + 1;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = maxAaa(begin + i);
        }

        return answer;
    }

    private int maxAaa(long number) {
        if (number == 1) {
            return 0;
        }
        int sqrt = (int) Math.sqrt(number);
        int answer = 1;

        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0 && number / i <= 10000000) {
                return (int) (number / i);
            }
        }

        return answer;
    }
}
