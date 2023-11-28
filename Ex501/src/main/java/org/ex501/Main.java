package org.ex501;

import org.ex501.processor.PropertiesParser;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File dir = new File(scanner.next());
        PropertiesParser parser = new PropertiesParser(dir);
        parser.parse();
        System.out.println(parser.getProperties());
    }
}
