package com.programmers.algorigm.year2022.month04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSelectAdd {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> answerSet = new HashSet<>();

        for(int i = 0; i < numbers.length - 1; i++) {
            int selectOne = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                answerSet.add(selectOne + numbers[j]);
            }
        }
        answer = answerSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        return answer;
    }
}
