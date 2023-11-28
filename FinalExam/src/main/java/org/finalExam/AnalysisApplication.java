package org.finalExam;

import org.finalExam.analysis.Analyzer;

import java.io.*;
import java.util.Scanner;

public class AnalysisApplication {
    public static void run() {

        while (true) {
            switch (renderMenu()) {
                case 1 -> analysis();
                case 2 -> read();
                case 0 -> {
                    return;
                }
            }
        }

    }

    private static int renderMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------MENU----------");
        System.out.println("1.分析目录中的源程序文件");
        System.out.println("2.查看分析结果");
        System.out.println("0.退出程序");
        System.out.println("------------------------");
        System.out.printf("请选择：");
        return scanner.nextInt();

    }
    private static void analysis(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入目录名：");
        new Analyzer(scanner.next());
    }
    private static void read(){
        Scanner scanner = new Scanner(System.in);
        File file = new File("result");
        file.mkdir();

        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("还没有分析结果！");
            return;
        }

        System.out.println("------------------------");
        for (int i = 0; i < files.length; i++) {
            System.out.printf("%d.%s\n", i + 1, files[i].getName());
        }
        System.out.println("------------------------");
        System.out.print("选择要查看的结果文件（0表示放弃）：");

        Integer index = scanner.nextInt();
        if (index == 0) {
            return;
        }
        if (index < 0 || index > files.length) {
            System.out.println("错误的输入！");
            return;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(files[index - 1]));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
