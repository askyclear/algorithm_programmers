package com.programmers.algorigm.year2022.month07;

public class DifferenceBit {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < answer.length; i++) {
            long orderNumber = numbers[i] + 1;

            answer[i] = orderNumber + ((orderNumber ^ numbers[i]) >> 2);
        }

        return answer;
    }
}
