package com.programmers.algorigm.year2022.month02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DualPriortyQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> ascQueue = new PriorityQueue<>();
        PriorityQueue<Integer> descQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(String operation : operations) {
            String[] splitOperation = operation.split(" ");
            Integer value = Integer.parseInt(splitOperation[1]);
            if (splitOperation[0].equals("I")) {
                ascQueue.add(value);
                descQueue.add(value);
            } else if (!ascQueue.isEmpty()){
                if (value > 0) {
                    int removeValue = descQueue.poll();
                    ascQueue.remove(removeValue);
                } else {
                    int removeValue = ascQueue.poll();
                    descQueue.remove(removeValue);
                }
            }
        }

        if (ascQueue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{ascQueue.poll(), descQueue.poll()};
        }
    }
}
