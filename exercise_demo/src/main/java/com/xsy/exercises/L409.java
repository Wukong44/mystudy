package com.xsy.exercises;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-palindrome/description/
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的
 * 回文串
 * 的长度。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 */
public class L409 {
    private static final Logger log = LoggerFactory.getLogger(L409.class);

    @Test
    public void test() {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    // 第一次做的思路
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Collection<Integer> values = map.values();
        int t = 0; // 是否有奇数，有奇数则取1个
        int sum = 0;
        for (Integer value : values) {
            if (value % 2 == 0) {
                sum += value;
            } else {
                t = 1;
                sum += value - 1; // 奇数-1
            }
        }
        return t == 0 ? sum : sum + 1;
    }

    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

}








