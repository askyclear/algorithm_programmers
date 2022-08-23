package com.programmers.algorigm.year2022.month08;

import java.util.HashMap;
import java.util.Map;

public class MBTISurvey {

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> mbti = new HashMap<>();
        mbti.put("R", 0);
        mbti.put("T", 0);
        mbti.put("C", 0);
        mbti.put("F", 0);
        mbti.put("J", 0);
        mbti.put("M", 0);
        mbti.put("A", 0);
        mbti.put("N", 0);


        for (int i = 0; i < survey.length; i++) {
            int point = choices[i] - 4;
            if (point < 0) {
                String typeA = survey[i].substring(0, 1);

                mbti.put(typeA, mbti.get(typeA) - point);
            } else if (point > 0) {
                String typeB = survey[i].substring(1, 2);
                mbti.put(typeB, mbti.get(typeB) + point);
            }
        }


        answer += mbti.get("R") >= mbti.get("T") ? "R" : "T";
        answer += mbti.get("C") >= mbti.get("F") ? "C" : "F";
        answer += mbti.get("J") >= mbti.get("M") ? "J" : "M";
        answer += mbti.get("A") >= mbti.get("N") ? "A" : "N";

        return answer;
    }
}
