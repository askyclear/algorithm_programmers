package com.programmers.algorigm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(Arrays.toString(solution2(info, query)));

        int n = 5;
        int lost[] = {2, 4};
        int reserve[] = {3};
        String[] data = {"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        String[] data2 = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        String[] data3 = {"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s", "2016-09-15 01:00:04.003 0.001s"};
        KakaoLv3 kakaoLv3 = new KakaoLv3();

        kakaoLv3.solution(data3);
        kakaoLv3.solution(data);
        kakaoLv3.solution(data2);

    }





    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];
        for (int i = 1; i <= yellow / i; i++) {
            if (yellow % i == 0) {
                if (total == (2 + (yellow / i)) * (2 + i)) {
                    answer[0] = (2 + (yellow / i));
                    answer[1] = 2 + i;
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] solution2(String[] info, String[] query) {
        int[] answer = new int[query.length];

        int answerIndex = 0;

        for (String condition : query) {
            String[] splitCondition = condition.split(" ");

            String lang = splitCondition[0];
            String bfEnd = splitCondition[2];
            String jSnior = splitCondition[4];
            String food = splitCondition[6];
            int score = Integer.parseInt(splitCondition[7]);
            int count = 0;
            for (int i = 0; i < info.length; i++) {
                String[] splited = info[i].split(" ");

                if (!lang.equals("-") && !lang.equals(splited[0])) {
                    continue;
                }

                if (!bfEnd.equals("-") && !bfEnd.equals(splited[1])) {
                    continue;
                }

                if (!jSnior.equals("-") && !jSnior.equals(splited[2])) {
                    continue;
                }

                if (!food.equals("-") && !food.equals(splited[3])) {
                    continue;
                }

                if (Integer.parseInt(splited[4]) < score) {
                    continue;
                }

                count++;
            }
            answer[answerIndex] = count;

            answerIndex++;
        }

        return answer;
    }


}