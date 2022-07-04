package com.programmers.algorigm.year2022.month07;

public class ThreeNTiling {
    public int solution(int n) {
        if (n % 2 == 1) {
            return 0;
        }

        int answer = 0;
        int mod = 1000000007;
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] = dp[i] % mod;
        }

        answer = (int) dp[n];

        return answer;
    }
}
