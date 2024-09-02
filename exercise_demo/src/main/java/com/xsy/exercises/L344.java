package com.xsy.exercises;

/**
 * 344
 * https://leetcode.cn/problems/reverse-string/
 */

import org.junit.jupiter.api.Test;

public class L344 {
    @Test
    public void test() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
    }

    // 自己思路和官方题解差不多
    public void reverseString(char[] s) {
        // 双指针
        char temp;
        int start = 0;
        int end = s.length - 1;
        while (end >= start) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            end--;
            start++;
        }
    }
}
