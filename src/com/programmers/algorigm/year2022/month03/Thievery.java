package com.programmers.algorigm.year2022.month03;

public class Thievery {
    public int solution(int[] money) {
        int homeLength = money.length;

        int[] dpFirstChoice = new int[homeLength];
        int[] dpFirstNotChoice = new int[homeLength];

        dpFirstChoice[0] = money[0];
        dpFirstChoice[1] = Math.max(money[0], money[1]);

        dpFirstNotChoice[1] = money[1];

        for (int i = 2; i < homeLength; i++ ) {
            dpFirstNotChoice[i] = Math.max(dpFirstNotChoice[i-1], dpFirstNotChoice[i - 2] + money[i]);
            if (i == homeLength -1) {
                dpFirstChoice[i] = dpFirstChoice[i - 1];
                break;
            } else {
                dpFirstChoice[i] = Math.max(dpFirstChoice[i-1], dpFirstChoice[i - 2] + money[i]);
            }
        }

        return Math.max(dpFirstNotChoice[homeLength - 1], dpFirstChoice[homeLength - 1]);
    }
}
