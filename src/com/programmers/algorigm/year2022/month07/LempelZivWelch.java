package com.programmers.algorigm.year2022.month07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LempelZivWelch {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dir = new HashMap<>();
        int msgLength = msg.length();
        //초기화
        for (int i = 0; i < 26; i++) {
            dir.put(Character.toString((char) ('A' + i)), i + 1);
        }
        if (msgLength == 1) {
            return new int[]{dir.get(msg)};
        }

        String curStr = msg.substring(0, 1);
        String nextStr = msg.substring(1, 2);
        int index = 2;
        while (!nextStr.isEmpty()) {
            if (dir.containsKey(curStr + nextStr)) {
                curStr = curStr + nextStr;
            } else {
                answer.add(dir.get(curStr));
                dir.put(curStr + nextStr, dir.size() + 1);
                curStr = nextStr;
            }
            nextStr = msg.substring(Math.min(index, msgLength), Math.min(index + 1, msgLength));
            index++;

        }
        answer.add(dir.get(curStr));
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
