package com.programmers.algorigm.year2022.month04;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            char[] binaryString1 = getBinary(1, n, arr1[i]).toCharArray();
            char[] binaryString2 = getBinary(1, n, arr2[i]).toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(Character.digit(binaryString1[j], 10) + Character.digit(binaryString2[j], 10) > 0 ? "#" : " ");
            }
            answer[i] = stringBuilder.toString();
        }
        return answer;
    }

    private String getBinary(int depth, int maxDepth, int number) {
        if (depth == maxDepth) {
            return String.valueOf(number % 2);
        }

        return getBinary(depth + 1, maxDepth, number / 2) + String.valueOf(number % 2);
    }
}
