package com.programmers.algorigm.year2022.month08;

public class Ranking {
    private static final int WIN = 1;
    private static final int LOSE = -1;
    private static final int UNKNOWN = 0;
    public int solution(int n, int[][] results) {
        int[][] gameTable = new int[n+1][n+1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            // A > B
            gameTable[winner][loser] = WIN;
            gameTable[loser][winner] = LOSE;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(gameTable[i][k] == WIN && gameTable[k][j] == WIN){
                        gameTable[i][j] = WIN;
                        gameTable[j][i] = LOSE;
                    }
                    if(gameTable[i][k] == LOSE && gameTable[k][j] == LOSE){
                        gameTable[i][j] = LOSE;
                        gameTable[j][i] = WIN;
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(gameTable[i][j] != UNKNOWN){
                    cnt++;
                }
            }
            if(cnt == n - 1){
                answer++;
            }
        }

        return answer;
    }
}
