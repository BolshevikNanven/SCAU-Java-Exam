package org.ex105;

import java.util.Scanner;

public class Main {
    static int year;
    static int firstDay;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        year = scanner.nextInt();
        firstDay = scanner.nextInt();

        if (year <= 0 || firstDay < 0 || firstDay > 6) {
            System.out.println("不正确的输入");
        } else {
            renderDays();
        }

    }

    public static void renderDays() {
        Boolean leapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int[] mouths = new int[]{31, (leapYear ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = 0;
        for (int i = 0; i < 12; i++) {
            System.out.printf("%d ", days % 7 % 7 + firstDay);
            days += mouths[i];

        }

    }

}
