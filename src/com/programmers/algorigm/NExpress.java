package com.programmers.algorigm;

import java.util.*;

public class NExpress {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        String nString = String.valueOf(N);
        StringBuilder repeatString = new StringBuilder(nString);
        List<Set<Integer>> expressList = new ArrayList<>();
        Set<Integer> firstExpress = new HashSet<>();
        firstExpress.add(N);
        expressList.add(firstExpress);

        Set<Integer> secondExpress = new HashSet<>();
        repeatString.append(nString);
        secondExpress.add(Integer.parseInt(repeatString.toString()));
        secondExpress.add(N * N);
        secondExpress.add(1);
        secondExpress.add(0);
        secondExpress.add(2 * N);
        expressList.add(secondExpress);

        for (int i = 2; i <= 8; i++) {
            Set<Integer> expressNumber = new HashSet<>();

            Set<Integer> preExpressNumber = expressList.get(i - 1);
            Optional<Integer> findNumber = preExpressNumber.stream().filter(integer -> integer == number).findFirst();

            if (findNumber.isPresent()) {
                return i;
            }

            if (i < 8) {
                repeatString.append(nString);
                expressNumber.add(Integer.parseInt(repeatString.toString()));

                for (int j = 0; j < i / 2; j++) {
                    Set<Integer> firstExpressNumber = expressList.get(j);
                    Set<Integer> secondExpressNumber = expressList.get(i - j - 1);

                    for (Integer firstNumber : firstExpressNumber) {
                        for (Integer secondNumber : secondExpressNumber) {
                            expressNumber.add(firstNumber + secondNumber);
                            expressNumber.add(firstNumber - secondNumber);
                            expressNumber.add(firstNumber * secondNumber);
                            if (secondNumber > 0) {
                                expressNumber.add(firstNumber / secondNumber);
                            }

                            expressNumber.add(secondNumber - firstNumber);
                            if (firstNumber > 0) {
                                expressNumber.add(secondNumber / firstNumber);
                            }
                        }
                    }
                }

                expressList.add(expressNumber);
            }
        }

        return -1;
    }

}
