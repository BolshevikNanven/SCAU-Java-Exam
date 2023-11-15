package ex102;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double r = scanner.nextDouble();
        Double h = scanner.nextDouble();

        Double s = Math.PI * r * r;
        Double v = s * h;

        System.out.printf("%.2f", v);

    }
}
