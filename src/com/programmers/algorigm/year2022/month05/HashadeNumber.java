package com.programmers.algorigm.year2022.month05;

public class HashadeNumber {
    public boolean solution(int x) {
        int digitSum = 0;
        int temp = x;

        while (temp > 0) {
            digitSum+= temp % 10;
            temp = temp / 10;
        }
        return x % digitSum == 0;
    }
}
