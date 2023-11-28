package org.ex501.processor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Properties{
    private String name;             // 分析目录的短名称
    private String type;             // 分析目标的类型，值为"目录"或"文件"
    private String location;         // 目录或文件所在的父目录的绝对路径
    private long size;               // 目录或文件的大小，以字节为单位。文件是自身的大小，目录是基包含的所有文件的大小之和。
    private Date lastModified;       // 最后修改时间
    private int numberOfFiles;       // 目录中包含的文件个数。如分析目标是文件，则为0。
    private int numberOfDirectories; // 目录中包含的子目录个数。如分析目标是文件，则为0。
    private boolean writable;        // 目录或文件是否可写
    private boolean readable;        // 目录或文件是否可读
    private boolean executable;      // 目录或文件是否可运行
    private boolean hidden;          // 目录或文件是否隐藏

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("目标名称: " + name);
        builder.append("\n");

        builder.append("------------------------------------------------");
        builder.append("\n");

        builder.append("目录类型: " + type);
        builder.append("\n");

        builder.append("所在位置: " + location);
        builder.append("\n");

        builder.append(type + "大小: " + size + " 字节");
        builder.append("\n");

        if ("目录".equals(type)) {
            builder.append("包含文件: " + numberOfFiles + "个");
            builder.append("\n");

            builder.append("包含目录: " + numberOfDirectories + "个");
            builder.append("\n");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss SSS");
        String time = sdf.format(lastModified);
        builder.append("修改时间: " + time);
        builder.append("\n");

        builder.append("目标属性: ");
        builder.append("\n");

        builder.append("\t可读: " + readable);
        builder.append("\n");
        builder.append("\t可写: " + writable);
        builder.append("\n");
        builder.append("\t运行: " + executable);
        builder.append("\n");
        builder.append("\t隐藏: " + hidden);
        builder.append("\n");

        builder.append("------------------------------------------------");
        builder.append("\n");

        return builder.toString();
    }

    // 以下是所有属性的get方法--------------------

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public long getSize() {
        return size;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public int getNumberOfFiles() {
        return numberOfFiles;
    }

    public int getNumberOfDirectories() {
        return numberOfDirectories;
    }

    public boolean isWritable() {
        return writable;
    }

    public boolean isReadable() {
        return readable;
    }

    public boolean isExecutable() {
        return executable;
    }

    public boolean isHidden() {
        return hidden;
    }

    // 以下是所有属性的set方法--------------------


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setNumberOfFiles(int numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }

    public void setNumberOfDirectories(int numberOfDirectories) {
        this.numberOfDirectories = numberOfDirectories;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    public void setExecutable(boolean executable) {
        this.executable = executable;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
