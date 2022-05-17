package com.programmers.algorigm.year2022.month05;

import java.util.Arrays;

public class RankSearch {
    public int[] solution2(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0 ; i < query.length; i++) {
            answer[i] = filtered(query[i].split("and"), info, 0);
        }


        return answer;
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0 ; i < query.length; i++) {
            answer[i] = filtered(query[i].split("and"), info, 0);
        }


        return answer;
    }

    public int filtered(String[] query, String[] info, int depth) {
        if (info.length ==0) {
            return 0;
        }
        String parsedQuery = depth >= 3 ? query[3].trim().split(" ")[depth-3] : query[depth].trim();
        if (depth == 4) {
            return Arrays.stream(info)
                    .filter(s -> Integer.parseInt(s.split(" ")[depth]) >=Integer.parseInt(parsedQuery)
                    ).toArray().length;
        }

        return filtered(query, Arrays.stream(info)
                .filter(s -> (parsedQuery.equals("-") || parsedQuery.equals(s.split(" ")[depth]))
                ).toArray(String[]::new), depth + 1);
    }
}
