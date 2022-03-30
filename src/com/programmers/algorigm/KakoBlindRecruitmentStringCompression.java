package com.programmers.algorigm;

public class KakoBlindRecruitmentStringCompression {
    public int solution(String s) {
        int answer = s.length();
        int sLength = s.length();

        for(int repeatLength = 1; repeatLength <= sLength / 2; repeatLength++) {
            int start = 0;
            int repeatCount = 1;
            String temp = "";
            StringBuilder stringBuilder = new StringBuilder();
            while(start <= sLength) {
                String compareStr = s.substring(start, Math.min(start + repeatLength, sLength));

                if (temp.equals(compareStr)) {
                    repeatCount++;
                } else {
                    stringBuilder.append(repeatCount == 1 ? temp : repeatCount + temp);
                    temp = compareStr;
                    repeatCount = 1;
                }
                start += repeatLength;
                if (start > sLength) {
                    stringBuilder.append(temp);
                }
            }
            answer = Math.min(answer, stringBuilder.toString().length());
        }

        return answer;
    }
}
