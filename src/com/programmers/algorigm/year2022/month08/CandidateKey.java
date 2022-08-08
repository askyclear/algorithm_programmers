package com.programmers.algorigm.year2022.month08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {
    private int columns;

    public int solution(String[][] relation) {
        int answer = 0;
        columns = relation[0].length;
        List<Set<Integer>> candidateKey = new ArrayList<>();

        for (int i = 1; i <= columns; i++) {
            answer += getCandidateKeyCount(-1, i, 0, new HashSet<>(), relation, candidateKey);
        }
        return answer;
    }

    private int getCandidateKeyCount(int index, int targetCount, int keyCount, Set<Integer> keyIndexList, String[][] relation, List<Set<Integer>> candidateKey) {

        if (keyCount == targetCount) {
            if (!isUnique(keyIndexList, relation)) {
                return 0;
            }
            for (Set<Integer> keySet : candidateKey) {
                if (keyIndexList.containsAll(keySet)) {
                    return 0;
                }
            }
            candidateKey.add(keyIndexList);
            return 1;
        }

        int answer = 0;
        for (int i = index + 1; i < columns; i++) {
            Set<Integer> newKeyIndexList = new HashSet<>(keyIndexList);
            newKeyIndexList.add(i);

            answer += getCandidateKeyCount(i, targetCount, keyCount + 1, newKeyIndexList, relation, candidateKey);
        }
        return answer;
    }

    public boolean isUnique(Set<Integer> keyIndexList, String[][] relation) {
        Set<String> keyMap = new HashSet<>();
        for (String[] data : relation) {
            String key = "";
            for (Integer index : keyIndexList) {
                key += " " + data[index];
            }

            if (keyMap.contains(key)) {
                return false;
            }

            keyMap.add(key);
        }

        return true;
    }
}
