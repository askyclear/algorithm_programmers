package com.programmers.algorigm.year2022.month05;

public class MaxMin {
    public int[] solution(int n, int m) {
        int[] answer = new int[]{1,1};
        int length = Math.min(n, m);
        for (int i = 1; i<= length; i++ ) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }
        answer[1] = n * m / answer[0];
        return answer;
    }
}
