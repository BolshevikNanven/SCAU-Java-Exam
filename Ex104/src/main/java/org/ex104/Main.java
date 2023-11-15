package org.ex104;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point[] points = new Point[3];
        for (Integer i = 0; i < 3; i++) {
            Double x = scanner.nextDouble();
            Double y = scanner.nextDouble();

            points[i]=new Point();
            points[i].setLocation(x, y);

        }

        Double a = points[0].distance(points[1]);
        Double b = points[1].distance(points[2]);
        Double c = points[2].distance(points[0]);

        Double s = (a + b + c) / 2.0;
        Double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        System.out.printf("area=%.2f", area);
    }
}
