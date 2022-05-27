package com.programmers.algorigm.year2022.month05;

public class RepeatBinaryNumber {
    private static final String ZERO_STR = "0";
    private static final String ONE_STR = "1";

    public int[] solution(String s) {
        int[] answer = new int[2];

        while (true) {
            answer[0]++;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ZERO_STR.charAt(0)) {
                    answer[1]++;
                } else {
                    stringBuilder.append(1);
                }
            }
            if (stringBuilder.toString().equals(ONE_STR)) {
                break;
            }
            s = getChanged2Express(stringBuilder.length());
        }

        return answer;
    }

    private String getChanged2Express(int length) {
        StringBuilder temp = new StringBuilder();
        while (length > 0) {
            if (length == 1) {
                temp.insert(0, 1);
                break;
            }
            temp.insert(0, (length % 2));
            length = length / 2;

        }

        return temp.toString();
    }
}

