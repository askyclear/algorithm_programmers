package com.programmers.algorigm.year2022.month05;

public class StrangeCharacter {
    public String solution(String s) {
        char[] splitedWord = s.toCharArray();
        boolean isOdd = true;
        for(int i = 0; i <splitedWord.length; i++) {
            if (splitedWord[i] == " ".charAt(0)) {
                isOdd = true;
                continue;
            }
            if(isOdd) {
                splitedWord[i] = Character.toUpperCase(splitedWord[i]);
                isOdd = false;
            } else {
                splitedWord[i] = Character.toLowerCase(splitedWord[i]);
                isOdd = true;
            }
        }


        return new String(splitedWord);
    }
}
