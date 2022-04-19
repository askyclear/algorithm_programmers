package com.programmers.algorigm.year2022.month04;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NewsClustering {
    public int solution(String str1, String str2) {
        Map<String, Integer> str1Set = getSet(str1);
        Map<String, Integer> str2Set = getSet(str2);

        if (str1Set.isEmpty() && str2Set.isEmpty()) {
            return 1;
        }

        double intersectionCount = getIntersection(str1Set, str2Set);

        double unionCount = getUnionCount(str1Set, str2Set);
        double calcu = intersectionCount / unionCount;

        return (int) (calcu * 65536);
    }

    private int getUnionCount(Map<String, Integer> str1Set, Map<String, Integer> str2Set) {
        AtomicInteger unionCount = new AtomicInteger();

        str1Set.forEach((element, count) -> {
            if (str2Set.containsKey(element)) {
                unionCount.addAndGet(Math.max(count, str2Set.get(element)));
            } else {
                unionCount.addAndGet(count);
            }
        });
        str2Set.forEach((element, count) -> {
            if (!str1Set.containsKey(element)) {
                unionCount.addAndGet(count);
            }
        });

        return unionCount.get();
    }

    private int getIntersection(Map<String, Integer> str1Set, Map<String, Integer> str2Set) {
        AtomicInteger intersectionCount = new AtomicInteger();
        str1Set.forEach((element, count) -> {
            if (str2Set.containsKey(element)) {
                intersectionCount.addAndGet(Math.min(count, str2Set.get(element)));
            }
        });

        return intersectionCount.get();
    }

    private Map<String, Integer> getSet(String str) {
        Map<String, Integer> strSet = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String element = str.substring(i, i + 2).toUpperCase();
            if (element.charAt(0) < 65 || element.charAt(0) > 90 ||
                    element.charAt(1) < 65 || element.charAt(1) > 90) {
                continue;
            }
            strSet.put(element, strSet.getOrDefault(element, 0) + 1);
        }

        return strSet;
    }
}
