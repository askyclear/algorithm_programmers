package com.programmers.algorigm.year2022.month05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisorArray {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr);
        for(int number : arr) {
            if(number % divisor == 0) {
                answer.add(number);
            }
        }
        if (answer.size() ==0) {
            answer.add(-1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
