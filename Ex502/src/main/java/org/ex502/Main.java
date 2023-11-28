package org.ex502;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入关键字文件名: ");
        String keywordsFilename = scanner.nextLine();
        String[] keywords = new String[0]; // 读取所有关键字
        try {
//            System.out.println(new File(keywordsFilename).getAbsolutePath());
            keywords = Keyword.loadKeywords(new File(keywordsFilename));
        } catch (IOException e) {
            System.out.println("关键字读取失败!" + e.getMessage());
            return;
        }

        System.out.print("输入Java源程序文件名: ");
        String javaSourceFilename = scanner.nextLine();
        File srcFile = new File(javaSourceFilename);
        if (!srcFile.isFile() || !srcFile.getName().toLowerCase().endsWith(".java")) {
            System.out.println("输入的文件名不是Java源程序文件.");
            return;
        }

        try {
            KeywordCounter counter = new KeywordCounter(srcFile); // 创建统计对象
            counter.count(keywords);
//            counter.toList().forEach(keyword -> System.out.println(keyword));
            String destFilename = "Keywords-" + srcFile.getName() + ".txt";
            counter.saveTo(new File(destFilename));
            System.out.println(srcFile.getName() + "的关键字使用次数已经存放到文件" + destFilename + "中.");
            System.out.printf("需要查看排名前几位(范围: 1-%d)的关键字？", keywords.length);
            int n = scanner.nextInt();
            counter.getTop(n).forEach(keyword -> {
                System.out.println(keyword);
            });
        } catch (IOException e) {
            System.out.println("统计源程序文件的关键字过程中出现了错误: " + e.getMessage());
        }
    }
}
