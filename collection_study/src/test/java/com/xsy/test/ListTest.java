package com.xsy.test;

import com.google.common.collect.Lists;
import com.xsy.Main;
import com.xsy.utils.MyCollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest(classes = Main.class)
public class ListTest {

    /**
     * 获取一个初始化整数集合
     */
    public List<Integer> initIntegerList() {
        List<Integer> list = new ArrayList<>();
        // List<Integer> list = Lists.newArrayList(); // 这样也可以
        for (int i = 0; i < 9; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 集合的三种访问方式
     * 1.迭代器
     * 2.普通for
     * 3.增强for
     */
    @Test
    void test() {
        Map<String, String> map = new HashMap<>();

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        // 迭代器遍历集合
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            System.out.println(next);
        }
        /*
        这时 iterator 迭代器，指向最后的元素，
        如果希望再次遍历，需要重置我们的迭代器
         */
//        it.next();//NoSuchElementException
        it = list.iterator(); // 重置迭代器

        // 普通for
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + 1);
            System.out.println(list.get(i));
        }
        // 增强for
        for (Integer i : list) {
            // i = i * 2 //这不会改变原来list中的值，增强for中的数据是原数据的副本，独立于原数据的
            // 增强for也可以改变原来的元素，不过要单独获取索引所以很麻烦通常不这样用
//            int index = list.indexOf(i);
//            list.set(index, list.get(index) - 1);
            System.out.println(i);
        }
    }


    /**
     * JDK8
     * List扩容测试
     * 总结：
     * 采用无参构造生成list首先容量为0，第一次添加元素时候扩容到10，后面每次扩容为当前最大容量的1.5倍,非整数时向上取整
     */
    @Test
    void test2() {
        List<Integer> list = initIntegerList(); // 9个数据
        System.out.println("添加元素之前的实际容量" + MyCollectionUtils.getListCapacity(list));
        for (int i = 0; i < 12; i++) {
            list.add(0);
        }
        System.out.println(list);
        System.out.println("当前实际容量" + list.size());
        System.out.println("添加元素之后的实际容量" + MyCollectionUtils.getListCapacity(list));
    }


}
