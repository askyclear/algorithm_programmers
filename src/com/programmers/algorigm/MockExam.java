package com.programmers.algorigm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 문제 설명
 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

 제한 조건
 시험은 최대 10,000 문제로 구성되어있습니다.
 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 입출력 예
 answers	return
 [1,2,3,4,5]	[1]
 [1,3,2,4,2]	[1,2,3]
 입출력 예 설명
 입출력 예 #1

 수포자 1은 모든 문제를 맞혔습니다.
 수포자 2는 모든 문제를 틀렸습니다.
 수포자 3은 모든 문제를 틀렸습니다.

 */
public class MockExam {
    public int[] solution(int[] answers) {
        List<Integer> firstRankerIds = new ArrayList<>();
        
        Giver giver1 = new Giver(new int[]{1,2,3,4,5}, 1);
        Giver giver2 = new Giver(new int[]{2,1,2,3,2,4,2,5}, 2);
        Giver giver3 = new Giver(new int[]{3,3,1,1,2,2,4,4,5,5}, 3);

        for (int i = 0; i < answers.length; i++) {
            giver1.grade(i, answers[i]);
            giver2.grade(i, answers[i]);
            giver3.grade(i, answers[i]);
        }

        PriorityQueue<Giver> rankingQueue = new PriorityQueue<>(Comparator.comparingInt(Giver::getCorrectCount).reversed());

        rankingQueue.add(giver1);
        rankingQueue.add(giver2);
        rankingQueue.add(giver3);

        int maxCorrectCount = 0;

        do {
            Giver giver = rankingQueue.poll();
            maxCorrectCount = giver.getCorrectCount();
            firstRankerIds.add(giver.getId());

        } while (!rankingQueue.isEmpty() && rankingQueue.peek().getCorrectCount() == maxCorrectCount);

        firstRankerIds.sort(Integer::compareTo);

        return firstRankerIds.stream().mapToInt(Integer::intValue).toArray();
    }

    private class Giver {
        private final int[] pattern;
        private final int id;
        private int correctCount;

        public Giver(int[] pattern, int id) {
            this.pattern = pattern;
            this.id = id;
        }
        int getId() {
            return this.id;
        }
        void grade(int problemNumber, int answer) {
            if (pattern[problemNumber % pattern.length] == answer) {
                this.correctCount++;
            }
        }

        int getCorrectCount() {
            return correctCount;
        }
    }
}
