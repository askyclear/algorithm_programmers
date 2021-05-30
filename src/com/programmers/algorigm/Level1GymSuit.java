package com.programmers.algorigm;

import java.util.HashMap;
import java.util.Map;

/**
 * 해당 문제는 n명의 학생중 체육복은 잃어버린 사람의 정보를 가진 lost 배열과 여분의 옷을 가진 reserve 배열을통해
 * 체육수업을 들을수 있는 학생의 최대 수를 구하는 문제이다.
 * 나는 일단 맵에 잃어버린 학생의 번호를 넣어두고, 여분을 가진 학생의 번호또한 넣어주도록 한후
 * 1 ~ n 까지 순차적으로 데이터를 꺼내 보는데, 여분의 옷을 가진 데이터가 나오면 이전 순차의 데이터의 값이 -1 인 경우인 친구에게 옷을 주는 식으로 해서
 * 로직을 구현함. 이후 친구가 옷이 없는 경우에는 개한테 옷을 줬다는 식으로 데이터를 업데이트 하고 그 순차 반복문을 넘기기 위해 i++; 도 해줌
 */
public class Level1GymSuit {
    private static final int LOST = -1;
    private static final int EXIST = 0;
    private static final int RESERVE = 1;

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Map<Integer, Integer> oksMap = new HashMap<>();

        for (int i = 0; i < lost.length; i++) {
            oksMap.put(lost[i], LOST);
        }


        for (int i = 0; i < reserve.length; i++) {
            oksMap.put(reserve[i], oksMap.getOrDefault(reserve[i], EXIST) + 1);
        }


        for (int i = 1; i <= n; i++) {
            int state = oksMap.getOrDefault(i, EXIST);
            if(state == EXIST) {
                answer++;

            } else if(state == RESERVE) {
                answer++;

                int leftPerson = i - 1;
                int rightPerson = i + 1;

                if(oksMap.getOrDefault(leftPerson, EXIST) == LOST) {
                    answer++;

                } else if (oksMap.getOrDefault(rightPerson, EXIST) == LOST) {
                    oksMap.put(rightPerson, EXIST);

                    answer++;
                    i++;
                }
            }
        }

        return answer;
    }
}
