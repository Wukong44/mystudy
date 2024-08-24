package com.xsy.test;

import com.xsy.Main;
import com.xsy.comm.dto.User;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest(classes = Main.class)
public class ArrayTest {

    private static final Logger log = LoggerFactory.getLogger(ArrayTest.class);

    @Test
    void test() {
        // 数组初始化2种方式
        // 基本数据类型
        int[] array1 = new int[2]; // 指定数组维度
        int[] array2 = new int[]{1, 2}; // 不指定数组维度
        // 引用数据类型
        User[] users1 = new User[3];// 指定数组维度
        User[] users2 = new User[]{new User(), new User(), new User()};// 不指定数组维度

        System.out.println(Arrays.toString(array1)); // [0, 0]
        System.out.println(Arrays.toString(array2)); // [1, 2]

        for (User user : users1) {
            System.out.print(user);
        } // null null null

        for (User user : users2) {
            System.out.println(user);
        }
        /**
         * 这是重写了toString方法才打印具体对象
         * User(name=null, age=0)
         * User(name=null, age=0)
         * User(name=null, age=0)
         *
         * 如果没重写toString()方法就打印内存地址
         * com.xsy.comm.dto.User@50687efb
         * com.xsy.comm.dto.User@517bd097
         * com.xsy.comm.dto.User@142eef62
         */
    }

    /**
     * 创建数组时，指定的数组维度可以有多种形式：
     * 数组维度可以是整数、字符。
     * 数组维度可以是整数型、字符型变量。
     * 数组维度可以是计算结果为整数或字符的表达式。
     */
    @Test
    void test2() {
        int length = 3;
        // 放开被注掉的代码，编译器会报错
        // int[] array = new int[4.0];
        // int[] array2 = new int["test"];
        int[] array3 = new int['a'];
        int[] array4 = new int[length];
        int[] array5 = new int[length + 2];
        int[] array6 = new int['a' + 2];
        // int[] array7 = new int[length + 2.1];
        System.out.println("array3.length = [" + array3.length + "]");
        System.out.println("array4.length = [" + array4.length + "]");
        System.out.println("array5.length = [" + array5.length + "]");
        System.out.println("array6.length = [" + array6.length + "]");
        // Output:
        // array3.length = [97]
        // array4.length = [3]
        // array5.length = [5]
        // array6.length = [99]
    }

    // 集合判空
    @Test
    void test3() {
        // List<String> list = new ArrayList<>(Arrays.asList());
        List<String> list = new ArrayList<>(Arrays.asList("中国", "重庆", "南岸"));
        // 集合判空isEmpty()只判断集合内元素是否为空，空字符串，null值不判断
        if (list.isEmpty()) {
            System.out.println("list is empty");
            // 空集合
            List emptyList = Collections.emptyList();
            return;
        }
        System.out.println(list); // 3
    }

    // 转Map
    @Test
    void test4() {
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("zhang", 8),
                new User("wang", 12)
        ));
        // 要注意值为null的情况
        Map<String, Integer> res = userList.stream()
                .collect(Collectors.toMap(User::getName, User::getAge));
        System.out.println("end");
    }

    // 集合去重
    @Test
    void test5() {
        // 数据准备
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("zhang", 8),
                new User("zhang", 8),
                new User("zhang", 8),
                new User("wang", 66)
        ));
        // 非空判断
        if (userList.isEmpty()) {
            return;
        }
        // 1.利用set集合特点去重，用HashSet可能会丢失顺序
        Set<User> userSet = new HashSet<>(userList); // 不保证有序
        // Set<User> uniqueLinkedSet = new LinkedHashSet<>(userList); // 保留插入顺序
        List<User> uniqueUserList = new ArrayList<>(userSet);
        System.out.println(uniqueUserList);

        // 2.利用Stream流去重
        List<User> res = userList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(res);

        // 3.手动迭代去重
        List<User> uniqueUsers = new ArrayList<>();
        for (User user : userList) {
            if (!uniqueUsers.contains(user)) { // 确保User类正确实现了equals和hashCode
                uniqueUsers.add(user);
            }
        }
        System.out.println(uniqueUsers);
    }

    // 集合转数组：使用集合转数组的方法，
    // 必须使用集合的 toArray(T[] array)，传入的是类型完全一致、长度为 0 的空数组

    @Test
    void test6() {
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("zhang", 8),
                new User("wang", 66),
                new User("haha", 77)
        ));
        User[] array = userList.toArray(new User[0]);
        // 下面修改互相不影响对方，数据是独立的
        userList.set(1, new User("test", 00));
        array[2] = new User("lisi", 99);
        System.out.println(Arrays.toString(array));
    }

    // 数组转集合
    @Test
    void test7() {
        String[] strArray = {"中国", "重庆", "南岸"};
        // List<String> list = new ArrayList<>(Arrays.asList(strArray));
        List<String> list = new ArrayList<>(Arrays.asList("中国", "重庆", "南岸"));
        System.out.println(list);
        // 2.stream流
        List<String> list1 = Arrays.stream(strArray).collect(Collectors.toList());
        System.out.println(list1);
    }

    /**
     * Arrays.asList()总结：
     * Arrays.asList()方法生成的list会影响原来的数据，核心点就是他们共享底层数据
     * 修改list内容会影响数组，修改数组中的内容也会影响list
     * 但是如果改变原来数组的引用指向一个新的数组，那list不能访问到新的数组,依然是旧数组的数据
     */
    @Test
    void test8() {
        String[] strArray = {"中国", "四川", "成都"};
        List<String> list = Arrays.asList(strArray);
        list.set(1, "234"); // {"中国","234","成都"} 可以修改元素
        strArray[2] = "成都哈哈哈"; // {"中国","234","成都哈哈哈"}
        // list.add("999"); // UnsupportedOperationException 不能新增元素
        // list.remove("999"); // UnsupportedOperationException 不能删除元素
        strArray = new String[]{"中国", "重庆", "南岸"};
    }

    @Test
    void test9() {

    }


}






















