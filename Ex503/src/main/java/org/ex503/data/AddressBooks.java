package org.ex503.data;

import java.io.*;

public class AddressBooks {
    private static final String FILE_NAME = "address_book.dat"; // 地址簿的存储文件，存储AddressBook对象

    /**
     * 静态方法，从文件中读取AddressBook对象
     *
     * @return 读取成功，返回从文件中读取的AddressBook对象；读取失败，返回新建的AddressBook对象
     */
    public static AddressBook load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            AddressBook book = (AddressBook) ois.readObject();
            return book;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("读取地址薄数据出错，创建空白地址薄.");
            return new AddressBook();
        }
    }

    /**
     * 静态方法，将参数 book 对象写入文件
     *
     * @param book
     */
    public static void save(AddressBook book) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(book);
        } catch (IOException e) {
            System.out.println("保存地址薄数据出错.");
        }
    }
}
