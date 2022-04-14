package com.programmers.algorigm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximizeFormulas {
    private char plus = "+".charAt(0);
    private char minus = "-".charAt(0);
    private char mul = "*".charAt(0);

    public long solution(String expression) {
        long case1 = Math.abs(Long.parseLong(calculate2(mul, calculate2(minus, calculate2(plus, expression)))));
        long case2 = Math.abs(Long.parseLong(calculate2(minus, calculate2(mul, calculate2(plus, expression)))));
        long case3 = Math.abs(Long.parseLong(calculate2(mul, calculate2(plus, calculate2(minus, expression)))));
        long case4 = Math.abs(Long.parseLong(calculate2(plus, calculate2(mul, calculate2(minus, expression)))));
        long case5 = Math.abs(Long.parseLong(calculate2(minus, calculate2(plus, calculate2(mul, expression)))));
        long case6 = Math.abs(Long.parseLong(calculate2(plus, calculate2(minus, calculate2(mul, expression)))));

        return Math.max(Math.max(Math.max(Math.max(Math.max(case1, case2), case3),case4), case5), case6);
    }

    private String calculate2(char exp, String expression) {
        Queue<Long> numberStack = new LinkedList<>();
        Queue<String> operandStack = new LinkedList<>();
        String number = "";
        int lastOperandIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            char charExpression = expression.charAt(i);
            if (Character.isDigit(charExpression)) {
                number += Character.toString(charExpression);
            } else {
                numberStack.add(Long.parseLong(number.isEmpty() ? "0" : number));
                operandStack.add(Character.toString(charExpression));
                lastOperandIndex = i + 1;
                number = "";
            }
        }
        numberStack.add(Long.parseLong(expression.substring(lastOperandIndex)));
        String answer = "";
        while (!numberStack.isEmpty()) {
            long preDigit = numberStack.poll();
            String operand = operandStack.isEmpty() ? "" : operandStack.poll();
            if (!operand.isEmpty() && operand.charAt(0) == exp) {
                Queue<Long> tempQueue = new LinkedList<>();
                tempQueue.add(calcurateExp(exp, preDigit, numberStack.poll()));
                tempQueue.addAll(numberStack);
                numberStack.clear();
                numberStack.addAll(tempQueue);
            } else {
                answer = answer + (preDigit == 0L ? "" : preDigit + operand);
            }
        }
        return answer;
    }


    private long calcurateExp(char exp, long a, long b) {
        if (Character.toString(exp).equals("*")) {
            return a * b;
        }
        if (Character.toString(exp).equals("-")) {
            return a - b;
        }
        return a + b;
    }
}
