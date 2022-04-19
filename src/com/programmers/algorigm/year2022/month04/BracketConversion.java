package com.programmers.algorigm.year2022.month04;

import java.util.Stack;

public class BracketConversion {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }

        if (isBraketConversion(p)) {
            return p;
        }

        String[] test = splitUV(p);
        if (isBraketConversion(test[0])) {
            return test[0] + solution(test[1]);
        } else {
            String temp = test[0].substring(1, test[0].length() - 1);

            return "(" + solution(test[1]) + ")" + convertBracket(temp);
        }
    }

    private String convertBracket(String temp) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < temp.length(); i++) {
            String a = temp.substring(i, i + 1);
            if (a.equals("(")) {
                stringBuilder.append(")");
            } else {
                stringBuilder.append("(");
            }
        }

        return stringBuilder.toString();
    }

    private String[] splitUV(String str) {
        String u = "";
        String v = "";
        int splitIndex = str.length();
        Stack<String> stack = new Stack<>();
        stack.push(str.substring(0, 1));

        for (int i = 1; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if (stack.isEmpty()) {
                splitIndex = i;
                break;
            }
            if (!stack.peek().equals(temp)) {
                stack.pop();
            } else {
                stack.push(temp);
            }
        }

        u = str.substring(0, splitIndex);
        v = str.substring(splitIndex);
        return new String[]{u, v};
    }

    private boolean isBraketConversion(String str) {
        Stack<String> stack = new Stack<>();
        String startStr = str.substring(0, 1);

        if (startStr.equals(")")) {
            return false;
        }

        stack.push(startStr);

        for (int i = 1; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if (stack.isEmpty() && temp.equals(")")) {
                return false;
            }
            if (!stack.isEmpty() && temp.equals(")")) {
                stack.pop();
            } else if (temp.equals("(")) {
                stack.push(temp);
            }
        }

        return stack.isEmpty();
    }
}
