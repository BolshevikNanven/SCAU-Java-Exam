package org.ex503.ui;

import org.ex503.data.Address;
import org.ex503.data.AddressBook;
import org.ex503.data.AddressBooks;

import java.util.List;
import java.util.Scanner;

public class AddressUI {
    private Scanner scanner = new Scanner(System.in);
    private AddressBook addressBook;

    public AddressUI() {
        addressBook = AddressBooks.load(); // 加载或新建地址簿
    }

    /**
     * 运行地址簿程序界面
     */
    public void run() {
        while (true) {
            int choice = getUserChoice(); // 显示菜单并获取用户选择
            switch (choice) {
                case 1:
                    listAllAddress();
                    break;
                case 2:
                    findAddress();
                    break;
                case 3:
                    addAddress();
                    break;
                case 4:
                    delAddress();
                    break;
                case 5:
                    modifyAddress();
                    break;
                case 0:
                    return;
            }
            System.out.println();
        }
    }

    /**
     * 显示菜单并返回用户的选择
     *
     * @return 用户的正确选项
     */
    private int getUserChoice() {
        System.out.println("--- 功能选项 ---");
        System.out.println(" 1. 地址列表");
        System.out.println(" 2. 查找地址");
        System.out.println(" 3. 增加地址 ");
        System.out.println(" 4. 删除地址 ");
        System.out.println(" 5. 修改地址 ");
        System.out.println(" 0. 退出");
        System.out.println("----------------");
        while (true) {
            System.out.print("请输入选项号: ");
            String input = scanner.nextLine();
            if (input.isBlank() || input.charAt(0) < '0' || input.charAt(0) > '5') {
                System.out.println(" 输入错误!");
            } else {
                return input.charAt(0) - '0';
            }
        }
    }

    /**
     * 显示所有地址
     */
    private void listAllAddress() {
        printAddress(addressBook.getAddressList());
    }

    /**
     * 按姓名查找地址
     */
    private void findAddress() {
        System.out.print("输入要查找的姓名: ");
        String name = scanner.nextLine();

        List<Address> addresses = addressBook.getByName(name);
        printAddress(addresses);
    }

    /**
     * 增加新地址
     */
    private void addAddress() {
        System.out.println("新增地址");

        System.out.print("姓名: ");
        String name = scanner.nextLine();
        System.out.print("省份: ");
        String province = scanner.nextLine();
        System.out.print("城市: ");
        String city = scanner.nextLine();
        System.out.print("邮政编码: ");
        String postcode = scanner.nextLine();
        System.out.print("详细地址: ");
        String detailAddress = scanner.nextLine();

        if (name.isBlank() || province.isBlank() || city.isBlank() || postcode.isBlank() || detailAddress.isBlank()) {
            System.out.println("错误: 所有数据都必须输入.");
        } else {
            Address address = new Address(name, province, city, detailAddress, postcode);
            addressBook.add(address);       // 添加新的地址
            AddressBooks.save(addressBook); // 存储到文件
            System.out.println("增加新地址成功.");
        }
    }

    /**
     * 删除地址
     */
    private void delAddress() {
        System.out.print("输入要删除地址的姓名: ");
        String name = scanner.nextLine();

        List<Address> addresses = addressBook.getByName(name);
        printAddress(addresses);

        if (addresses.size() > 0) {
            Address address = selectAddress(addresses); // 在查找到的地址中获得要删除的地址对象
            if (address == null) {
                System.out.println("地址序号输入错误.");
            } else {
                addressBook.remove(address);
                AddressBooks.save(addressBook);
                System.out.println("删除地址成功.");
            }
        }
    }

    /**
     * 修改地址
     */
    private void modifyAddress() {
        System.out.print("输入要修改地址的姓名: ");
        String input = scanner.nextLine();

        List<Address> addresses = addressBook.getByName(input);
        printAddress(addresses);

        if (addresses.size() > 0) {
            Address address = selectAddress(addresses); // 在查找到的地址中获得要修改的地址对象
            if (address == null) {
                System.out.println("地址序号输入错误.");
            } else {
                System.out.println("输入需要修改地址的各项数据(直接回车表示不修改该项数据): ");

                System.out.print("姓名: \n  原值: " + address.getName() + "\n  输入新值: ");
                String name = scanner.nextLine();
                if (!name.isBlank()) {     // 输入数据不为空白
                    address.setName(name);
                }
                System.out.print("省份: \n  原值: " + address.getProvince() + "\n  输入新值: ");
                String province = scanner.nextLine();
                if (!province.isBlank()) {
                    address.setProvince(province);
                }
                System.out.print("城市: \n  原值: " + address.getCity() + "\n  输入新值: ");
                String city = scanner.nextLine();
                if (!city.isBlank()) {
                    address.setCity(city);
                }
                System.out.print("邮政编码: \n  原值: " + address.getPostcode() + "\n  输入新值: ");
                String postcode = scanner.nextLine();
                if (!postcode.isBlank()) {
                    address.setPostcode(postcode);
                }
                System.out.print("详细地址: \n  原值: " + address.getDetailAddress() + "\n  输入新值: ");
                String detailAddress = scanner.nextLine();
                if (!detailAddress.isBlank()) {
                    address.setDetailAddress(detailAddress);
                }

                AddressBooks.save(addressBook);
                System.out.println("修改地址成功.");
            }
        }

    }

    /**
     * 根据用户输入从地址表中选择一个地址
     *
     * @param addresses
     * @return 选中的地址对象, null 表示没有选中
     */
    private Address selectAddress(List<Address> addresses) {
        System.out.print("输入选择的地址序号: ");
        String input = scanner.nextLine();
        try {
            int index = Integer.parseInt(input);
            if (index >= 1 && index <= addresses.size()) {
                return addresses.get(index - 1);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 输出地址列表
     *
     * @param addresses 地址列表
     */
    private void printAddress(List<Address> addresses) {
        System.out.println("序号 | 姓名 | 省份 | 城市 | 邮政编码 | 详细地址 ");
        System.out.println("-".repeat(80));
        if (addresses.size() == 0) {
            System.out.println("地址列表为空!");
        } else {
            for (int i = 0; i < addresses.size(); i++) {
                System.out.printf("%4d | %s | %s | %s | %s | %s\n",
                        i + 1,
                        addresses.get(i).getName(),
                        addresses.get(i).getProvince(),
                        addresses.get(i).getCity(),
                        addresses.get(i).getPostcode(),
                        addresses.get(i).getDetailAddress()
                );
            }
        }
        System.out.println("-".repeat(80));
        System.out.printf("共[%d]条数据.\n", addresses.size());
    }
}
