package com.programmers.algorigm.year2022.month06;

public class LineUp {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n];
        long nFact = 1;
        for (int i = 1; i < n; i++) {
            nFact *= i;
        }
        calc(answer, visited, n, k - 1, nFact);
        return answer;
    }

    private void calc(int[] answer, boolean[] visited, int n, long k, long nFact) {
        long nTh = (k / nFact) + 1;
        int number = 0;
        for (int i = 0; i < answer.length; i++) {
            if (!visited[i]) {
                number++;
            }
            if (!visited[i] && number == nTh) {
                visited[i] = true;
                answer[answer.length - n] = i + 1;
                break;
            }
        }
        if (n == 1) {
            return;
        }
        calc(answer, visited, n - 1, k % nFact, nFact / (n - 1));
    }
}
