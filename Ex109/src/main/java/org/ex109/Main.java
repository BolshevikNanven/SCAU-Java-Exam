package org.ex109;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        Boolean[] store = new Boolean[n+1];
        Arrays.fill(store, false);

        for (Integer i = 1; i <= n; i++) {
            for (Integer j = i; j <= n; j = j + i) store[j] = !store[j];
        }

        for (Integer i = 1; i <= n; i++) {
            if (store[i]) System.out.print(i + " ");
        }
        ;

    }
}
