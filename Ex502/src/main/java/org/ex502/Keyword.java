package org.ex502;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Keyword implements Comparable<Keyword> {
    private String keyword;
    private int counter;

    public Keyword(String keyword, int counter) {
        this.keyword = keyword;
        this.counter = counter;
    }

    /**
     * 从文本文件中读取某种语言的所有关键字
     *
     * @param keywordsFile 存放关键字的文本文件，每行一个关键字
     * @return 存放所有关键字的数组
     * @throws IOException
     */
    public static String[] loadKeywords(File keywordsFile) throws IOException {
        return Files.readAllLines(keywordsFile.toPath()).<String>toArray(new String[0]);
    }

    @Override
    public String toString() {
        return String.format("%-12s %5d", keyword, counter);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int compareTo(Keyword other) {
        return this.keyword.compareTo(other.keyword);
    }
}
