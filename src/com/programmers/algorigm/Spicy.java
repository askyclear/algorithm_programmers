package com.programmers.algorigm;

import java.util.PriorityQueue;
import java.util.Queue;

public class Spicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i =0; i< scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        while (!priorityQueue.isEmpty()) {
            int minScoville = priorityQueue.poll();
            if (minScoville >= K) {
                break;
            } else {
                if(priorityQueue.isEmpty()) {
                    answer = -1;
                } else {
                    int secondMinScoville = priorityQueue.poll();
                    priorityQueue.add(minScoville + (secondMinScoville * 2));
                    answer++;
                }
            }
        }

        return answer;
    }
}
