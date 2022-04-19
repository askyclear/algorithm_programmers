package com.programmers.algorigm.year2022.month04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximizeFormulas {
    private char plus = "+".charAt(0);
    private char minus = "-".charAt(0);
    private char mul = "*".charAt(0);
    private char[] operand = new char[]{plus, minus, mul};
    private boolean[] isVisited = new boolean[]{false,false,false};

    public long solution(String expression) {
        List<Long> numberStack = new ArrayList<>();
        List<String> operandStack = new ArrayList<>();
        String number = "";
        int lastOperandIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            char charExpression = expression.charAt(i);
            if (Character.isDigit(charExpression)) {
                number += Character.toString(charExpression);
            } else {
                numberStack.add(Long.parseLong(number));
                operandStack.add(Character.toString(charExpression));
                lastOperandIndex = i + 1;
                number = "";
            }
        }

        numberStack.add(Long.parseLong(expression.substring(lastOperandIndex)));


        return dfs(0, new ArrayList<>(), numberStack, operandStack);
    }

    private long dfs(int depth, List<String> priorityOperand,List<Long> numberList, List<String> operandList) {
        long answer = 0;
        if (depth == 3) {
            return calculate(priorityOperand, numberList, operandList);
        } else {
            for (int i = 0; i < operand.length; i++) {
                if (!isVisited[i]) {
                    List<String> tempOperand = new ArrayList<>(priorityOperand);
                    tempOperand.add(Character.toString(operand[i]));
                    isVisited[i] = true;
                    answer = Math.max(answer, dfs(depth + 1, tempOperand, numberList, operandList));
                    isVisited[i] = false;
                }
            }
        }

        return answer;
    }

    private long calculate(List<String> priorityOperand, List<Long> numberList, List<String> operandList) {
        List<Long> copyNumberList = new ArrayList<>(numberList);
        List<String> copyOperandList = new ArrayList<>(operandList);
        for (int i = 0; i < priorityOperand.size(); i++) {
            String curOperand = priorityOperand.get(i);
            for (int j = 0; j < copyOperandList.size(); j++) {
                if (!copyOperandList.get(j).equals(curOperand)) {
                    continue;
                }
                long preNum = copyNumberList.get(j);
                long nextNum = copyNumberList.get(j + 1);
                long tempNumb = calcurateExp(curOperand.charAt(0), preNum, nextNum);

                copyNumberList.remove(j + 1);
                copyNumberList.remove(j);
                copyNumberList.add(j, tempNumb);
                copyOperandList.remove(j);
                j--;
            }
        }
        return Math.abs(copyNumberList.get(0));
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
