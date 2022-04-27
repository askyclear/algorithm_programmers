package com.programmers.algorigm.year2022.month04;

public class LeakPrice {
    public long solution(int price, int money, int count) {
        long totalPrice = (long)price * count * (count + 1) / 2;

        return Math.max(totalPrice - money, 0);
    }
}
