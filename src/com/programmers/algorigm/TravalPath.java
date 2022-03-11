package com.programmers.algorigm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravalPath {
    private boolean[] used;
    private List<String> paths;

    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        paths = new ArrayList<>();
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(paths);
        String[] answer = paths.get(0).split(",");
        return answer;
    }

    private void dfs(int depth, String airportName, String path, String[][] tickets) {
        if (depth == tickets.length) {
            paths.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(airportName)) {
                used[i] = true;
                dfs(depth + 1, tickets[i][1], path + "," + tickets[i][1], tickets);
                used[i] = false;
            }
        }
    }
}
