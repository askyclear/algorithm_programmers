package com.programmers.algorigm.year2022.month05;

public class BasicStringController {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
            for (char strChar : s.toCharArray()) {
                if (!Character.isDigit(strChar)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
