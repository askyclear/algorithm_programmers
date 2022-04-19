package com.programmers.algorigm.year2022.month03;

public class WordChange {
    private static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        return dfs(begin, target, words, 0);
    }

    public int dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            return cnt;
        }

        int answer = 0;

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int sameCount = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    sameCount++;
                }
            }

            if (sameCount == begin.length() - 1) {
                visited[i] = true;
                answer = dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }

        return answer;
    }
}
