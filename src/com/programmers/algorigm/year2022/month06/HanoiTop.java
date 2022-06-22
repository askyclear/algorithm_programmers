package com.programmers.algorigm.year2022.month06;

import java.util.ArrayList;
import java.util.List;

public class HanoiTop {
    public int[][] solution(int n) {
        List<int[]> paths = new ArrayList<>();
        hanoi(n, 1, 3, 2, paths);

        return paths.toArray(new int[0][]);
    }

    public void hanoi(int n, int from_pos, int to_pos, int temp_pos, List<int[]> paths) {
        if (n == 1) {
            paths.add(new int[]{from_pos, to_pos});
            return;
        }
        hanoi(n - 1, from_pos, temp_pos, to_pos, paths);
        paths.add(new int[]{from_pos, to_pos});
        hanoi(n - 1, temp_pos, to_pos, from_pos, paths);
    }
}
