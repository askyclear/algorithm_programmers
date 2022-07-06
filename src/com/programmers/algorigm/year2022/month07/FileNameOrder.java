package com.programmers.algorigm.year2022.month07;

import java.util.Arrays;

public class FileNameOrder {
    public String[] solution(String[] files) {
        FileInfo[] fileInfoList = new FileInfo[files.length];
        for (int i = 0; i < files.length; i++) {
            fileInfoList[i] = new FileInfo(files[i]);
        }
        Arrays.sort(fileInfoList, (o1, o2) -> {
            int headCompare = o1.head.toUpperCase().compareTo(o2.head.toUpperCase());
            int numberCompare = o1.number - o2.number;
            if (headCompare == 0) {
                return numberCompare;
            } else {
                return headCompare;
            }
        });
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileInfoList[i].fullName;
        }
        return answer;
    }

    class FileInfo {
        private String head;
        private int number;
        private String tail;
        private String fullName;

        public FileInfo(String fullName) {
            this.fullName = fullName;
            this.head = "";
            String numberStr = "";
            this.tail = "";
            boolean isFirstText = true;
            boolean isFirstNumber = false;
            for (char text : fullName.toCharArray()) {
                if (isFirstText && Character.isDigit(text)) {
                    isFirstText = false;
                    isFirstNumber = true;
                }

                if (isFirstNumber && !Character.isDigit(text)) {
                    isFirstNumber = false;
                }

                if (isFirstText && !Character.isDigit(text)) {
                    this.head += text;
                } else if (isFirstNumber && Character.isDigit(text)) {
                    numberStr += text;
                } else {
                    this.tail += text;
                }
            }
            this.number = Integer.parseInt(numberStr);
        }
    }
}
