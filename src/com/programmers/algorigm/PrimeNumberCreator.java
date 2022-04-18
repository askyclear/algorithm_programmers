package com.programmers.algorigm;

import java.util.Arrays;

public class PrimeNumberCreator {
    public int solution(int[] nums) {
        return dfs(0, 0, nums);
    }
    private int dfs(int depth, int addedNum, int[] nums) {
        int answer = 0;

        if (depth == 2) {
            for (int i = 0; i < nums.length; i++) {
                answer += isPrimeNumber(addedNum + nums[i]) ? 1 : 0;
            }
            return answer;
        }

        for (int i = 0; i < nums.length; i++) {
            answer += dfs(depth + 1, addedNum + nums[i], Arrays.copyOfRange(nums, i + 1, nums.length));
        }

        return answer;
    }

    private boolean isPrimeNumber(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
