package com.programmers.algorigm.yearother;

import java.util.Stack;

/**
 * 프로그래머스-스택/큐-기능개발
 * days = (100 - progresses) / speeds 로 작업 진도가 100이 넘을 날짜를 먼저 구한후 순차적으로 넘으면 결과
 * 스택에서 답을 꺼내 다시 push 하고 아닌경우 다음 완료 날짜 구해서 push 하는 방식으로 구현했다.
 *
 * 결과를 array로 다시 내보내야 해서 pop으로 데이터를 꺼내면 array에 집어 넣었다.
 *
 */
public class StackFunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        double completeDays = 0;

        Stack<Integer> resultStack = new Stack<>();

        for (int completeSize = 0; completeSize < progresses.length; completeSize++) {
            if (progresses[completeSize] + speeds[completeSize] * completeDays < 100) {
                completeDays = Math.ceil((double)(100 - progresses[completeSize]) / (double)speeds[completeSize]);
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

