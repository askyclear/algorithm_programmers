package com.programmers.algorigm.year2022.month03;

public class Network {
    public int solution(int n, int[][] computers) {
        int networkCount = 0;

        boolean[] connected = new boolean[n];

        for (int computerNumber = 0; computerNumber < n; computerNumber++) {
            if (!connected[computerNumber]) {
                connectComputer(computers, computerNumber, connected);
                networkCount++;
            }
        }

        return networkCount;
    }

    private boolean[] connectComputer(int[][] computers, int computerNumber, boolean[] connected) {
        connected[computerNumber] = true;

        for (int otherComputerNumber = 0; otherComputerNumber < computers.length; otherComputerNumber++) {
            if (computerNumber != otherComputerNumber && computers[computerNumber][otherComputerNumber] == 1 && connected[otherComputerNumber] == false) {
                connected = connectComputer(computers, otherComputerNumber, connected);
            }
        }

        return connected;
    }
}
