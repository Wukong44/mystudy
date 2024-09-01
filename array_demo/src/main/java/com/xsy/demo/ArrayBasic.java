package com.xsy.demo;

import org.junit.jupiter.api.Test;

public class ArrayBasic {

    /**
     * 什么是数组：
     * 数组是一种能够存储 多个 同种数据类型 的数据结构(即数据容器)
     */

    /**
     * 数组定义：
     * 格式1：数据类型[] 数组名
     * 格式2：数据类型  数组名[]
     */
    @Test
    void test() {
        int[] arr1;
        int arr2[];
    }

    /**
     * 数组初始化：
     * 1.静态初始化
     * 完整格式： 数据类型[] 数组名 = new 数据类型[]{元素1，元素2...};
     * 简化格式： 数据类型[] 数组名 = {元素1，元素2...};
     */
    @Test
    public void test1() {
        int[] arr1 = new int[]{1, 2, 3}; // 完整格式
        int[] arr2 = {1, 2, 3}; // 简写格式
    }

}
