package com.programmers.algorigm;

public class KakaoBlindRecruitment2021NewId {
    public String solution(String new_id) {
        //1단계
        String answer = new_id.toLowerCase();
        // 2단계
        answer = answer.replaceAll("[^a-z0-9_|\\-|.]", "");
        // 3단계
        answer = answer.replaceAll("\\.{2,}", ".");
        // 4단계
        answer = answer.startsWith(".") ? answer.substring(1) : answer;
        answer = answer.endsWith(".") ? answer.substring(0, answer.length() - 1) : answer;
        // 5단계
        answer = answer.isEmpty() ? "aaa" : answer;
        // 6단계
        answer = answer.length() > 15 ? answer.substring(0, 15).endsWith(".") ? answer.substring(0,14) : answer.substring(0,15) : answer;
        // 7단계
        answer = answer.length() == 1 ? answer + answer + answer : answer.length() == 2 ? answer + answer.charAt(1) : answer;

        return answer;
    }
}
