package org.finalExam.analysis;

import org.finalExam.utils.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Analyzer {
    private File file;
    private Integer fileCount, lineCount, blankCount;
    private Long byteCount;
    private StringBuilder result;
    final private String RANK_BLANK = "    ";

    public Analyzer() {
    }

    public Analyzer(String path) {
        this.file = new File(path);
        if (!file.isDirectory() || !file.exists()) {
            System.out.printf("[%s]不是合法的目录名称！\n", file.getAbsolutePath());
            return;
        }
        this.fileCount = 0;
        this.blankCount = 0;
        this.byteCount = 0L;
        this.lineCount = 0;
        this.result = new StringBuilder();

        result.append(String.format("[%s] Result:\n\nFile detail:\n", file.getAbsolutePath()));
        analysisDir(this.file, "");
        exportResult();

    }

    private void analysisDir(File file, String rank) {
        File[] files = file.listFiles((dir, name) -> dir.isDirectory() || dir.getName().toLowerCase().endsWith(".java"));
        if (files == null) {
            return;
        }
        Arrays.sort(files, (a, b) -> Comparator.<String>naturalOrder().compare(a.getName(), b.getName()));
        result.append(rank).append("+").append(file.getName()).append("\n");

        for (File f : files) {
            if (f.isDirectory()) {
                analysisDir(f, rank + RANK_BLANK);
            } else {
                analysisFile(f, rank + RANK_BLANK);
            }
        }

    }

    private void analysisFile(File file, String rank) {
        int lines = FileUtil.getLineNum(file);
        int blank = FileUtil.getBlankLineNum(file);
        long bytes = FileUtil.getByteNum(file);

        result.append(String.format("%s-%s  Total:%5d,Blank:%5d,%10d Bytes\n", rank, file.getName(), lines, blank, bytes));

        this.fileCount++;
        this.lineCount += lines;
        this.blankCount += blank;
        this.byteCount += bytes;

    }

    private void exportResult() {
        result.append("Total:\n")
                .append(String.format("%10d Java Files\n%10d lines in files\n%10d blank lines\n%10d bytes\n",
                        this.fileCount, this.lineCount, this.blankCount, this.byteCount));

        File f = new File("result");
        f.mkdir();
        try {
            FileWriter fileWriter = new FileWriter("result/" + file.getName() + ".txt");
            fileWriter.write(result.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
