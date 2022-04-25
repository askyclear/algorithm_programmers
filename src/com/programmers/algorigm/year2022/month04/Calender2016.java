package com.programmers.algorigm.year2022.month04;

public class Calender2016 {
    private static int[] dayRangeOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
    private static String[] dayOfWeek = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    
    public String solution(int a, int b) {
        int days = b;

        for (int i = 0 ; i < a - 1; i++) {
            days += dayRangeOfMonth[i];
        }

        return dayOfWeek[days % 7];
    }
}
