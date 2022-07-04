package com.programmers.algorigm.year2022.month07;

public class MaximumSquareFinder {
    public int solution(int[][] board) {
        int answer = board[0][0];
        int widhtMax = board[0].length;
        int heightMax = board.length;

        for (int i = 0; i < heightMax; i++) {
            for (int j = 0; j < widhtMax; j++) {
                if (board[i][j] == 1 && i - 1 >= 0 && j - 1 >= 0) {
                    int upArea = board[i - 1][j];
                    int leftArea = board[i][j - 1];
                    int diagonalArea = board[i - 1][j - 1];
                    int curLength = (int) Math.min(Math.min(Math.sqrt(upArea), Math.sqrt(leftArea)), Math.sqrt(diagonalArea));
                    board[i][j] = (int) Math.pow(curLength + 1, 2);
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return answer;
    }
}
