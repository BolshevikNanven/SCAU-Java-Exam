package org.ex404.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductInventory {
    private List<Product> productList;

    public ProductInventory() {
        this.productList = new ArrayList<>();
    }

    public Product getProduct(String id) {
        for (Product product : productList) {
            if (Objects.equals(product.getId(),id)) return product;
        }
        return null;
    }

    public void addProduct(Product product) {
        if (getProduct(product.getId()) == null) {
            productList.add(product);
        } else {
            productList.forEach(product1 -> {
                if (product.equals(product1)) {
                    product1.setQuantity(product.getQuantity());
                }
            });
        }

    }

    public boolean removeProduct(Product product) {
        if (product.getQuantity() != 0) {
            return false;
        }
        productList.remove(product);
        return true;
    }

    public int getTotalQuantity() {
        int num = 0;
        for (Product product : productList) {
            num += product.getQuantity();
        }
        return num;
    }

    public double getTotalAmount() {
        double num = 0;
        for (Product product : productList) {
            num += product.getPrice() * product.getQuantity();
        }
        return num;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
