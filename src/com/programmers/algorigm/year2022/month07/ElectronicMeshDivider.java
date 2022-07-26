package com.programmers.algorigm.year2022.month07;

import java.util.*;

public class ElectronicMeshDivider {
    public int solution(int n, int[][] wires) {
        int answer = 100;

        Map<Integer, List<Integer>> wireMap = new HashMap<>();

        for (int[] wire : wires) {
            List<Integer> wireInfo = wireMap.getOrDefault(wire[0], new ArrayList<>());
            wireInfo.add(wire[1]);
            wireMap.put(wire[0], wireInfo);

            List<Integer> wireInfo2 = wireMap.getOrDefault(wire[1], new ArrayList<>());
            wireInfo2.add(wire[0]);
            wireMap.put(wire[1], wireInfo2);
        }

        for (int[] wire : wires) {
            int n1 = bfs(wire[0], wire[1], n, wireMap);
            int n2 = bfs(wire[1], wire[0], n, wireMap);

            answer = Math.min(answer, Math.abs(n1 - n2));
        }

        return answer;
    }

    private int bfs(int v1, int v2, int n, Map<Integer, List<Integer>> wireMap) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        int cnt = 0;

        queue.add(v1);
        visit[v1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;

            for (int next : wireMap.get(cur)) {
                if (next != v2 && !visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }

        return cnt;
    }
}
