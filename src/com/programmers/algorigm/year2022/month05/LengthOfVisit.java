package com.programmers.algorigm.year2022.month05;

import java.util.HashSet;
import java.util.Set;

public class LengthOfVisit {
    public int solution(String dirs) {
        Set<String> visitor = new HashSet<>();
        int curX = 0;
        int curY = 0;

        for(int i = 0; i < dirs.length(); i++) {
            String command = Character.toString(dirs.charAt(i));
            if (command.equals("U") && curY != 5) {
                visitor.add(curX + "" + curY +"" + curX + "" + (curY + 1));
                curY++;
            } else if(command.equals("D") && curY != -5) {
                visitor.add(curX + "" + (curY - 1) +"" + curX + "" + curY);
                curY--;
            } else if(command.equals("L") && curX != -5) {
                visitor.add((curX - 1) + "" + curY +"" + curX + "" + curY);
                curX--;
            } else if(command.equals("R") && curX != 5) {
                visitor.add(curX + "" + curY +"" + (curX + 1) + "" + curY);
                curX++;
            }
        }

        return visitor.size();
    }
}

