package com.programmers.algorigm.year2022.month02;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for (int yellowWidth = yellow; yellowWidth > 0; yellowWidth--) {
            if(yellow % yellowWidth == 0) {
                int yellowHeight = yellow / yellowWidth;
                int brownWeight = yellowWidth + 2;
                int brownHeight = yellowHeight + 2;

                if (brownWeight * brownHeight - yellow == brown) {
                    return new int[]{brownWeight, brownHeight};
                }
            }
        }

        return answer;
    }
}
