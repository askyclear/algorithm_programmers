package com.programmers.algorigm.year2022.month08;

public class QuadtreeCounter {
    private int oneCount;
    private int zeroCount;

    public int[] solution(int[][] arr) {
        zeroCount = 0;
        oneCount = 0;
        calcCount(0, 0, arr.length, arr);

        return new int[]{zeroCount, oneCount};
    }

    private void calcCount(int x, int y, int length, int[][] info) {
        int temp = info[x][y];
        if (length == 1) {
            if (temp > 0) {
                oneCount++;
            } else {
                zeroCount++;
            }
            return;
        }
        int counter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                counter += info[x + i][y + j];
            }
        }

        if (counter == 0) {
            zeroCount++;
        } else if (counter == length * length) {
            oneCount++;
        } else {
            int modLength = length / 2;
            calcCount(x, y, modLength, info);
            calcCount(x, y + modLength, modLength, info);
            calcCount(x + modLength, y, modLength, info);
            calcCount(x + modLength, y + modLength, modLength, info);
        }
    }
}
