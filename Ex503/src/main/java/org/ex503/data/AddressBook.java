package org.ex503.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddressBook implements Serializable {
    private List<Address> addressList = new ArrayList<>(); // 内存中的地址簿

    public AddressBook() {
    }

    /**
     * 按姓名查找地址，考虑到可能有同名情况，结果是一个线性表
     *
     * @param name 查找的姓名
     * @return 查找结果的线性表
     */
    public List<Address> getByName(String name) {
        List<Address> result = new ArrayList<>();
        for (Address address : addressList) {
            if (address.getName().equals(name)) {
                result.add(address);
            }
        }
        return result;
    }

    public Address get(int index) {
        if (index < 0 || index >= addressList.size()) {
            return null;
        } else {
            return addressList.get(index);
        }
    }

    public void add(Address address) {
        addressList.add(address);
    }

    public void remove(Address address) {
        addressList.remove(address);
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}
