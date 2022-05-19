package com.programmers.algorigm.year2022.month05;

import java.util.Arrays;

public class StringMaxMin {
    public String solution(String s) {
        String[] splited = s.split(" ");
        int[] sortedArray = Arrays.stream(splited).mapToInt(Integer::parseInt).sorted().toArray();
        return sortedArray[0] + " " + sortedArray[sortedArray.length - 1];
    }
}
