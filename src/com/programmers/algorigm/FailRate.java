package com.programmers.algorigm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FailRate {
    public int[] solution(int N, int[] stages) {
        int passUser = stages.length;
        Map<Integer, Integer> stageMap = new HashMap<>();
        List<StageInfo> stageInfoList = new ArrayList<>();

        for(int stage : stages) {
            stageMap.put(stage, stageMap.getOrDefault(stage, 0) + 1);
        }

        for(int i = 1; i <= N; i++) {
            Integer currentUser = stageMap.getOrDefault(i, 0);
            StageInfo stageInfo = new StageInfo(i, passUser, currentUser);
            passUser -= currentUser;
            stageInfoList.add(stageInfo);
        }

        stageInfoList.sort((o1, o2) -> {
            if(o1.getFailRate() < o2.getFailRate()) {
                return 1;
            } else if(o1.getFailRate() == o2.getFailRate()) {
                return o1.getStage() > o2.getStage() ? 1 : -1;
            } else {
                return -1;
            }
        });

        return stageInfoList.stream().mapToInt(StageInfo::getStage).toArray();
    }

    private class StageInfo {
        private Integer stage;
        private Integer passUser;
        private Integer currentUser;

        public StageInfo(Integer stage, Integer passUser, Integer currentUser) {
            this.stage = stage;
            this.passUser = passUser;
            this.currentUser = currentUser;
        }

        public Integer getStage() {
            return stage;
        }
        public double getFailRate() {
            return passUser > 0 ? (double) currentUser/ passUser : 0;
        }
    }
}
