package com.xsy.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting_a_String_Alphabetically {

    /**
     * Sorting a String Alphabetically
     * 按照字母顺序对字符串排序(对字符串的操作一般可以转换为char[]数组)
     * 1.char[]数组来排序
     * 2.Stream流
     */
    String str = "bdca";
    @Test
    public void arrays_sort() {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);
        System.out.println(sortedStr);
    }

    // Stream流这里还不是太懂，以后再理解
    @Test
    public void Stream_sort() {
        // String sortedStr = Stream.of(str.chars()).sorted().toString(); // 不能这样用，不生效，原理暂时还理解不了先记住
        String sortedStr = str.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
                // 下面是另一种写法
                // .mapToObj(c -> String.valueOf((char) c))
                // .collect(Collectors.joining());
        System.out.println(sortedStr);
    }


}





