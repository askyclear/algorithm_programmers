package com.programmers.algorigm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * n	result
 * 4	[1,2,9,3,10,8,4,5,6,7]
 * 5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
 * 6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
 * 처음 nthSolution 방식은 n 이 7까지 그려봤을때 뭔가 숫자의 규칙을 찾을 수 있다고 생각함. 예를 들어 n 이 늘어 날수록 앞뒤 값의 합은 3n - 1
 * 이렇다거나 n-1 번째 는 이전 피라미드 마지막층의 3(n-2) 의 값을 가지고, 그외에는 이전 피라미드에서 +3 씩 해주면 된다고 생각하여, 그렇게 풀었었다.
 */
public class TriangleDalpang {
    public int[] solution(int n) {
        int answerLength = 0;
        for (int i = 1; i <= n; i++) {
            answerLength += i;
        }
        int[] answer = new int[answerLength];
        int index = 0;
        int startValue = 1;
        Map<String, Object> parameter = makeParameter(index, startValue, answer, n, 1);
        int moveCount = n;
        while(moveCount > 0) {
            parameter = moveUp(moveRight(moveDown(parameter)));
            moveCount = (int) parameter.get("moveCount");
        }

        return (int[]) parameter.get("answer");
    }

    public Map<String, Object> moveDown(Map<String, Object> param) {
        int startIndex = (int) param.get("startIndex");
        int startValaue = (int) param.get("startValue");
        int[] answer = (int[]) param.get("answer");
        int moveCount = (int) param.get("moveCount");
        int floor = (int) param.get("floor");
        if (moveCount == 0) {
            return param;
        }

        for (int i = 0; i < moveCount; i++) {
            answer[startIndex] = startValaue;
            startValaue++;
            if(!(i == moveCount - 1)) {
                startIndex += floor;
                floor++;
            }
        }

        moveCount--;
        startIndex = startIndex + 1;
        return makeParameter(startIndex, startValaue, answer, moveCount, floor);
    }

    public Map<String, Object> moveRight(Map<String, Object> param) {
        int startIndex = (int) param.get("startIndex");
        int startValaue = (int) param.get("startValue");
        int[] answer = (int[]) param.get("answer");
        int moveCount = (int) param.get("moveCount");
        int floor = (int) param.get("floor");
        if (moveCount == 0) {
            return param;
        }

        for (int i = 0; i < moveCount; i++) {
            answer[startIndex] = startValaue;
            startValaue++;
            if(!(i == moveCount-1)) {
                startIndex++;
            }
        }

        moveCount--;
        startIndex = startIndex - floor;
        return makeParameter(startIndex, startValaue, answer, moveCount, floor - 1);
    }

    public Map<String, Object> moveUp(Map<String, Object> param) {
        int startIndex = (int) param.get("startIndex");
        int startValaue = (int) param.get("startValue");
        int[] answer = (int[]) param.get("answer");
        int moveCount = (int) param.get("moveCount");
        int floor = (int) param.get("floor");

        if (moveCount == 0) {
            return param;
        }

        for (int i = 0; i < moveCount; i++) {
            answer[startIndex] = startValaue;
            startValaue++;
            if(!(i == moveCount - 1)) {
                startIndex -= floor;
                floor--;
            }
        }
        moveCount--;
        startIndex = startIndex + floor++;

        return makeParameter(startIndex, startValaue, answer, moveCount, floor);
    }

    public Map<String, Object> makeParameter(int index, int startValue, int[] answer, int n, int floor) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("startIndex", index);
        parameter.put("startValue", startValue);
        parameter.put("answer", answer);
        parameter.put("moveCount", n);
        parameter.put("floor", floor);

        return parameter;
    }

    public int[] getNthSolution(int n) {
        int answerLength = 0;

        if (n == 1) {
            return new int[]{1};
        } else if (n == 2) {
            return new int[]{1, 2, 3};
        }

        for (int i = 1; i <= n; i++) {
            answerLength += i;
        }

        int[] preAnswer = getNthSolution(n - 1);
        int[] answer = new int[answerLength];
        int floor = 2;
        answer[0] = 1;
        int j = 1;
        int floorLastIndex = 0;
        for (int i = 1; i < preAnswer.length; i++) {
            if (preAnswer[i] != floor && i != floorLastIndex && floor == n - 1) {
                answer[i] = preAnswer[i] + 3 * (n - 2);
                continue;
            }

            if (preAnswer[i] == floor) {
                answer[i] = preAnswer[i];
                floorLastIndex = floorLastIndex + floor;
            } else if (i == floorLastIndex) {
                answer[i] = preAnswer[i] + 3;
                floor++;
                j = 1;
            } else {
                answer[i] = preAnswer[i] + 3 * j;
                j++;
            }
        }

        int lastStartValue = n;
        for (int i = answerLength - n; i < answerLength; i++) {
            answer[i] = lastStartValue;
            lastStartValue++;
        }
        return answer;
    }
}
