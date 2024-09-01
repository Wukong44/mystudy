package com.xsy.demo;

import org.junit.jupiter.api.Test;

public class Demo {

    // 包装类和String转换
    @Test
    public void test() {
        // 包装类 -----> String
        Integer i = 10;
        // 方法1
        String string1 = i.toString();
        // 方法2
        String s = String.valueOf(i);
        // 方法3
        String s1 = i + "";

        // String -----> 包装类
        // 方法1
        Integer i2 = new Integer(s1);
        // 方法2 这种比3好 因为有缓存
        Integer i1 = Integer.valueOf(s1);
        // 方法3
        int i3 = Integer.parseInt(s1);
    }

    /**
     *  包装类缓存 在==判断时候的细节
     *  非常经典的面题，有点意思
     *  原理：Integer缓存有-128-127的对象，这个范围内的对象则是重用的，所以==是相等的
     */
    @Test
    public void test2() {
        /**
         *  int 赋值给 Integer会自动装箱，底层调用的valueOf()方法如下
         * public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         */
        Integer m = 1; // 等价于IntegerCache.cache[m + (-IntegerCache.low)]
        Integer n = 1; // 等价于IntegerCache.cache[n + (-IntegerCache.low)]
        System.out.println(n == m); // true

        // 只缓存-128-127，其余值则是new，看源码
        Integer x = 128; // 等价于new Integer(128)
        Integer y = 128; // 等价于new Integer(128)
        System.out.println(x == y); // false 因为是new出来的，所以==为false

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false
    }

    @Test
    public void test3() {
        // 只要有基本数据类型，则判断的就是值是否相等
        Integer x = 127;
        int y = 127;
        System.out.println(x == y); // true

        Integer a = 128;
        int b = 128;
        System.out.println(a == b); // true
    }

    // ----------------------------*^*--------------------------------

    @Test
    public void test4() {

    }

}
