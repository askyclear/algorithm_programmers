package com.programmers.algorigm.year2022.month07;

public class NSquaredArray {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0; i < answer.length; i++) {
            long index = left + i + 1;
            if (index % n == 0) {
                answer[i] = n;
            } else {
                answer[i] = (int) Math.max(index / n + 1, index % n);
            }
        }

        return answer;
    }

}
