package org.ex501.processor;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PropertiesParser {
    private File target;
    private Properties properties;

    public PropertiesParser(File target) {
        this.target = target;
    }

    public void parse() {
        properties = null;
        target = getRealFile(target);
        if (target != null) {
            properties = new Properties();

            // 公共属性
            properties.setName(target.getName());
            if (target.getParentFile() != null) {
                properties.setLocation(target.getParentFile().getAbsolutePath());
            } else {
                properties.setLocation(target.getAbsolutePath());
            }
            properties.setLastModified(new Date(target.lastModified()));
            properties.setReadable(target.canRead());
            properties.setWritable(target.canWrite());
            properties.setExecutable(target.canExecute());
            properties.setHidden(target.isHidden());

            // 文件的属性
            if (target.isFile()) {
                properties.setType("文件");
                properties.setSize(target.length());
            }

            // 目录的属性
            if (target.isDirectory()) {
                properties.setType("目录");
                count(target);
            }
        }
    }

    public File getTarget() {
        return target;
    }

    public void setTarget(File target) {
        this.target = target;
    }

    public Properties getProperties() {
        return properties;
    }

    /**
     * 检查File对象f对应是否是符号连接，如果是则转换为真实路径的File对象并返回；否则直接返回f对象
     *
     * @param f 被检查的File对象
     * @return 真实路径的File对象，null表示转换失败
     */
    private File getRealFile(File f) {
        try {
            // 如果File对象对应的是一个符号连接目录或文件，则将其转换为真实对应的目录或文件
            // 使用了 java.nio.file.Path 接口的方法
            if (!f.toPath().equals(f.toPath().toRealPath())) {
                return f.toPath().toRealPath().toFile();
            } else {
                return f;
            }
        } catch (IOException e) {
            e.printStackTrace();
            // 如果发生了异常，则返回null
            return null;
        }
    }

    private void count(File target) {
//        System.out.println("----->" + target.getAbsolutePath());
        File[] items = target.listFiles();

        if (items != null) {
            for (File item : items) {
//                File temp = getRealFile(item);
                File temp = item;
                if (temp != null) {
                    if (temp.isFile()) {
                        properties.setNumberOfFiles(properties.getNumberOfFiles() + 1);
                        properties.setSize(properties.getSize() + temp.length());
                    } else {
                        properties.setNumberOfDirectories(properties.getNumberOfDirectories() + 1);
                        count(temp);
                    }
                }
            }
        }
    }
}
