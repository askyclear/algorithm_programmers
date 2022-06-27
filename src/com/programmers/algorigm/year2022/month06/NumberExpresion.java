package com.programmers.algorigm.year2022.month06;

public class NumberExpresion {
    public int solution(int n) {
        int answer = 1;
        for (int i = 1; i < n; i++) {
            int sum = i;
            for (int j = i + 1; sum < n; j++) {
                sum+=j;
            }
            if (sum == n) {
                answer++;
            }
        }
        return answer;
    }

}
