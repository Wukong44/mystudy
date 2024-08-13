package com.xsy.demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count_Spaces_in_a_String {

    /**
     * 题目网址：https://www.baeldung.com/java-string-count-spaces
     * Count Spaces in a Java String
     * 统计一个字符串中的空格数量
     * String INPUT_STRING = "  This string has nine spaces and a Tab:'	'";
     * int EXPECTED_COUNT = 9;
     * 几种方法:
     * 1.The Classic Solution: Looping and Counting
     * 2.Using Java 8’s Stream API
     * 3.Using the String.replaceAll() Method
     * 4.Using the String.split() Method
     * 5.Using the Apache Commons Lang 3 Library     the countMatches() method
     * 6.StringUtils.countOccurrencesOf()
     * 7. pattern.matcher()
     */
    String INPUT_STRING = "  This string has nine spaces and a Tab:'	'";

    @Test
    // 1.The Classic Solution: Looping and Counting
    public void looping_and_Counting() {
        int spaceCount = 0; // 计数器
        // 1. 循环计数
        for (char c : INPUT_STRING.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        System.out.println(spaceCount);
    }

    // 2.Using Java 8’s Stream API
    @Test
    public void stream_API() {
        long count = INPUT_STRING.chars()
                .filter(c -> c == (int) ' ')
                .count();
        System.out.println(count);
    }

    /**
     * 3.Using the String.replaceAll() Method
     * 思路：
     * 正则表达式 替换掉字符串中所有的非空
     * [ ]是一个正则表达式中的字符集，表示空格字符。
     * [^ ]则表示非空格字符，即除了空格以外的所有字符。
     * replaceAll 方法在这里的作用是将INPUT_STRING中的所有非空格字符替换为空字符串（""），从而删除它们。
     * 结果字符串将只包含原始字符串中的空格字符
     */
    @Test
    public void replaceAll_Method() {
        int length = INPUT_STRING.replaceAll("[^ ]", "").length();
        System.out.println(length);
    }

    /**
     * 4.Using the String.split() Method
     * 思路：
     * 按照空格分割，则分割后的字符串数组的长度比空格多一个，减1即可
     * ex：3个单词之间有2个空格，分割出来三个单词，减1即空格数
     */
    @Test
    public void replaceAll_Method2() {
        System.out.println(INPUT_STRING.split(" ").length - 1);
    }

    // 5.the countMatches() method
    @Test
    public void  countMatches() {
        StringUtils.countMatches(INPUT_STRING,' ');
    }
    /**
     * 6.Using Spring  StringUtils.countOccurrencesOf()
     * 已经引入过其他类下的StringUtils了，所以这里要用全类名
      */
    @Test
    public void  countOccurrencesOf() {
        System.out.println(org.springframework.util.StringUtils.countOccurrencesOf(INPUT_STRING, " "));
    }

    // 7. pattern.matcher
    @Test
    public void  pattern_matcher() {
        Pattern pattern = Pattern.compile(" ");
        Matcher matcher = pattern.matcher(INPUT_STRING);
        int spaceCount = 0;
        while (matcher.find()) {
            spaceCount++;
        }
        System.out.println(spaceCount);
    }


}

