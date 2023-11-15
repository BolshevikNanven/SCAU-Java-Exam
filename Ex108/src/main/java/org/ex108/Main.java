package org.ex108;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringBuffer output = new StringBuffer(input);
        output.reverse();

        Integer len = input.length()-1;

        while (len >= 0) {
            if (input.charAt(len) != output.charAt(len)) {
                break;
            }
            len--;
        }

        if (len < 0) {
            System.out.println(input + "是回文整数");
        } else {
            System.out.println(input + "不是回文整数");
        }


    }
}
