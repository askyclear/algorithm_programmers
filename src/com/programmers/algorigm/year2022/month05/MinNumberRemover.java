package com.programmers.algorigm.year2022.month05;

import java.util.ArrayList;
import java.util.List;

public class MinNumberRemover {
    public int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();
        for (int number : arr) {
            answerList.add(number);
        }
        
        int minNumber = answerList.stream().min(Integer::compareTo).get();
        int[] answer = answerList.stream().filter(integer -> integer != minNumber).mapToInt(Integer::intValue).toArray();
        if (answer.length == 0) {
            return new int[]{-1};
        }
        return answer;
    }
}
