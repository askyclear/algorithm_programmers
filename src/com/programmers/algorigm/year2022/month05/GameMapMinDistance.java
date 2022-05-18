package com.programmers.algorigm.year2022.month05;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapMinDistance {
    private final int[] dX = {1, 0, -1, 0};
    private final int[] dY = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];

        bfs(maps, visited);

        return visited[n - 1][m - 1] == 0 ? -1 : visited[n - 1][m - 1];
    }

    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nX = currentX + dX[i];
                int nY = currentY + dY[i];

                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1)
                    continue;
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[currentX][currentY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }
        }
    }
}
