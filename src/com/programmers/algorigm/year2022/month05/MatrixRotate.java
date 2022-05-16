package com.programmers.algorigm.year2022.month05;

public class MatrixRotate {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                matrix[i][j]=((i) * columns + j + 1);
            }
        }
        for(int i =0; i< queries.length; i++) {
            answer[i] = rotate(queries[i], matrix);
        }
        return answer;
    }

    private int rotate(int[] query, int[][] matrix) {
        int startX = query[0] - 1;
        int startY = query[1] - 1;
        int endX = query[2] - 1;
        int endY = query[3] - 1;
        int temp = matrix[startX][startY];
        int min = temp;

        for (int i = startY + 1; i < endY; i++) {
            int temp1 = matrix[startX][i];
            matrix[startX][i] = temp;
            temp = temp1;
            min = Math.min(min, temp);
        }

        for (int i = startX; i < endX; i++) {
            int temp1 = matrix[i][endY];
            matrix[i][endY]= temp;
            temp = temp1;
            min = Math.min(min, temp);
        }

        for(int i = endY; i > startY; i--) {
            int temp1 = matrix[endX][i];
            matrix[endX][i] = temp;
            temp = temp1;
            min = Math.min(min, temp);
        }

        for(int i = endX; i >= startX; i--) {
            int temp1 = matrix[i][startY];
            matrix[i][startY]= temp;
            temp = temp1;
            min = Math.min(min, temp);
        }
        return min;
    }
}
