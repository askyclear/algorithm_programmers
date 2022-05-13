package com.programmers.algorigm.year2022.month05;

public class ColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int[] answer = new int[2];
        long[][] copiedPicture = new long[m][n];
        for (int i =0; i< m; i++) {
            for(int j = 0; j < n; j++) {
                copiedPicture[i][j] = picture[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && copiedPicture[i][j] != 0) {
                    answer[0] = answer[0] + 1;
                    answer[1] = Math.max(answer[1], dfs(copiedPicture, visited, i, j, copiedPicture[i][j]));
                }
            }
        }


        return answer;
    }

    private int dfs(long[][] picture, boolean[][] visited, int m, int n, long color) {
        if (visited[m][n] || picture[m][n] != color) {
            return 0;
        }
        visited[m][n] = true;

        return 1 + dfs(picture, visited, m, Math.max(0, n - 1), color)
                + dfs(picture, visited, Math.min(picture.length - 1, m + 1), n, color)
                + dfs(picture, visited, Math.max(0, m - 1), n, color)
                + dfs(picture, visited, m, Math.min(picture[0].length - 1, n + 1), color);
    }
}
