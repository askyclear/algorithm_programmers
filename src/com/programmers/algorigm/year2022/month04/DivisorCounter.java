package com.programmers.algorigm.year2022.month04;

public class DivisorCounter {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <=right; i++) {
            answer = getDivisorCount(i) % 2 ==0 ? answer + i : answer - i;
        }

        return answer;
    }

    public int getDivisorCount(int num) {
        int sqrt = (int) Math.sqrt(num);
        int divisorCount = 0;

        for (int i = 1; i <= sqrt; i++) {
            if (num % i == 0) {
                divisorCount++;
                if(num / i != i) {
                    divisorCount++;
                }
            }
        }

        return divisorCount;
    }
}
