package com.programmers.algorigm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long minTime = 1;
        long maxTime = (long)times[times.length - 1] * (long)n;

        while (minTime <= maxTime) {
            long midTime = (minTime + maxTime) / 2;
            long people = 0;
            for (int time : times) {
                people += midTime / time;
                if (people >= n) {
                    break;
                }
            }
            if (people >= n) {
                answer = midTime;
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }

        return answer;
    }
    public long solution1(int n, int[] times) {
        long answer = 0;
        PriorityQueue<ImmigrationInformation> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.finishTime + o1.time > o2.finishTime + o2.time ? 1 : 0);

        for(int time : times) {
            priorityQueue.add(new ImmigrationInformation(time, 0));
        }

        for (int i = 0; i < n; i++) {
            ImmigrationInformation information = priorityQueue.poll();
            answer = information.time + information.finishTime;
            information.finishTime = answer;
            priorityQueue.add(information);
        }

        return answer;
    }

    class ImmigrationInformation {
        long time;
        long finishTime;
        ImmigrationInformation(long time, long finishTime) {
            this.time = time;
            this.finishTime = finishTime;
        }
    }
}
