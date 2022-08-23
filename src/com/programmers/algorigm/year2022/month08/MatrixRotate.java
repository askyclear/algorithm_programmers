package com.programmers.algorigm.year2022.month08;

public class MatrixRotate {
    public int[][] solution(int[][] rc, String[] operations) {
        int repeat = 1;
        String operation = operations[0];
        for (int i = 1; i < operations.length; i++) {
            if (operations[i].equals(operation)) {
                repeat++;
            } else {
                if (operation.equals("Rotate")) {
                    rc = rotate(rc, repeat);
                } else {
                    rc = shiftRow(rc, repeat);
                }
                operation = operations[i];
                repeat = 1;
            }
        }
        if (operation.equals("Rotate")) {
            rc = rotate(rc, repeat);
        } else {
            rc = shiftRow(rc, repeat);
        }

        return rc;
    }

    public int[][] shiftRow(int[][] rc, int count) {
        int length = rc.length;
        int shiftCount = count % length;

        if (shiftCount == 0) {
            return rc;
        }

        rc = reverseRotate(rc, 0, length - 1);
        rc = reverseRotate(rc, 0, shiftCount - 1);
        rc = reverseRotate(rc, shiftCount, length - 1);
        return rc;
    }

    public int[][] reverseRotate(int[][] rc, int start, int end) {
        int[][] temp = new int[end - start + 1][rc[0].length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rc[start + i];
        }
        for (int i = start; i <= end; i++) {
            rc[i] = temp[end - i];
        }

        return rc;
    }

    public int[] reverseRotate(int[] rc, int start, int end) {
        int[] temp = new int[end - start + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rc[start + i];
        }
        for (int i = start; i <= end; i++) {
            rc[i] = temp[end - i];
        }

        return rc;
    }

    public int[][] rotate(int[][] rc, int count) {
        int[] oneRc = makeArr(rc);
        int length = oneRc.length;
        int shiftCount = count % length;
        oneRc = reverseRotate(oneRc, 0, length - 1);
        oneRc = reverseRotate(oneRc, 0, shiftCount - 1);
        oneRc = reverseRotate(oneRc, shiftCount, length - 1);

        return setArr(rc, oneRc);
    }

    private int[][] setArr(int[][] rc, int[] oneRc) {
        int width = rc[0].length;
        int height = rc.length;
        int index = 0;
        for (int i = 0; i < width; i++) {
            rc[0][i] = oneRc[index];
            index++;
        }
        for (int i = 1; i < height; i++) {
            rc[i][width - 1] = oneRc[index];
            ;
            index++;
        }
        for (int i = 1; i < width; i++) {
            rc[height - 1][width - 1 - i] = oneRc[index];
            ;
            index++;
        }
        for (int i = 1; i < height - 1; i++) {
            rc[height - 1 - i][0] = oneRc[index];
            index++;
        }

        return rc;
    }

    public int[] makeArr(int[][] rc) {
        int width = rc[0].length;
        int height = rc.length;
        int[] arr = new int[width * height - Math.max(width - 2, 0) * Math.max(height - 2, 0)];
        int index = 0;
        for (int i = 0; i < width; i++) {
            arr[index] = rc[0][i];
            index++;
        }
        for (int i = 1; i < height; i++) {
            arr[index] = rc[i][width - 1];
            index++;
        }
        for (int i = 1; i < width; i++) {
            arr[index] = rc[height - 1][width - 1 - i];
            index++;
        }
        for (int i = 1; i < height - 1; i++) {
            arr[index] = rc[height - 1 - i][0];
            index++;
        }

        return arr;
    }
}
