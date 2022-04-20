package com.programmers.algorigm.year2022.month04;

import java.util.LinkedList;
import java.util.Queue;

public class TernaryFlipOver {
    public int solution(int n) {
        Queue<Integer> queue = new LinkedList<>();

        while(n > 0) {
            queue.add(n % 3);
            n = n / 3;
        }

        int answer = 0;

        while(!queue.isEmpty()) {
            answer += (queue.poll() * Math.pow(3, queue.size()));
        }

        return answer;
    }
}
