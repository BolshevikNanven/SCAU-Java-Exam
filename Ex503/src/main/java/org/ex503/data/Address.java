package org.ex503.data;

import java.io.Serializable;

public class Address implements Serializable {
    private String name;     // 姓名
    private String province; // 省份
    private String city;     // 城市
    private String detailAddress; // 详细地址
    private String postcode; // 邮政编码

    public Address() {
    }

    public Address(String name, String province, String city, String detailAdress, String postcode) {
        this.name = name;
        this.province = province;
        this.city = city;
        this.detailAddress = detailAdress;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return String.format("姓名: %-10s\n省份: %-10s  城市: %-10s  邮政编码: %s\n详细地址: %s",
                name, province, city, postcode, detailAddress);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
