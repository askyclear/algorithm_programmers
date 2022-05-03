package com.programmers.algorigm.year2022.month05;

import java.util.Arrays;

public class StringSort {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2) : o1.charAt(n) - o2.charAt(n));
        return strings;
    }
}
