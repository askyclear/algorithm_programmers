package com.programmers.algorigm.year2022.month05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RankSearch {
    public int[] solution2(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
//            answer[i] = filtered(query[i].split("and"), info);
        }


        return answer;
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Info> infoList = new ArrayList<>();

        for (String peopleInfo : info) {
            String[] infos = peopleInfo.split(" ");

            infoList.add(new Info(infos[0], infos[1], infos[2], infos[3], Integer.parseInt(infos[4])));
        }

        for (int i = 0; i < query.length; i++) {
            answer[i] = filtered(query[i].split(" and "), infoList);
        }


        return answer;
    }
    private class Info{
        private String lang;
        private String jobGroup;
        private String career;
        private String favorite;
        private Integer score;

        public Info(String lang, String jobGroup, String career, String favorite, Integer score) {
            this.lang = lang;
            this.jobGroup = jobGroup;
            this.career = career;
            this.score = score;
            this.favorite = favorite;
        }
    }

    public int filtered(String[] query, List<Info> infoList) {
        return infoList.stream().filter((info) -> {
            if(query[0].equals("-")) {
                return true;
            }

            return query[0].equals(info.lang);
        }).filter((info) -> {
            if(query[1].equals("-")) {
                return true;
            }
            return query[1].equals(info.jobGroup);
        }).filter((info) -> {
            if(query[2].equals("-")) {
                return true;
            }
            return query[2].equals(info.career);
        }).filter((info) -> {
            String[] lastQuery = query[3].split(" ");
            if(lastQuery[0].equals(info.favorite) || lastQuery[0].equals("-")) {
                return info.score >= Integer.parseInt(lastQuery[1]);
            }
            return false;
        }).collect(Collectors.toList()).size();
    }
}
