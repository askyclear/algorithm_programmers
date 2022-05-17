package com.programmers.algorigm.year2022.month05;

public class DistanceCofirm {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            boolean[][] visited = new boolean[5][5];
            answer[i] = dfs(0,0,places[i], visited, 0) ? 1 : 0;
        }
        return answer;
    }

    public boolean dfs(int x, int y, String[] place, boolean[][] visited, int distance) {
        if (visited[x][y]) {
            return true;
        }
        visited[x][y] = true;
        String pos = Character.toString(place[x].charAt(y));
        if (pos.equals("P")) {
            if (distance <= 2) {
                return false;
            }
            return dfs(x, Math.min(y + 1, 4), place, visited, 1)
                    && dfs(Math.min(x + 1, 4), y, place, visited, 1)
                    && dfs(Math.max(x - 1, 0), y, place, visited, 1)
                    && dfs(x, Math.max(y - 1, 0), place, visited, 1);
        } else if (pos.equals("O") && distance >= 1) {
            return dfs(x, Math.min(y + 1, 4), place, visited, distance + 1)
                    && dfs(Math.min(x + 1, 4), y, place, visited, distance + 1)
                    && dfs(Math.max(x - 1, 0), y, place, visited, distance + 1)
                    && dfs(x, Math.max(y - 1, 0), place, visited, distance + 1);
        } else {
            return dfs(x, Math.min(y + 1, 4), place, visited, 0)
                    && dfs(Math.min(x + 1, 4), y, place, visited, 0)
                    && dfs(Math.max(x - 1, 0), y, place, visited, 0)
                    && dfs(x, Math.max(y - 1, 0), place, visited, 0);
        }
    }
}
