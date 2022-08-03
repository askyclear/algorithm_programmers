package com.programmers.algorigm.year2022.month08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LightPathCycle {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    private int width;
    private int height;

    public int[] solution(String[] grid) {

        List<Integer> lightLengthList = new ArrayList<>();
        width = grid[0].length();
        height = grid.length;

        boolean[][][] visit = new boolean[height][width][4];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visit[i][j][d]) {
                        lightLengthList.add(getLightLen(grid, visit, i, j, d));
                    }
                }
            }
        }
        int[] answer = new int[lightLengthList.size()];

        Collections.sort(lightLengthList);

        for (int i = 0; i < answer.length; i++) answer[i] = lightLengthList.get(i);

        return lightLengthList.stream().mapToInt(value -> value).toArray();
    }

    private int getLightLen(String[] grid, boolean[][][] visit, int y, int x, int direction) {
        int cnt = 0;
        while (!visit[y][x][direction]) {
            cnt++;
            visit[y][x][direction] = true;
            if (grid[y].charAt(x) == 'R') {
                direction = getDirection(direction + 1);
            } else if (grid[y].charAt(x) == 'L') {
                direction = getDirection(direction - 1);
            }

            x = (x + dx[direction] + width) % width;
            y = (y + dy[direction] + height) % height;
        }

        return cnt;
    }

    private int getDirection(int direction) {
        return direction < 0 ? 3 : direction % 4;
    }
}
