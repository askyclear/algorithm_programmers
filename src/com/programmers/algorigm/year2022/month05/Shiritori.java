package com.programmers.algorigm.year2022.month05;

import java.util.HashSet;
import java.util.Set;

public class Shiritori {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> usedWord = new HashSet<>();
        usedWord.add(words[0]);
        String lastAlphabet = words[0].substring(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (!word.startsWith(lastAlphabet) && usedWord.contains(word)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            usedWord.add(word);
            lastAlphabet = word.substring(word.length() - 1);
        }


        return answer;
    }
}
