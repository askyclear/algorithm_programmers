package com.programmers.algorigm.year2022.month05;

import java.util.Stack;

public class ProperBracketString {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            String movedStr = s.substring(0, i);
            String preStr = s.substring(i);
            answer = answer + (isProperBracket(preStr + movedStr) ? 1 : 0);
        }
        return answer;
    }

    private boolean isProperBracket(String s) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            String curBracket = s.substring(i, i + 1);
            if (curBracket.equals("{") || curBracket.equals("[") || curBracket.equals("(")) {
                stack.push(curBracket);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if (curBracket.equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                } else if(curBracket.equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                } else if(curBracket.equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
