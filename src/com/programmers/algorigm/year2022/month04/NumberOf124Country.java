package com.programmers.algorigm.year2022.month04;

public class NumberOf124Country {
    private String[] rule = new String[]{"4", "1", "2"};
    public String solution(int n) {
        if (n < 1) {
            return "";
        }
        int remainder  = n % 3;
        int quotient = n / 3;
        if (remainder == 0) {
            return solution(quotient - 1) + rule[remainder];
        } else {
            return solution(quotient) + rule[remainder];
        }
    }

}
