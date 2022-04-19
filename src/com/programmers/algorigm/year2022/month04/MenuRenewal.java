package com.programmers.algorigm.year2022.month04;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuRenewal {
    private Map<String, Integer> courseMap;
    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        List<String> answer = new ArrayList<>();


        for (String order : orders) {
            char[] orderChar = order.toCharArray();
            Arrays.sort(orderChar);
            String sortedOrder = new String(orderChar);
            dfs("", sortedOrder);
        }

        for (int courseSize : course) {
            AtomicInteger maxOrderCount = new AtomicInteger(2);
            List<String> courseList = new ArrayList<>();
            courseMap.forEach((courseName, orderCount) -> {
                if (orderCount >= maxOrderCount.get() && courseName.length() == courseSize) {
                    if (orderCount > maxOrderCount.get()) {
                        courseList.clear();
                        maxOrderCount.set(orderCount);
                    }
                    courseList.add(courseName);
                }
            });
            answer.addAll(courseList);
        }
        answer.sort(String::compareTo);

        return answer.toArray(new String[0]);
    }

    private void dfs(String preString, String remainString) {
        for (int i = 0; i < remainString.length(); i++) {
            String course = preString + remainString.charAt(i);
            if (course.length() > 1) {
                courseMap.put(course, courseMap.getOrDefault(course, 0) + 1);
            }
            dfs(course, remainString.substring(Math.min(i + 1, remainString.length())));
        }
    }
}
