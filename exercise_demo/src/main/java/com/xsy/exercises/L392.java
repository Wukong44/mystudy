package com.xsy.exercises;

import org.junit.jupiter.api.Test;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列
 * https://leetcode.cn/problems/is-subsequence/description/
 */
public class L392 {
    @Test
    public void test() {
        String s = "cb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        // System.out.println(isSubsequence2(s, t));
    }

    // 自己解法 比官解速度快
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        // 遍历s
        for (char c : s.toCharArray()) {
            int index = t.indexOf(c);
            if (index == -1) {
                return false;
            }
            t = t.substring(index + 1); // 截取t，只从后面的位置查找
        }
        return true;
    }

    // 官方解
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}






