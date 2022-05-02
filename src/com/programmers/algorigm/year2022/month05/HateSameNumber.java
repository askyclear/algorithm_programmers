package com.programmers.algorigm.year2022.month05;

import java.util.ArrayList;
import java.util.List;

public class HateSameNumber {
    public int[] solution(int []arr) {
        List<Integer> answerList = new ArrayList<>();
        int preNumber = arr[0];
        answerList.add(preNumber);

        for (int i = 1; i <arr.length; i++) {
            if (arr[i] != preNumber) {
                answerList.add(arr[i]);
                preNumber= arr[i];
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
