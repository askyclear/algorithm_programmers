package com.programmers.algorigm.year2022.month04;

import java.util.HashSet;
import java.util.Set;

public class KakaoSpecialConverter {

    public String solution(String sentence) {
        String answer = "";
        Set<String> usingSpecialSet = new HashSet<>();

        String[] splitSentence = getSplitSentence(sentence).split(" ");

        for (String targetSentence : splitSentence) {
            String convertedSentence = convert(targetSentence, usingSpecialSet);
            if (convertedSentence.equals("invalid")) {
                return convertedSentence;
            }
            answer += convertedSentence + " ";
        }

        return answer.trim();
    }

    private String convert(String targetSentence, Set<String> usingSpecialSet) {
        char firstChar = targetSentence.charAt(0);
        if (isSpecialChar(firstChar)) {
            if (targetSentence.lastIndexOf(firstChar) == 0 || usingSpecialSet.contains(Character.toString(firstChar))) {
                return "invalid";
            }

            usingSpecialSet.add(Character.toString(firstChar));
            char secondChar = targetSentence.charAt(1);
            if (Character.isLowerCase(secondChar)) {
                for (int i = 1; i < targetSentence.length() - 1; i++) {
                    if (targetSentence.charAt(i) == firstChar) {
                        return "invalid";
                    }
                    if (i % 2 == 0 && targetSentence.charAt(i) != secondChar) {
                        return "invalid";
                    }
                }
            } else {
                for (int i = 1; i < targetSentence.length() - 1; i++) {
                    if (Character.isLowerCase(targetSentence.charAt(i))) {
                        return "invalid";
                    }
                }
            }

            if(targetSentence.charAt(targetSentence.length() - 1) != firstChar) {
                return "invalid";
            }

            targetSentence = targetSentence.substring(1, targetSentence.length() - 1);
        }
        if (isSpecialChar(targetSentence.charAt(0))) {
            return "invalid";
        }
        char secondChar = targetSentence.charAt(1);
        if (isSpecialChar(secondChar)) {
            if (usingSpecialSet.contains(Character.toString(secondChar))) {
                return "invalid";
            }

            usingSpecialSet.add(Character.toString(secondChar));
            StringBuilder convertString = new StringBuilder();
            for (int i = 0; i < targetSentence.length(); i++) {
                char temp = targetSentence.charAt(i);
                if (i % 2 == 0 && isSpecialChar(temp) || (i % 2 == 1 && temp != secondChar)) {
                    return "invalid";
                } else if (i % 2 == 0) {
                    convertString.append(temp);
                }
            }
            targetSentence = convertString.toString();
        }

        return targetSentence;
    }

    private String getSplitSentence(String sentence) {
        if (sentence.isEmpty()) {
            return "";
        }

        if (sentence.length() == 1) {
            return sentence;
        }

        if (isSpecialChar(sentence.charAt(0))) {
            int lastIndexOf = Math.min(sentence.lastIndexOf(sentence.charAt(0)) + 1, sentence.length());
            String word = sentence.substring(0, lastIndexOf);
            String remainWord = sentence.substring(lastIndexOf);
            return word + " " + getSplitSentence(remainWord);
        } else if (isSpecialChar(sentence.charAt(1))) {
            int lastIndexOf = Math.min(sentence.lastIndexOf(sentence.charAt(1)) + 2, sentence.length());
            String word = sentence.substring(0, lastIndexOf);
            String remainWord = sentence.substring(lastIndexOf);
            return word + " " + getSplitSentence(remainWord);
        } else {
            return sentence;
        }
    }

    private boolean isSpecialChar(char target) {
        return target >= 97 && target <= 122;
    }
}
