package com.programmers.algorigm.year2022.month05;

public class IntegerSquareDiscriminator {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        if (n / sqrt == sqrt && n % sqrt == 0) {
            return (long) Math.pow(sqrt + 1, 2);
        }
        return -1L;
    }
}
