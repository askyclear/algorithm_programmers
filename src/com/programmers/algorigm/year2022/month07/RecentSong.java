package com.programmers.algorigm.year2022.month07;

public class RecentSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String rememberMelody = changeMelody(m);
        int maxPlayTime = 0;
        for (String musicInfo : musicinfos) {
            String[] info = musicInfo.split(",");
            String[] startTime = info[0].split(":");
            int startMinute = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            String[] endTime = info[1].split(":");
            int endTimeMinute = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
            String musicSheet = changeMelody(info[3]);
            int playTime = endTimeMinute - startMinute;
            //반복
            String musicInfoMelody = "";
            if (playTime > musicSheet.length()) {
                for (int i = 0; i < playTime / musicSheet.length(); i++) {
                    musicInfoMelody = musicInfoMelody + musicSheet;
                }
                musicInfoMelody = musicInfoMelody + musicSheet.substring(0, playTime % musicSheet.length());

            } else {
                musicInfoMelody = musicSheet.substring(0, playTime);
            }

            if (musicInfoMelody.contains(rememberMelody) && playTime > maxPlayTime) {
                answer = info[2];
                maxPlayTime = playTime;
            }
        }

        return maxPlayTime > 0 ? answer : "(None)";
    }

    private String changeMelody(String originMelody) {
        return originMelody.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }
}
