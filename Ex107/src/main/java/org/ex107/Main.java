package org.ex107;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("不正确的输入");
        } else {
            double e = 1.0;
            for (int i = 1; i <= n; i++) {
                double a = 1.0 / factorial(i);
                e += Double.isFinite(a) ? a : 0.0;
            }

            System.out.printf("%.8f", e);

        }
    }

    private static int factorial(int i) {
        int sum = 1;
        while (i >= 1) {
            sum = sum * i;
            i--;
        }
        return sum;
    }
}
