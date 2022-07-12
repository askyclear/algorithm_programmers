package com.programmers.algorigm.year2022.month07;

import java.util.ArrayList;
import java.util.List;

public class OneCache {
    private static final int cacheMissTime = 5;
    private static final int cacheHitTime = 1;

    public int solution(int cacheSize, String[] cities) {
        List<String> lru = new ArrayList<>();

        int answer = 0;

        if (cacheSize == 0) {
            answer = cities.length * cacheMissTime;

            return answer;
        }

        for (String city : cities) {
            String temp = city.toUpperCase();

            if (lru.contains(temp)) {
                lru.remove(temp);
                lru.add(temp);
                answer += cacheHitTime;

            } else {
                if (lru.size() == cacheSize) {
                    lru.remove(0);
                }

                lru.add(temp);

                answer += cacheMissTime;
            }
        }

        return answer;
    }
}
