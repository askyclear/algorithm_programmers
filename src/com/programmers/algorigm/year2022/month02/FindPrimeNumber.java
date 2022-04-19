package com.programmers.algorigm.year2022.month02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPrimeNumber {
    public int solution(String numbers) {
        Set<Integer> primeNumberSet = new HashSet<>();
        List<String> splitNumberStrings = new ArrayList<>();

        for(int i = 0; i < numbers.length(); i++) {
            splitNumberStrings.add(numbers.substring(i, i + 1));
        }

        makeOtherNumber(primeNumberSet, "", splitNumberStrings);

        return primeNumberSet.size();
    }
    public void makeOtherNumber(Set<Integer> primeNumberSet, String preString, List<String> splitNumbers) {
        for (int i = 0; i< splitNumbers.size(); i++) {
            List<String> copiedList = new ArrayList<>(splitNumbers);

            String combineString = preString + copiedList.get(i);
            int parseNumber = Integer.parseInt(combineString);
            if (isPrimeNumber(parseNumber)) {
                primeNumberSet.add(Integer.parseInt(combineString));
            }
            copiedList.remove(i);
            makeOtherNumber(primeNumberSet, combineString, copiedList);
        }
    }
    public boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for(int i = 2; i < number; i++) {
           if(number % i == 0) {
               return false;
           }
        }
        return true;
    }
}
