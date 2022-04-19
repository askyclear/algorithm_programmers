package com.programmers.algorigm.year2022.month03;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return calculate(numbers, 0, target);
    }

    private int calculate(int[] numbers, int depth, int target) {
        if (numbers.length == depth) {
            return target == 0 ? 1 : 0;
        }

        int newPlusTarget = target + numbers[depth];
        int newMinusTarget = target - numbers[depth];

        return calculate(numbers, depth + 1, newPlusTarget) + calculate(numbers, depth + 1, newMinusTarget);
    }
}
