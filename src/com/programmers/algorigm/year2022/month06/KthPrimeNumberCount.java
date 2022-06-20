package com.programmers.algorigm.year2022.month06;

import java.util.Stack;

public class KthPrimeNumberCount {
    public int solution(int n, int k) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            int temp = n % k;
            stack.push(temp);
            n = n / k;
        }
        long curNumber = 0;
        while (!stack.isEmpty()) {
            int digitNumber = stack.pop();
            if (digitNumber == 0) {
                answer += isPrimeNumber(curNumber) ? 1 : 0;
                curNumber = 0;
            } else {
                curNumber = curNumber * 10 + digitNumber;
            }
        }

        answer += isPrimeNumber(curNumber) ? 1 : 0;

        return answer;
    }

    private boolean isPrimeNumber(long number) {
        if (number <= 1) {
            return false;
        }

        long sqrt = (long) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
