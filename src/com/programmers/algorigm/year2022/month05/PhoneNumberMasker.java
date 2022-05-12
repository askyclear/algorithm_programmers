package com.programmers.algorigm.year2022.month05;

public class PhoneNumberMasker {
    public String solution(String phone_number) {
        String answer = "";
        int phoneNumberLength = phone_number.length();
        for(int i = 0; i < phoneNumberLength -4; i++) {
            answer+="*";
        }
        answer += phone_number.substring(phoneNumberLength - 4);
        return answer;
    }
}
