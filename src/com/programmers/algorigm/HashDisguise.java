package com.programmers.algorigm;

import java.util.HashMap;
import java.util.Map;

/**
 * 해당 문제는 고민을 많이 했는데, 결론은 입지않음이라는 경우의 수를 포함하여 계산하도록 함
 *
 * 일단 옷 종류 별 가지고 있는 가지수에 입지 않는다라는 경우를 포함하여 카운트 하도록 하고, 이후 전부 입지 않는다는 없으므로 그 경우를 뺀것으로 결론을 내도록 함
 */
public class HashDisguise {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>();

        for(String[] clothesInfo : clothes) {
            clothesMap.put(clothesInfo[1], clothesMap.getOrDefault(clothesInfo[1], 0) + 1);
        }

        for (int value : clothesMap.values()){
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
