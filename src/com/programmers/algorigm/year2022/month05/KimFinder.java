package com.programmers.algorigm.year2022.month05;

public class KimFinder {
    public String solution(String[] seoul) {
        int position = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                position = i;
                break;
            }
        }

        return "김서방은 " + position + "에 있다";
    }
}
