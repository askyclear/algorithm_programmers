package com.programmers.algorigm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        int[] nodeLengths = new int[n + 1];
        nodeLengths[1] = 1;

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(1);

        while (!bfsQueue.isEmpty()) {
            int currentNode = bfsQueue.poll();

            for (int i = 0; i < edge.length; i++) {
                if (currentNode == edge[i][0] && nodeLengths[edge[i][1]] == 0) {
                    nodeLengths[edge[i][1]] = nodeLengths[currentNode] + 1;
                    bfsQueue.add(edge[i][1]);
                }
                if (currentNode == edge[i][1] && nodeLengths[edge[i][0]] == 0) {
                    nodeLengths[edge[i][0]] = nodeLengths[currentNode] + 1;
                    bfsQueue.add(edge[i][0]);
                }
            }
        }

        Arrays.sort(nodeLengths);
        int max = nodeLengths[nodeLengths.length - 1];

        for (int i = n; i >= 0; i--) {
            if (nodeLengths[i] < max) {
                break;
            }
            answer++;
        }

        return answer;
    }
}
