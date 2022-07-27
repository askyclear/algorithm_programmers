package com.programmers.algorigm.year2022.month07;

public class Fatigue {
    public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];

        return dfs(0, k, dungeons, visit);
    }

    public int dfs(int depth, int k, int[][] dungeons, boolean[] visit) {
        int answer = depth;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                answer = Math.max(answer, dfs(depth + 1, k - dungeons[i][1], dungeons, visit));
                visit[i] = false;
            }
        }

        return answer;
    }
}
