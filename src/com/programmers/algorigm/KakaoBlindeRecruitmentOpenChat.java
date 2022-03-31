package com.programmers.algorigm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KakaoBlindeRecruitmentOpenChat {
    private static final String ENTER_POSTFIX = "님이 들어왔습니다.";
    private static final String OUT_POSTFIX = "님이 나갔습니다.";
    private static final String ENTER = "Enter";
    private static final String CHANGE = "Change";
    private static final String LEAVE = "Leave";
    private static final String SPLIT_TEXT = " ";

    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> idNickNameMap = new HashMap<>();

        for (String infoStr : record) {
            String[] info = infoStr.split(SPLIT_TEXT);
            if (info[0].equals(ENTER)) {
                idNickNameMap.put(info[1], info[2]);
            } else if (info[0].equals(CHANGE)) {
                idNickNameMap.put(info[1], info[2]);
            }
        }

        for (String infoStr : record) {
            String[] info = infoStr.split(SPLIT_TEXT);
            if (info[0].equals(ENTER)) {
                answer.add(idNickNameMap.get(info[1]) + ENTER_POSTFIX);
            } else if (info[0].equals(LEAVE)) {
                answer.add(idNickNameMap.get(info[1]) + OUT_POSTFIX);
            }
        }

        return answer.toArray(new String[0]);
    }
}
