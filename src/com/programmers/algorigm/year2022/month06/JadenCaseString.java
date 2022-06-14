package com.programmers.algorigm.year2022.month06;

public class JadenCaseString {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirst = true;
        for(char character : s.toCharArray()) {
            if (character == ' ') {
                isFirst = true;
                answer.append(character);
                continue;
            }

            if (isFirst) {
               isFirst = false;
               if (!Character.isDigit(character)) {
                   answer.append(Character.toUpperCase(character));
               }
            } else {
                if (!Character.isDigit(character)) {
                    answer.append(Character.toLowerCase(character));
                }
            }

            if(Character.isDigit(character)) {
                answer.append(character);
            }
        }

        return answer.toString();
    }
}
