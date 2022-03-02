package com.programmers.algorigm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IslandConnection {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < costs.length; i++) {
            priorityQueue.add(costs[i]);
        }

        while (!priorityQueue.isEmpty()) {
            int[] info = priorityQueue.poll();
            if (findParent(info[0], parent) != findParent(info[1], parent)) {
                parent = union(info, parent);
                answer += info[2];
            }
        }
        return answer;
    }

    public int[] union(int[] info, int[] parent) {
        int startParent = findParent(info[0], parent);
        int endParent = findParent(info[1], parent);
        if (startParent < endParent) {
            parent[endParent] = startParent;
        } else {
            parent[startParent] = endParent;
        }
        return parent;
    }

    public int findParent(int position, int[] parent) {
        if (parent[position] == position) {
            return position;
        }

        return findParent(parent[position], parent);
    }
}
