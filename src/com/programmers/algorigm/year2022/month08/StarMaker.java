package com.programmers.algorigm.year2022.month08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StarMaker {
    private static final String DOT = ".";
    private static final String STAR = "*";
    private long minX = Long.MAX_VALUE;
    private long minY = Long.MAX_VALUE;
    private long maxX = Long.MIN_VALUE;
    private long maxY = Long.MIN_VALUE;

    public String[] solution(int[][] line) {
        Set<Point> pSet = new HashSet<>();

        long x;
        long y;
        for (int i = 0; i < line.length - 1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long adbc = a * d - b * c;
                if (adbc == 0) {
                    continue;
                }

                long bfed = b * f - e * d;
                if (bfed % adbc != 0) {
                    continue;
                }

                long ecaf = e * c - a * f;
                if (ecaf % adbc != 0) {
                    continue;
                }

                x = bfed / adbc;
                y = ecaf / adbc;
                pSet.add(new Point(x, y));

                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }

        long height = maxY - minY + 1;
        long width = maxX - minX + 1;

        String[] answer = new String[(int) height];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < width; i++) {
            sb.append(DOT);
        }

        Arrays.fill(answer, sb.toString());

        long nx;
        long ny;

        for (Point p : pSet) {
            ny = maxY - p.getY();
            nx = p.getX() - minX;
            answer[(int) ny] = answer[(int) ny].substring(0, (int) nx) + STAR
                    + answer[(int) ny].substring((int) nx + 1);
        }

        return answer;
    }

    private class Point {
        private long x;

        private long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }
    }
}
