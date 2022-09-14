package com.programmers.algorigm.year2022.month08;

import java.util.Arrays;

public class ArithmeticOperation {
    public int solution(String arr[]) {
        int operandCount = (int) Math.ceil(arr.length / 2);
        int[][] max_dp = new int[operandCount][operandCount];
        int[][] min_dp = new int[operandCount][operandCount];

        for (int i = 0; i < operandCount; i++) {
            Arrays.fill(max_dp[i], Integer.MIN_VALUE);
            Arrays.fill(min_dp[i], Integer.MAX_VALUE);
            int parsedNumber = Integer.parseInt(arr[i * 2]);;
            max_dp[i][i] = parsedNumber;
            min_dp[i][i] = parsedNumber;
        }

        for(int cnt = 1; cnt < operandCount; cnt++) {
            for(int i = 0; i < operandCount - cnt; i++) {
                int j = i + cnt;
                for(int k = i; k < j; k++) {
                    // 연산자의 위치를 구하는 인덱스 값에 주의
                    if(arr[k * 2 + 1].equals("+")) {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);
                    } else {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                    }
                }
            }
        }

        return max_dp[0][operandCount-1];
    }
}
