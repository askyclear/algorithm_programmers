package com.programmers.algorigm;

import java.util.Stack;

public class RemoveByPair {
    public int solution(String s) {
        Stack<Character> pairStack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char compareChar = s.charAt(i);
            if (!pairStack.isEmpty() && pairStack.peek() == compareChar) {
                pairStack.pop();
            } else {
                pairStack.push(compareChar);
            }
        }

        return pairStack.isEmpty() ? 1 : 0;
    }
}
