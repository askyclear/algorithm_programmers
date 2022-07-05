package com.programmers.algorigm.year2022.month07;

import java.util.*;

public class ParkingFee {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTimes = new HashMap<>();
        Map<String, Integer> accumulatedTimes = new HashMap<>();
        List<String> carNumbers = new ArrayList<>();

        for (String record : records) {
            String[] info = record.split(" ");
            String[] timeInfo = info[0].split(":");
            String carNumber = info[1];
            int time = Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
            if (!carNumbers.contains(carNumber)) {
                carNumbers.add(carNumber);
                accumulatedTimes.put(carNumber, 0);
            }

            if (parkingTimes.containsKey(carNumber)) {
                accumulatedTimes.put(carNumber, accumulatedTimes.get(carNumber) + (time - parkingTimes.get(carNumber)));
                parkingTimes.remove(carNumber);
            } else {
                parkingTimes.put(carNumber, time);
            }
        }

        return carNumbers.stream().sorted().mapToInt((carNumber) -> {
            int time = accumulatedTimes.get(carNumber) - fees[0];

            if (parkingTimes.containsKey(carNumber)) {
                time += (1439 - parkingTimes.get(carNumber));
            }
            if (time > 0) {
                return (int) (fees[1] + Math.ceil((float) time / fees[2]) * fees[3]);
            }
            return fees[1];
        }).toArray();
    }
}
