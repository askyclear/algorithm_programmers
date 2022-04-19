package com.programmers.algorigm.year2022.month03;

import java.util.Arrays;

public class SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int[] betweenRockLengths = new int[rocks.length];
        Arrays.sort(rocks);
        betweenRockLengths[0] = rocks[0];

        for (int i = 1; i < rocks.length; i++) {
            betweenRockLengths[i] = rocks[i] - rocks[i - 1];
        }
        int left = 1;
        int right = distance;

        int currentLength;
        int removeCount;
        while(left <= right) {
            int mid = (left + right) / 2;
            currentLength = 0;
            removeCount = 0;
            for (int between : betweenRockLengths) {
                currentLength += between;
                if (currentLength < mid) {
                    removeCount++;
                } else {
                    currentLength = 0;
                }
            }
            if (removeCount > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            answer = (left + right) / 2;
        }

        return answer;
    }
}
