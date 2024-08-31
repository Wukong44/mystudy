package com.xsy.basic;

import com.xsy.comm.dto.User;
import org.junit.jupiter.api.Test;

public class StringBasic {
    /**
     * 为什么String类是不可变长的/String类是如何保证不可变长的 (好久以后终于理解透彻了！！！)
     * String不可变长是指string对象一旦分配，其内容不可改变(但是该对象的引用可以指向新的对象)
     * eg：String str = "Hello World"
     * str = "Hello"
     * 总结：
     * 这是底层数据存储结构 private final char value[];
     * 1.final修饰value[]，所以value[]无法指向新的内存地址，保证value[]不会指向新的值(地址空间)。
     * <p>
     * 2.String内部没有提供相应的set方法来修改value[]的值，所以value[]当前指向的空间中的内容也不能改变。
     * (如果有相应setCharAt方法，则可以通过str.setCharAt(0)修改str，破坏了不可变性)
     * <p>
     * 3.private修饰意味着value[]只能在内部操作，不能在外部获取并修改值
     * (假如不是private则可在外部直接str.value[0] = ‘h’ 然后str中的value[]就变成了hello World，破坏了不可变性)
     * <p>
     * 4.String类的所有操作都返回新的String对象，而不是修改现有对象。
     * 比如连接、截取、替换等，但所有这些方法都不会修改原字符串对象，而是会产生新的字符串对象
     * <p>
     * 以上4点保证了value[]的值不会改变
     */
    @Test
    public void test() {
        String str = "Hello World";
    }

    @Test
    public void test2() {
        // 对象中属性的值还是指向常量池中的地址
        User user1 = new User();
        User user2 = new User();
        user1.setName("111");
        user2.setName("111");
        System.out.println(user1.getName() == user2.getName()); // true
        System.out.println(user1.getName() == "111"); // true
    }

    @Test
    public void test3() {
        // 在常量池只创建了一个HelloWorld对象，底层会优化，发现Hello和World都没有引用指向，所以不会单独创建
        String s1 = "Hello" + "World";

        String s2 = "Hello";
        String s3 = "World";
        /**
         * 以下创建了3个对象（2个常量池对象，1个堆中的对象）
         * 这里是变量相加 不等价于 String s4 = "Hello" + "World"
         * 变量相加时 + 底层采用的是StringBuilder 然后append，
         * 最后调用
         * public String toString() {
         *         return new String(value, 0, count);
         *     }
         *
         * String s2 = "Hello"; 会在字符串常量池中查找 "Hello"，如果不存在则创建。
         * String s3 = "World"; 会在字符串常量池中查找 "World"，如果不存在则创建。
         * String s4 = s2 + s3; 会创建一个新的字符串 "HelloWorld" 并在堆上分配内存，这个对象默认不会放入字符串常量池中。
         * 执行 s2 + s3 的时候，生成的新字符串 "HelloWorld" 默认不会自动放入字符串常量池中。
         * 也就是说，s4 引用的是在堆上新创建的一个 String 对象。
         * 如果你想要将这个新创建的字符串对象放入常量池中，需要显式地调用 intern() 方法
         */
        String s4 = s2 + s3; // s4指向堆中的value[]
        System.out.println(s4 == "HelloWorld"); // false 一个堆中 一个常量池中
        System.out.println(s4.intern() == "HelloWorld"); // true s4.intern()返回常量池中的对象，如果没有则把当前值加入常量池

    }

    /**
     * StringBuilder  和  + 拼接字符串操作的区别 (也是花了好久才吃透)
     * 非常经典的面试题
     * 单字符拼接性能基本相同：+在单字符拼接时底层也是用的StringBuilder
     * 循环拼接不要用+，因为每次循环都会产生新的StringBuilder和String对象，而StringBuilder可以复用，所以效率更高
     */
    @Test
    public void test4() {
        // 两者执行时间基本相同，一定要留够足够的gc时间和JIT优化时间，不然执行效率就差得多了
        test5();
        test6();
        test7();
    }

    // 用模拟StringBuilder + 循环拼接字符串
    @Test
    public void test5() {
        String s2 = "Hello";
        long begin1 = System.currentTimeMillis();
        // StringBuilder sb = new StringBuilder(s2); // 可以把sb放外面定义重用，相当于小优化
        for (int i = 0; i < 20000; i++) {
            StringBuilder sb = new StringBuilder(16); // + 创建时候给的16 所以这里控制变量
            sb.append(s2);
            sb.append("i");
            s2 = sb.toString();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("StringBuilder模拟+拼接执行时间\t" + (end1 - begin1) + "ms");

        // 手动触发垃圾回收
        System.gc();
        try {
            Thread.sleep(1000);  // 等待垃圾回收完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // + 循环拼接字符串
    @Test
    public void test6() {
        String s = "Hello";
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s += "i";
        }
        long end = System.currentTimeMillis();
        System.out.println("+拼接执行时间\t" + (end - begin) + "ms");

        // 手动触发垃圾回收
        System.gc();
        try {
            Thread.sleep(1000);  // 等待垃圾回收完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 直接用 StringBuilder 拼接
    @Test
    public void test7() {
        String s = "Hello";
        long begin = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(16); // + 创建时候给的16 所以这里控制变量
        for (int i = 0; i < 20000; i++) {
            sb.append(s);
        }
        s = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder拼接执行时间\t" + (end - begin) + "ms");

        // 手动触发垃圾回收
        System.gc();
        try {
            Thread.sleep(1000);  // 等待垃圾回收完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}






