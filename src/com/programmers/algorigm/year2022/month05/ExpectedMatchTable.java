package com.programmers.algorigm.year2022.month05;

public class ExpectedMatchTable {
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int aNum = a;
        int bNum = b;
        while(answer < n) {
            answer++;
            if ((aNum - 1)/ 2 == (bNum -1)/ 2) {
                return answer;
            }
            aNum = (aNum - 1)/ 2 + 1;
            bNum = (bNum - 1)/ 2 + 1;
        }
        return answer;
    }
}
