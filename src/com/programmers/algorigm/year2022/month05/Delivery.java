package com.programmers.algorigm.year2022.month05;

import java.util.*;

public class Delivery {
    private class Edge implements Comparable<Edge>{
        private int index;
        private int weight;
        Edge(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o. weight);
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Map<Integer, List<Edge>> info = new HashMap<>();

        for (int i = 0; i< road.length; i++) {
            int indexS = road[i][0];
            int indexE = road[i][1];
            List<Edge> edgesS = info.getOrDefault(indexS, new ArrayList<>());
            edgesS.add(new Edge(indexE, road[i][2]));
            info.put(indexS, edgesS);
            List<Edge> edgesE = info.getOrDefault(indexE, new ArrayList<>());
            edgesE.add(new Edge(indexS, road[i][2]));
            info.put(indexE, edgesE);
        }

        dijkstra(visited, distance, info, 1);
        for(int dist : distance) {
            if(dist <= K) {
                answer++;
            }
        }
        return answer;
    }
    private void dijkstra(boolean[] visited, int[] distance, Map<Integer, List<Edge>>  info, int start) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));
        distance[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int curIndex = edge.index;
            if(visited[curIndex]) {
                continue;
            } else {
                visited[curIndex] = true;
            }

            for(Edge nextInfo : info.getOrDefault(curIndex, new ArrayList<>())) {
                int nextIndex = nextInfo.index;

                if (distance[nextIndex] >= distance[curIndex] + nextInfo.weight) {
                    distance[nextIndex] = distance[curIndex] + nextInfo.weight;
                    Edge edge2 = new Edge(nextIndex, distance[nextIndex]);
                    priorityQueue.add(edge2);
                }
            }

        }
    }
}
