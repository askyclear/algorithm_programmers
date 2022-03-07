package com.programmers.algorigm;

import java.util.Arrays;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dpTriangle = new int[height][];
        dpTriangle[0] = new int[]{triangle[0][0]};

        for (int i = 1; i < triangle.length; i++) {
            dpTriangle[i] = new int[triangle[i].length];
            for(int j = 0; j < triangle[i].length; j++) {
                int preN = i - 1;
                int leftX = Math.max(j - 1, 0);
                int rightX = Math.min(j, dpTriangle[preN].length - 1);
                dpTriangle[i][j] = Math.max(dpTriangle[preN][leftX], dpTriangle[preN][rightX]) + triangle[i][j];
            }
        }

        return Arrays.stream(dpTriangle[height - 1]).max().orElse(0);
    }
}
