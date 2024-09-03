package com.xsy.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/description/
 */
public class L557 {
    @Test
    public void test() {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
    }

    // 自解
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(new StringBuilder(words[i]).reverse().toString());
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 自解2
    public String reverseWords2(String s) {
        // 用stream优化
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
