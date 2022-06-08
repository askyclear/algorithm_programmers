package com.programmers.algorigm.year2022.month06;

public class Friends4Block {
    private int maxX;
    private int maxY;
    private char[][] curBoard;

    public int solution(int m, int n, String[] board) {
        int totalDeleteCount = 0;
        maxX = n;
        maxY = m;
        curBoard = new char[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            curBoard[i] = board[i].toCharArray();
        }
        int deletedBlockCount = 0;
        do {
            boolean[][] deleteTarget = new boolean[maxY][maxX];

            for (int y = 0; y < maxY; y++) {
                for (int x = 0; x < maxX; x++) {
                    if (curBoard[y][x] != ' ') {
                        isDeleteTarget(x, y, deleteTarget);
                    }
                }
            }

            deletedBlockCount = deleteBlock(deleteTarget);
            totalDeleteCount += deletedBlockCount;
        } while (deletedBlockCount > 0);

        return totalDeleteCount;
    }

    private int deleteBlock(boolean[][] deleteTarget) {
        int deleteCount = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y <maxY; y++) {
                if(deleteTarget[y][x]) {
                    deleteCount++;
                    for (int i = y; i >= 0; i--) {
                        if (i == 0) {
                            curBoard[i][x] = ' ';
                        } else {
                            curBoard[i][x] = curBoard[i - 1][x];
                        }
                    }
                }
            }
        }

        return deleteCount;
    }

    public void isDeleteTarget(int x, int y, boolean[][] deleteTarget) {
        int[] dx = {0, 0, 1, 1}, dy = {0, 1, 0, 1};
        boolean isDeleted = true;
        for (int i = 1; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isCheckRange(nx, ny) || curBoard[y][x] != curBoard[ny][nx]) {
                isDeleted = false;
                break;
            }
        }

        if (!isDeleted) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            deleteTarget[ny][nx] = true;
        }
    }

    private boolean isCheckRange(int nx, int ny) {
        return nx >= 0 && nx < maxX && ny >= 0 && ny < maxY;
    }
}
