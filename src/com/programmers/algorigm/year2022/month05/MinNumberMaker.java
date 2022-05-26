package com.programmers.algorigm.year2022.month05;

import java.util.Arrays;

public class MinNumberMaker {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int length = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < length; i++) {
            answer = answer + A[i] * B[length - 1 - i];
        }

        return answer;
    }
}
