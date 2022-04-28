package com.programmers.algorigm.year2022.month04;

public class MidCharacter {
    public String solution(String s) {
        int length = s.length();
        int beginIndex = length % 2 == 0 ? length/2 -1 : length/2;
        int endIndex = length % 2 == 0 ? beginIndex + 2 : beginIndex + 1;

        return s.substring(beginIndex, endIndex);
    }
}
