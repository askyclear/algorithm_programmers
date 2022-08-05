package com.programmers.algorigm.year2022.month05;

import java.util.*;
import java.util.stream.Collectors;

public class RankSearch {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> peopleMap = new HashMap<>();

        for (String peopleInfo : info) {
            String[] infos = peopleInfo.split(" ");
            String[] langs = {infos[0], "-"};
            String[] jobGroups = {infos[1], "-"};
            String[] carreas = {infos[2], "-"};
            String[] favorutis = {infos[3], "-"};
            Integer score = Integer.parseInt(infos[4]);
            for (String lang : langs) {
                for(String jobGroup : jobGroups) {
                    for (String carre : carreas) {
                        for(String favority : favorutis) {
                            String key = lang + jobGroup + carre + favority;
                            List<Integer> scores = peopleMap.getOrDefault(lang + jobGroup + carre + favority, new ArrayList<>());
                            scores.add(score);
                            peopleMap.put(key, scores);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < query.length; i++) {
            String[] quey = query[i].replaceAll(" and ", "").split(" ");
            Integer compareScore = Integer.parseInt(quey[1]);
            if(peopleMap.containsKey(quey[0])) {
                List<Integer> scores = peopleMap.get(quey[0]);
                Collections.sort(scores);

                answer[i] = getPeopleCount(scores, compareScore);
            }
        }

        return answer;
    }

    private int getPeopleCount(List<Integer> scores, Integer compareScore) {
        int min = 0;
        int max = scores.size() - 1;
        int mid;
        if (scores.size() == 1) {
            return scores.get(0) >= compareScore ? 1 : 0;
        }
        while (min <= max) {
            mid = (min + max) / 2;
            if (scores.get(mid) < compareScore) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return scores.size() - min;
    }
}
