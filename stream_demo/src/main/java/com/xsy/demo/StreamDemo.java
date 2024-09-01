package com.xsy.demo;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流相关操作测试
 */
public class StreamDemo {

    public static void main(String[] args) {
        // 静态方法不能直接访问非静态方法和变量，但是可以通过类的实例来访问
        StreamDemo demo = new StreamDemo();
        demo.test();
    }

    public  void test() {
        System.out.println("1");
    }

    @Test
    public void test1() {
        System.out.println(222);
    }

    // to convert a character array to a String
    // 字符数组转字符串 常用1,2种
    @Test
    public void whenStringConstructor_thenOK() {
        final char[] charArray = { 'b', 'a', 'e', 'l', 'd', 'u', 'n', 'g' };
        // 1.String Constructor
        String string = new String(charArray);
        System.out.println(string);
        // 2.String.valueOf()
        String s = String.valueOf(charArray);
        System.out.println(s);
        // 3.StringBuilder‘s toString()
        final char[][] arrayOfCharArray = { { 'b', 'a' }, { 'e', 'l', 'd', 'u' }, { 'n', 'g' } };
        StringBuilder sb = new StringBuilder();
        for (char[] subArray : arrayOfCharArray) {
            sb.append(subArray);
        }
        System.out.println(sb.toString());
        // 4.Java 8 Streams
        final Character[] charArray1 = { 'b', 'a', 'e', 'l', 'd', 'u', 'n', 'g' };
        Stream<Character> charStream = Arrays.stream(charArray1);
        String string1 = charStream.map(String::valueOf).collect(Collectors.joining());
        System.out.println(string1);
    }

    // Partition a List in Java
    // 集合分区
    @Test
    public void test2() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        // List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        // 1. Use Guava to Partition the List
        List<List<Integer>> partition = Lists.partition(intList, 3);

        // 2. Collectors groupingBy
        Map<Integer, List<Integer>> collect = intList.stream()
                .collect(Collectors.groupingBy(num -> (num - 1) / 3));
    }


    // 集合判空 和 null
    @Test
    public void test4() {
        // list.isEmpty(); // 该方法只判空 不判null
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        // 1.工具类最简单 既判空又判null
        boolean isEmpty = CollectionUtils.isEmpty(list);
        // 2.集合判空 标准写法
        if (list != null && !list.isEmpty()) {
            list.forEach(System.out::println);
        }
        // 3.Optional来判断集合为空 和 null 太麻烦了  推荐上面一种
        Optional<List<Integer>> optionalList = Optional.ofNullable(list); // 判null
        optionalList.filter(listContent -> listContent.isEmpty()) // 判空
                .ifPresent(listContent -> list.forEach(System.out::println)); // 不空不null则打印

    }




}



















