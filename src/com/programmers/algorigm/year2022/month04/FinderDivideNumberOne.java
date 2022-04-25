package com.programmers.algorigm.year2022.month04;

public class FinderDivideNumberOne {
    public int solution(int n) {
        int answer = n - 1;
        int sqrt = (int) Math.sqrt(n - 1);
        for (int i = 2; i <= sqrt; i++) {
            if ((n - 1) % i == 0) {
                answer = Math.min(answer, i);
            }
        }

        return answer;
    }
}
