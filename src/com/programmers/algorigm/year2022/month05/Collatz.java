package com.programmers.algorigm.year2022.month05;

public class Collatz {
    public int solution(int num) {
        return getCollatzRepeatCount(0, num);
    }

    public int getCollatzRepeatCount(int count, long num) {
        if (count > 500) {
            return -1;
        }

        if (num == 1) {
            return count;
        }

        count++;
        if (num % 2 == 0) {
            return getCollatzRepeatCount(count, num / 2);
        } else {
            return getCollatzRepeatCount(count, num * 3 + 1);
        }
    }
}
