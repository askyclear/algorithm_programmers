package com.programmers.algorigm.year2022.month06;

public class NQueen {
    public int solution(int n) {
        int[] info = new int[n];

        return nQueen(0, info, n);
    }

    private int nQueen(int depth, int[] info, int n) {
        if (depth == n) {
            return 1;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            info[depth] = i;
            if (isPossible(info, depth)) {
                answer += nQueen(depth + 1, info, n);
            }
        }
        return answer;
    }

    private boolean isPossible(int[] info, int depth) {
        for (int i = 0; i < depth; i++) {
            if (info[depth] == info[i]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(info[depth] - info[i])) {
                return false;
            }
        }

        return true;
    }
}
