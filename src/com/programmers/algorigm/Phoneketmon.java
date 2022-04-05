package com.programmers.algorigm;

import java.util.HashMap;
import java.util.Map;

public class Phoneketmon {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> ketmonMap = new HashMap<>();
        for (int num : nums) {
            ketmonMap.put(num, ketmonMap.getOrDefault(num, 0) + 1);
        }


        return Math.min(nums.length / 2, ketmonMap.size());
    }

    public int solution2(int[] nums) {
        int answer = 0;
        int maxChoiceCount = nums.length / 2;
        Map<Integer, Integer> ketmonMap = new HashMap<>();
        for (int num : nums) {
            int count = ketmonMap.getOrDefault(num, 0);
            if (count == 0) {
                answer++;
                if(answer > maxChoiceCount) {
                    return maxChoiceCount;
                }
            }
            ketmonMap.put(num,  count + 1);
        }


        return answer;
    }
}
