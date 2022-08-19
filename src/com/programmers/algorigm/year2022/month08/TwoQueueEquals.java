package com.programmers.algorigm.year2022.month08;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueEquals {
    public int solution(int[] queue1, int[] queue2) {
        long maxInsertCount = queue1.length * 2L + 2;
        long queue1TotalSum = 0;
        long queue2TotalSum = 0;

        Queue<Integer> copyedQueue1 = new LinkedList<>();
        Queue<Integer> copyedQueue2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            queue1TotalSum += queue1[i];
            queue2TotalSum += queue2[i];
            copyedQueue1.add(queue1[i]);
            copyedQueue2.add(queue2[i]);
        }

        int answer = 0;

        while (answer < maxInsertCount) {
            if (queue1TotalSum == queue2TotalSum) {
                return answer;
            }
            if (queue1TotalSum < queue2TotalSum) {
                if (copyedQueue2.isEmpty()) {
                    return -1;
                }
                int peekValue = copyedQueue2.poll();
                queue1TotalSum += peekValue;
                queue2TotalSum -= peekValue;
                copyedQueue1.add(peekValue);
            } else {
                if (copyedQueue1.isEmpty()) {
                    return -1;
                }
                int peekValue = copyedQueue1.poll();
                queue1TotalSum -= peekValue;
                queue2TotalSum += peekValue;
                copyedQueue2.add(peekValue);
            }
            answer++;
        }

        return -1;
    }
}
