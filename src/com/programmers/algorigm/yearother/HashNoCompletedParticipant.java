package com.programmers.algorigm.yearother;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 배열 2개가 주어지는데, 하나는 참석자 하나는 완주자로 딱한명 완주하지 못했다고 함;
 *
 * 처음에는 해시맵에 저장하고 완주자 카운트 제거 하면서 맵에서 제거해서 최종적으로 남은 key 값을 리턴해주는 방식으로 해결
 * 생각해보면 한명의 참석자만 없기때문에 참석자, 완주자를 정렬 후에
 * 서로 비교해 가다가 참석자와 완주자가 다른 경우가 바로 완주하지 못한 참석자라는 걸 알수 있음
 * 이렇게 2가지 방식으로 풀어보고 전부 통과
 *
 */
public class HashNoCompletedParticipant {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<>();
        for(String name : participant) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            int count = participantMap.getOrDefault(name, 0) - 1;
            if (count == 0) {
                participantMap.remove(name);
            } else {
                participantMap.put(name, count);
            }
        }

        for(String key : participantMap.keySet()) {
            answer =  key;
        }

        return answer;
    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }
}
