package com.programmers.algorigm.year2022.month04;

public class DivisorSum {
    public int solution(int n) {
        int answer = 0;
        int sqrt = (int)Math.sqrt(n);
        for (int i = 1; i<=sqrt; i++) {
            if (n % i == 0) {
                answer+= i;
                if (n / i != i) {
                    answer+= (n / i);
                }
            }
        }
        return answer;
    }
}
