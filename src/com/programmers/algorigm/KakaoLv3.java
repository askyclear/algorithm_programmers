package com.programmers.algorigm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class KakaoLv3 {
    public int solution(String[] lines) {
        long millisecondNano = 1000000;
        int answer = 0;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        List<TrafficData> trafficData = new ArrayList<>();

        for (String line : lines) {
            String[] info = line.split(" ");

            LocalDateTime endDate = LocalDateTime.parse(info[0] + " " + info[1], dateTimeFormatter);

            long nanoSecond = (long) (Double.parseDouble(info[2].split("s")[0]) * 1000000000) - millisecondNano;

            LocalDateTime startDate = endDate.minusNanos(nanoSecond);
            trafficData.add(new TrafficData(startDate, endDate));

        }

        for (int currentIndex = 0; currentIndex < trafficData.size(); currentIndex++) {
            TrafficData currentDate = trafficData.get(currentIndex);

            int startedCount = 0;
            int endedCount = 0;

            LocalDateTime startedRangeStartDate = currentDate.getStartDate().minusSeconds(1).plusNanos(millisecondNano);
            LocalDateTime startedRangeEndDate = currentDate.getStartDate();

            LocalDateTime endedRangeStartDate = currentDate.getEndDate();
            LocalDateTime endedRangeEndDate = currentDate.getEndDate().plusSeconds(1).minusNanos(millisecondNano);

            for (int comparedIndex = 0; comparedIndex < trafficData.size(); comparedIndex++) {
                LocalDateTime comparedStartDate = trafficData.get(comparedIndex).getStartDate();
                LocalDateTime comparedEndDate = trafficData.get(comparedIndex).getEndDate();

                if (isBetween(comparedStartDate, startedRangeStartDate, startedRangeEndDate) || isBetween(comparedEndDate, startedRangeStartDate, startedRangeEndDate)) {
                    startedCount++;
                }

                if (isBetween(comparedStartDate, endedRangeStartDate, endedRangeEndDate) || isBetween(comparedEndDate, endedRangeStartDate, endedRangeEndDate)) {
                    endedCount++;
                }
            }

            answer = Math.max(answer, Math.max(startedCount, endedCount));

        }

        return answer;
    }

    public boolean isBetween(LocalDateTime targetDate, LocalDateTime rangeStart, LocalDateTime rangeEnd) {
        return (targetDate.isEqual(rangeStart) || targetDate.isAfter(rangeStart)) && (targetDate.isEqual(rangeEnd) || targetDate.isBefore(rangeEnd));
    }

    private class TrafficData {
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        private TrafficData(LocalDateTime startDate, LocalDateTime endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public LocalDateTime getEndDate() {
            return endDate;
        }

    }
}
