package com.xsy.demo;

import com.xsy.comm.dto.Customer;
import com.xsy.comm.dto.Order;
import com.xsy.comm.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    private List<Order> orders = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    // 以下练习没有没有运行测试，是根据网上的答案直接我写完了对答案的
    // 练习 1 — 获取属于“书籍”类别且价格 > 100 的产品列表
    @Test
    public void test() {
        List<Product> res = products.stream()
                .filter(product -> "Book".equalsIgnoreCase(product.getCategory()))
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());
    }

    // 练习 2 — 获取产品属于“宝贝”类别的订单列表
    @Test
    public void test1() {
        List<Order> res = orders
                .stream()
                .filter(order ->
                        order.getProducts()
                                .stream()
                                .anyMatch(product -> "Baby".equalsIgnoreCase(product.getCategory()))
                )
                .collect(Collectors.toList());
    }

    // 练习 3 — 获取类别 =“玩具”的产品列表，然后应用 10% 的折扣
    @Test
    public void test2() {
        List<Product> res = products
                .stream()
                .filter(product -> "Toys".equalsIgnoreCase(product.getCategory()))
                // 不能直接在map中修改原来的数据，是独立的，必须新创建再返回
                .map(p -> {
                    p.setPrice(p.getPrice() * 0.9);
                    return p;
                    // Product product = new Product(p);
                    // product.setPrice(p.getPrice() * 0.9);
                    // return product;
                })
                .collect(Collectors.toList());
    }

    // 练习 5 — 获取“书籍”类别中最便宜的产品
    @Test
    public void test3() {
        Optional<Product> first = products
                .stream()
                .filter(product -> "Book".equalsIgnoreCase(product.getCategory()))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst();
        // 以上方案只能返回单个最低价，如果有多个最低价，可以用min
        // .min(Comparator.comparing(Product::getPrice)); // 这可以返回多个最低价
    }



}
