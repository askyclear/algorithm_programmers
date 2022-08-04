package com.programmers.algorigm.year2022.month08;

public class GroupPicture {
    private static final char EQUALS = '=';
    private static final char LESS = '<';
    private static final char GRATE = '>';
    private static final char[] people = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public int solution(int n, String[] data) {
        char[] ch = new char[8];
        boolean[] visit = new boolean[8];

        return dfs(0, ch, visit, n, data);
    }

    private int dfs(int k, char[] ch, boolean[] visit, int n, String[] data) {
        int answer = 0;
        if (k == 8) {
            for (int i = 0; i < n; i++) {
                int interval = 0;
                int cnt = 0;
                for (int j = 0; j < 8; j++) {
                    if (ch[j] == data[i].charAt(0) || ch[j] == data[i].charAt(2)) {
                        cnt++;
                        continue;
                    }
                    if (cnt == 1) {
                        interval++;
                    } else if (cnt == 2) {
                        break;
                    }
                }
                int standardDistance = data[i].charAt(4) - '0';
                if (isImpossibleCondition(data[i].charAt(3), standardDistance, interval)) {
                    return 0;
                }
            }

            return 1;
        }

        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                ch[k] = people[i];
                visit[i] = true;
                answer += dfs(k + 1, ch, visit, n, data);
                visit[i] = false;
            }
        }

        return answer;
    }

    private boolean isImpossibleCondition(char condition, int standardDistance, int distance) {
        if (condition == EQUALS && distance != standardDistance) {
            return true;
        } else if (condition == LESS && distance >= standardDistance) {
            return true;
        } else {
            return condition == GRATE && distance <= standardDistance;
        }
    }
}
