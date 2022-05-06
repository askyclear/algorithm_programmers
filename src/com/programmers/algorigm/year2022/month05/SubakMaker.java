package com.programmers.algorigm.year2022.month05;

public class SubakMaker {
    private static final String SUBAK = "수박";
    public String solution(int n) {
        String answer = "";
        for (int i = 0 ; i < n/2; i++) {
            answer+=SUBAK;
        }
        if (n % 2 == 1) {
            answer+="수";
        }
        return answer;
    }
}
