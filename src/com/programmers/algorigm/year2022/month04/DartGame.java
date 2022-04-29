package com.programmers.algorigm.year2022.month04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;

        Queue<String> dartQueue = new LinkedList<>();
        Stack<Integer> dartStack = new Stack<>();

        String temp = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char tempChar = dartResult.charAt(i);
            if (Character.isDigit(tempChar)) {
                temp += tempChar;
            } else {
                if (!temp.isEmpty()) {
                    dartQueue.add(temp);
                }
                dartQueue.add(String.valueOf(tempChar));
                temp = "";
            }
        }
        while (!dartQueue.isEmpty()) {
            String data = dartQueue.poll();
            if (data.equals("*")) {
                Integer currentNumber = dartStack.pop();
                if (!dartStack.isEmpty()) {
                    Integer preNumber = dartStack.pop();
                    dartStack.push(preNumber * 2);
                }
                dartStack.push(currentNumber * 2);
            } else if (data.equals("#")) {
                Integer currentNumber = dartStack.pop();
                dartStack.push(currentNumber * (-1));
            } else if (data.equals("S")) {
                Integer currentNumber = dartStack.pop();
                dartStack.push(currentNumber);
            } else if (data.equals("D")) {
                Integer currentNumber = dartStack.pop();
                dartStack.push(currentNumber * currentNumber);
            } else if (data.equals("T")) {
                Integer currentNumber = dartStack.pop();
                dartStack.push(currentNumber * currentNumber * currentNumber);
            } else {
                dartStack.push(Integer.valueOf(data));
            }
        }

        while (!dartStack.isEmpty()) {
            answer += dartStack.pop();
        }

        return answer;
    }
}