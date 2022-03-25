package com.programmers.algorigm;

public class Kakao2020Keypad {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int currentLeftHand = 9;
        int currentRightHand = 11;
        for(int number : numbers) {
            int padIndex = number == 0 ? 10 : number - 1;
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
