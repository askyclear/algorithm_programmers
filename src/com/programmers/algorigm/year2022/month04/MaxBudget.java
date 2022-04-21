package com.programmers.algorigm.year2022.month04;

import java.util.Arrays;

public class MaxBudget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int price : d) {
            if (price <= budget) {
                answer++;
                budget -= price;
            } else {
                break;
            }
        }

        return answer;
    }
}
