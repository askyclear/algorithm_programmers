package com.programmers.algorigm.year2022.month03;

import java.util.HashSet;
import java.util.Set;

public class LottoMaxMinRank {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> winNumsSet = new HashSet<>();

        for (int winNum : win_nums) {
            winNumsSet.add(winNum);
        }

        int correctCount = 0;
        int unknownCount = 0;

        for(int lotto : lottos) {
            if (winNumsSet.contains(lotto)) {
                correctCount++;
            }
            if (lotto == 0) {
                unknownCount++;
            }
        }
        
        answer[0] = 7 - Math.max((correctCount + unknownCount), 1);
        answer[1] = 7 - Math.max(correctCount, 1);

        return answer;
    }
}
