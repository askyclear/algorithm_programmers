package com.programmers.algorigm;

import java.util.HashMap;
import java.util.Map;

public class KakaoBlindRecruitment2021NumbereStr {
    private static final Map<String, String> wordToNumber = new HashMap<>();
    static {
        wordToNumber.put("zero", "0");
        wordToNumber.put("one", "1");
        wordToNumber.put("two", "2");
        wordToNumber.put("three", "3");
        wordToNumber.put("four", "4");
        wordToNumber.put("five", "5");
        wordToNumber.put("six", "6");
        wordToNumber.put("seven", "7");
        wordToNumber.put("eight", "8");
        wordToNumber.put("nine", "9");
    }

    public int solution(String s) {
        String temp = "";
        StringBuilder answerStr = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            temp += s.substring(i, i + 1);
            if (temp.matches("[0-9]")) {
                answerStr.append(temp);
                temp = "";
            } else if (wordToNumber.containsKey(temp)) {
                answerStr.append(wordToNumber.get(temp));
                temp = "";
            }
        }

        return Integer.parseInt(answerStr.toString());
    }
}
