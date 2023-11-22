package org.ex404.manager;

import java.util.Date;
import java.util.Objects;

public class Product implements Comparable<Product>, Cloneable {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private Date launchDate;

    public Product() {
    }

    public Product(String id, String name, double price, int quantity, Date launchDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.launchDate = launchDate;
    }

    @Override
    public int compareTo(Product o) {
        if (Integer.parseInt(this.id) >= Integer.parseInt(o.getId())) {
            return 1;
        } else return -1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product product = (Product) obj;
        return Objects.equals(this.id, product.getId());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Product product = (Product) super.clone();
        product.setLaunchDate((Date) product.launchDate.clone());
        return product;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getLaunchDate() {
        return launchDate;
    }
}
