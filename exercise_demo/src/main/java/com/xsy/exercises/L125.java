package com.xsy.exercises;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * 125T：验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * https://leetcode.cn/problems/valid-palindrome/description/
 */
public class L125 {
    @Test
    public void test() {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    // 自己方法
    public boolean isPalindrome(String s) {
        if (s.trim().length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toLowerCase().toCharArray();
        // 过滤字符串获得只有小写字母 和 数字 的字符串
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= '0' && chars[i] <= '9') {
                sb.append(chars[i]);
            }
        }
        return sb.toString().equals(sb.reverse().toString()); // StringBuilder没重写equals 所以要转为String比较内容
    }
}
