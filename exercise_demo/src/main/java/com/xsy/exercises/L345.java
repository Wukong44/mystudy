package com.xsy.exercises;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 反转字符串中的元音字母
 *https://leetcode.cn/problems/reverse-vowels-of-a-string/
 */
public class L345 {
    @Test
    public void test() {
        String s = ".,"; //
        System.out.println(reverseVowels(s));
        System.out.println(reverseVowels2(s));
    }

    // 自己解法
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] chars = s.toCharArray();
        for (int left = 0, right = chars.length - 1; left < right; ) {
            char temp;
            if (!set.contains(chars[right])) { // 不是元音字母则前移右指针
                right--;
            }
            if (!set.contains(chars[left])) { // 不是元音字母则后移左指针
                left++;
            }
            if (set.contains(chars[left]) && set.contains(chars[right])) {
                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }


    // 参考官方题解优化自己的解法
    public String reverseVowels2(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (right > 0 && !isVowels(chars[right])) { // 定位右指针到元音字母
                right--;
            }
            while (left < chars.length && !isVowels(chars[left])) { // 定位左指针到元音字母
                left++;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    // 是否是元音字母
    public boolean isVowels(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

}
