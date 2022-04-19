package com.programmers.algorigm.year2022.month03;

import java.util.Stack;

public class Kakao2019Crain {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        int[] boardXHeight = new int[N];
        Stack<Integer> barket = new Stack<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0) {
                    boardXHeight[j]++;
                }
            }
        }

        for (int moveX : moves) {
            int xHeight = boardXHeight[moveX - 1]--;
            if (xHeight > 0) {
                int pick = board[N - xHeight][moveX - 1];
                if (!barket.isEmpty() && barket.peek() == pick) {
                    barket.pop();
                    answer++;
                } else {
                    barket.push(pick);
                }
                board[N - xHeight][moveX - 1] = 0;
            }
        }

        return answer * 2;
    }


    public int solution2(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> barket = new Stack<>();

        for (int moveX : moves) {
            for (int floor = 0; floor < N; floor++) {

                int pick = board[floor][moveX - 1];
                if (pick > 0) {
                    if (!barket.isEmpty() && barket.peek() == pick) {
                        barket.pop();
                        answer++;
                    } else {
                        barket.push(pick);
                    }
                    board[floor][moveX - 1] = 0;
                    break;
                }
            }
        }

        return answer * 2;
    }
}
