package com.xsy.exercises;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/number-of-segments-in-a-string/
 */
public class L434 {
    @Test
    public void test() {
        String s = "    foo    bar";
        System.out.println(countSegments(s));
    }

    // 自解
    public int countSegments(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }
        String[] words = s.trim().split("\\s+");
        return words.length;
    }

    // 官解
    public int countSegments2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' ')) {
                count++;
            }
        }
        return count;
    }


}
