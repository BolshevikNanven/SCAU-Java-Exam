package org.finalExam.utils;

import java.io.*;

public class FileUtil {
    public static int getLineNum(File file) {
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file))) {
            lineNumberReader.skip(Long.MAX_VALUE);
            int lineNumber = lineNumberReader.getLineNumber();
            return lineNumber;
        } catch (IOException e) {
            return -1;
        }
    }

    public static int getBlankLineNum(File file) {
        int num = 0;
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isBlank()) num++;
            }
        } catch (IOException e) {
            return -1;
        }
        return num;
    }

    public static long getByteNum(File file){
        return file.length();
    }
}
