package com.programmers.algorigm;

import java.util.Arrays;

/**
 * 해시 전화번호 목록
 * 폰북중에 다른 전화번호의 접두사로 사용하는 번호가 있는지 확인 하는 문제.
 * 정렬을 해서 확인 하도록함.
 */
public class HashPhoneBook {
    public boolean solution1(String[] phone_book) {
        boolean answer = true;

        if(phone_book.length == 1) {
            return true;
        }

        Arrays.sort(phone_book);

        String preString = phone_book[0];

        for(int i = 1; i < phone_book.length; i++) {
            String compareNumberString = phone_book[i];

            if(preString.length() >= compareNumberString.length()) {
                preString = phone_book[i];
                continue;
            }

            for(int j = 0; j < preString.length(); j++) {
                if(preString.charAt(j) != compareNumberString.charAt(j)) {
                    preString = phone_book[i];
                    answer = true;
                    break;
                } else {
                    answer = false;
                }
            }

            if(!answer) {
                break;
            }
        }

        return answer;
    }

    public boolean solution2(String[] phone_book) {
        if(phone_book.length == 1) {
            return true;
        }

        Arrays.sort(phone_book);

        String preString = phone_book[0];

        for(int i = 1; i < phone_book.length; i++) {
            String compareNumberString = phone_book[i];

            if(preString.length() >= compareNumberString.length()) {
                preString = phone_book[i];
                continue;
            }

            if(compareNumberString.startsWith(preString)) {
                return false;
            } else {
                preString = compareNumberString;
            }
        }

        return true;
    }
}
