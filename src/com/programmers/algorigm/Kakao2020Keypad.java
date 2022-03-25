package com.programmers.algorigm;

import java.util.HashMap;
import java.util.Map;

public class Kakao2020Keypad {
    private static final Map<Integer, Integer> keypad = new HashMap<>();
    static {
        keypad.put(1, 0);
        keypad.put(2, 1);
        keypad.put(3, 2);
        keypad.put(4, 3);
        keypad.put(5, 4);
        keypad.put(6, 5);
        keypad.put(7, 6);
        keypad.put(8, 7);
        keypad.put(9, 8);
        keypad.put(0, 10);
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int currentLeftHand = 9;
        int currentRightHand = 11;
        for(int number : numbers) {
            int padIndex = keypad.get(number);
            int n = padIndex / 3;
            int mod = padIndex % 3;

            if (mod == 0) {
                answer.append("L");
                currentLeftHand = 3 * n;
            } else if (mod == 1) {
                int leftHandLength = Math.abs(n - (currentLeftHand / 3)) + Math.abs(mod - (currentLeftHand % 3));
                int rightHandLength = Math.abs(n - (currentRightHand / 3)) + Math.abs(mod - (currentRightHand % 3));
                int nextIndex =  3 * n + 1;

                if (leftHandLength < rightHandLength) {
                    answer.append("L");
                    currentLeftHand = nextIndex;
                } else if (leftHandLength > rightHandLength) {
                    answer.append("R");
                    currentRightHand = nextIndex;
                } else if (hand.equals("right")){
                    answer.append("R");
                    currentRightHand = nextIndex;
                } else {
                    answer.append("L");
                    currentLeftHand = nextIndex;
                }

            } else {
                answer.append("R");
                currentRightHand = 3 * n + 2;
            }
        }

        return answer.toString();
    }
}
