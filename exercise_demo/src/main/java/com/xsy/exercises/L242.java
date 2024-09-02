package com.xsy.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 字母异位词 是通过重新排列不同单词或短语的字母而形成的单词或短语，通常只使用所有原始字母一次
 * https://leetcode.cn/problems/valid-anagram/
 */
public class L242 {
    @Test
    public void test() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    // 自己思路和官方题解思路相同
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        char[] chart = t.toCharArray();
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }
}
