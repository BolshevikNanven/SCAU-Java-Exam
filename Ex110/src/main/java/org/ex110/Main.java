package org.ex110;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer classNum = scanner.nextInt();

        Map<Integer, List<Integer>> classMap = new HashMap<>();

        for (Integer i = 1; i <= classNum; i++) {
            Integer num = scanner.nextInt();
            List<Integer> markList = new ArrayList<>();
            while (num > 0) {
                markList.add(scanner.nextInt());
                num--;
            }

            classMap.put(i, markList);
        }

        for (Integer i = 1; i <= classNum; i++) {
            List<Integer> markList = classMap.get(i);
            Double minMark = markList.get(1) * 1.0, maxMark = markList.get(1) * 1.0, averageMark = 0.0;
            for (Integer mark : markList) {
                if (mark < minMark) minMark = mark * 1.0;
                if (mark > maxMark) maxMark = mark * 1.0;
                averageMark += mark;
            }
            averageMark = averageMark / markList.size();

            System.out.printf("%.2f %.2f %.2f %n", averageMark, maxMark, minMark);

        }

    }
}
