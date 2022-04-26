package com.programmers.algorigm.year2022.month04;

public class MinRectangle {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for(int[] size : sizes) {
            int tempWidth = Math.max(size[0], size[1]);
            int tempHeight = Math.min(size[0], size[1]);
            maxWidth = Math.max(maxWidth, tempWidth);
            maxHeight = Math.max(maxHeight, tempHeight);
        }

        return maxWidth * maxHeight;
    }
}
