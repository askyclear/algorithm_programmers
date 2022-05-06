package com.programmers.algorigm.year2022.month05;

public class FindPrimeNumber {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {

            if (isPrimeNumber(i)) {
                answer++;
            }
        }
        return answer++;
    }

    private boolean isPrimeNumber(int n) {
        int nSqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= nSqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
