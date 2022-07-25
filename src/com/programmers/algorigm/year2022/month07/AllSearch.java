package com.programmers.algorigm.year2022.month07;

import java.util.HashMap;
import java.util.Map;

public class AllSearch {
    private static final Map<String, Integer> dir = new HashMap<>();
    static {
        dir.put("A", 0);
        dir.put("E", 1);
        dir.put("I", 2);
        dir.put("O", 3);
        dir.put("U", 4);
    }

    public int solution(String word) {
        int answer = 0;
        int[] dp = new int[]{0, 5, 30, 155, 780};
        for(int i = 0; i < word.length(); i++) {
            String ch = Character.toString(word.charAt(i));
            answer += dp[4 - i] * dir.get(ch) +  dir.get(ch) + 1;

        }
        return answer;
    }
}
