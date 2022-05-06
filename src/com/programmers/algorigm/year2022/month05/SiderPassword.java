package com.programmers.algorigm.year2022.month05;

public class SiderPassword {
    public String solution(String s, int n) {
        char[] strChars = s.toCharArray();
        char[] covertChars = new char[strChars.length];
        for (int i = 0; i < strChars.length; i++) {
            if (strChars[i] > 96) {
                covertChars[i] = (char) ((strChars[i] + n) > 122 ? strChars[i] + n - 26 : strChars[i] + n);
            } else if (strChars[i] > 64){
                covertChars[i] = (char) ((strChars[i] + n) > 90 ? strChars[i] + n - 26 : strChars[i] + n);
            } else {
                covertChars[i] = strChars[i];
            }
        }
        return new String(covertChars);
    }
}
