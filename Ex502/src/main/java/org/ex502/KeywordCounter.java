package org.ex502;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordCounter {
    private File sourceFile; // 进行统计的源程序文件
    private Map<String, Integer> counter = new HashMap<>(); // 存放统计结果的Map

    public KeywordCounter(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void count(String[] keywords) throws IOException {
        counter.clear();
        for (String keyword : keywords) {
            counter.put(keyword, 0);
        }

        String content = pretreatment();
        for (String keyword : keywords) {
            counter.put(keyword, this.countKeyword(keyword, content));
        }
    }


    /**
     * 以 List 形式返回统计结果
     *
     * @return
     */
    public List<Keyword> toList() {
        List<Keyword> result = new ArrayList<>();
        for (String s : counter.keySet()) {
            Keyword keyword = new Keyword(s, counter.get(s));
            result.add(keyword);
        }
        return result;
    }

    /**
     * 统计结果保存到文本文件
     *
     * @param desc 文本文件对象
     */
    public void saveTo(File desc) {
        List<Keyword> keywords = toList();
        Collections.sort(keywords);
        try (PrintWriter writer = new PrintWriter(new FileWriter(desc))) {
            for (Keyword keyword : keywords) {
                writer.println(keyword);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 返回使用次数前n名的关键字
     *
     * @param n
     * @return
     */
    public List<Keyword> getTop(int n) {
        List<Keyword> keywords = toList();
        Collections.sort(keywords, (k1, k2) -> {
            if (k1.getCounter() - k2.getCounter() == 0) {
                return k1.getKeyword().compareTo(k2.getKeyword());
            } else {
                return k2.getCounter() - k1.getCounter();
            }
        });
        return keywords.subList(0, n);
    }

    /**
     * 读取源程序文件并去除其中的所有注释和字符串直接量
     *
     * @return 处理后得到源码字符串
     * @throws IOException
     */
    private String pretreatment() throws IOException {
        String content = Files.readString(sourceFile.toPath()); // 读取整个文件到字符串

        content = content.replaceAll("/\\*[\\s\\S]*?\\*/", ""); // 删除文档注释和多行注释
        content = content.replaceAll("//.*", "");               // 删除单行注释
        content = content.replaceAll("\".*\"", "\"\"");         // 字符串直接量替换为空串
        content = " " + content;

        return content;
    }

    /**
     * 统计指定关键字的使用次数
     *
     * @param keyword 被统计的关键字
     * @param content 处理后的源程序字符串
     * @return {@code keyword} 在 {@code content} 中使用的次数
     */
    private int countKeyword(String keyword, String content) {
        int result = 0;
        String regex = "[\\W]" + keyword + "[\\W]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
            result++;
        }
        return result;
    }

}
