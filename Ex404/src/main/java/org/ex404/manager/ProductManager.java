package org.ex404.manager;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductManager {
    final ProductInventory productInventory = new ProductInventory();
    final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            int command = displayMenu();
            switch (command) {
                case 1 -> findProduct();
                case 2 -> entryProduct();
                case 3 -> reduceProduct();
                case 4 -> removeProduct();
                case 5 -> listProduct();
                default -> {
                    return;
                }
            }
        }

    }

    protected int displayMenu() {
        System.out.printf("1.查询产品\n2.产品入库\n3.产品出库\n4.产品删除\n5.产品列表\n0.退出\n");
        return scanner.nextInt();
    }

    protected void findProduct() {
        System.out.println("请输入产品编号：");
        Product product = productInventory.getProduct(scanner.next());
        if (product == null) {
            System.out.println("产品不存在");
        } else {
            renderProductHeader();
            renderProductList(product);
        }
    }

    protected void entryProduct() {
        System.out.println("请输入入库产品的编号：");
        String id = scanner.next();
        Product product = productInventory.getProduct(id);

        if (product == null) {
            product = new Product();
            product.setId(id);
            System.out.println("产品名称：");
            product.setName(scanner.next());
            System.out.println("产品价格：");
            product.setPrice(scanner.nextDouble());
            System.out.println("产品数量：");
            product.setQuantity(scanner.nextInt());
            product.setLaunchDate(new Date());
        } else {
            System.out.println("入库数量：");
            product.setQuantity(product.getQuantity() + scanner.nextInt());
        }
        productInventory.addProduct(product);
        System.out.println("产品入库成功");
    }

    protected void reduceProduct() {
        System.out.println("请输入出库产品编号：");
        String id = scanner.next();

        Product product = productInventory.getProduct(id);
        if (product == null) {
            System.out.println("产品不存在");
            return;
        }
        System.out.println("请输入出库数量：");
        int num = scanner.nextInt();

        if (num > product.getQuantity()) {
            System.out.println("库存数量不足");
            return;
        }
        product.setQuantity(product.getQuantity() - num);
        productInventory.addProduct(product);
        System.out.println("产品出库成功");

    }

    protected void removeProduct() {
        System.out.println("请输入删除产品编号：");
        String id = scanner.next();
        Product product = productInventory.getProduct(id);

        if (product == null) {
            System.out.println("产品不存在");
            return;
        }

        System.out.println("是否确认删除产品？(输入1确认)");
        int command = scanner.nextInt();

        if (command != 1) {
            return;
        }

        if (productInventory.removeProduct(product)) {
            System.out.println("删除成功");
        } else {
            System.out.println("库存数量不为0，不能删除");
        }

    }

    void listProduct() {
        List<Product> productList = productInventory.getProductList();
        Collections.sort(productList);

        renderProductHeader();
        for (Product product : productList) {
            renderProductList(product);
        }
        System.out.printf("合计数量：%d，合计金额：%.2f\n",
                productInventory.getTotalQuantity(),
                productInventory.getTotalAmount()
        );

        while (true) {
            System.out.println("1.按名称升序/2.按价格升序/3.按库存数量降序/0.直接返回，你的选择：");
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> productList.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        Collator collator = Collator.getInstance(Locale.CHINA);
                        return collator.compare(o1.getName(), o2.getName());
                    }
                });
                case 2 -> productList.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
                case 3 -> productList.sort((o1, o2) -> o2.getQuantity() - o1.getQuantity());
                default -> {
                    return;
                }
            }

            renderProductHeader();
            for (Product product : productList) {
                renderProductList(product);
            }
            System.out.printf("合计数量：%d，合计金额：%.2f\n",
                    productInventory.getTotalQuantity(),
                    productInventory.getTotalAmount()
            );
        }

    }

    private void renderProductHeader() {
        System.out.printf("%4s | %20s | %8s | %8s | %9s | %s \n",
                "编号", "名称", "价格", "库存数量", "库存金额", "上架日期"
        );
    }

    private void renderProductList(Product product) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd");

        System.out.printf("%4s | %20s | %6.2f | %8d | %7.2f | %s \n",
                String.format("%4s", product.getId()).replace(" ", "0"),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getPrice() * product.getQuantity(),
                dateFormat.format(product.getLaunchDate())
        );
    }

}
