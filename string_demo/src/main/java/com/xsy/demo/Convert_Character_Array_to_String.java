package com.xsy.demo;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Convert_Character_Array_to_String {

    /**
     * https://www.baeldung.com/java-char-array-to-string
     * Convert Character Array to String
     * 字符数组转字符串
     * 1.String Constructor
     * 2.String.valueOf()
     * 3.StringBuilder‘s toString()
     * 4.stream流
     * 5.Guava Joiner
     */
    final char[] charArray = {'b', 'a', 'e', 'l', 'd', 'u', 'n', 'g'};

    // String Constructor
    @Test
    public void test() {
        String s = new String(charArray);
        System.out.println(s);
    }

    // 2.String.valueOf()
    @Test
    public void test2() {
        System.out.println(String.valueOf(charArray));
    }

    // 3.StringBuilder‘s toString()
    @Test
    public void test3() {
        final char[][] arrayOfCharArray = {{'b', 'a'}, {'e', 'l', 'd', 'u'}, {'n', 'g'}};
        StringBuilder sb = new StringBuilder();
        for (char[] subArray : arrayOfCharArray) {
            sb.append(subArray);
        }
        System.out.println(sb.toString());
    }

    // 4.stream
    @Test
    public void test4() {
         Character[] charArray = {'b', 'a', 'e', 'l', 'd', 'u', 'n', 'g'};
        // 接受一个对象数组 T[] 作为参数,所以得用Character[]包装类，不能用char[]，因为这是基本数据类型，否则编译都报错
        Stream<Character> charStream = Arrays.stream(charArray);
        String string = charStream.map(String::valueOf).collect(Collectors.joining());
        System.out.println(string);
    }
    // 5.Guava Joiner
    @Test
    public void test5() {
        final Character[] charArray = { 'b', 'a', 'e', 'l', 'd', 'u', 'n', 'g' };
        String string = Joiner.on("").join(charArray);
        System.out.println(string);
    }


}
