package com.programmers.algorigm;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        double completeDays = 0;
        Stack<Integer> resultStack = new Stack<>();

        for (int completeSize = 0; completeSize < progresses.length; completeSize++) {
            if (progresses[completeSize] + speeds[completeSize] * completeDays < 100) {
                completeDays = Math.ceil((double) (100 - progresses[completeSize]) / (double) speeds[completeSize]);
                resultStack.push(1);
            } else {
                int count = resultStack.pop();
                resultStack.push(count + 1);
            }
        }

        int[] answer = new int[resultStack.size()];

        for (int i = resultStack.size() - 1; i >= 0; i--) {
            answer[i] = resultStack.pop();
        }

        return answer;
    }
}