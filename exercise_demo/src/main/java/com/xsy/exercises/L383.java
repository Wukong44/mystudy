package com.xsy.exercises;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * https://leetcode.cn/problems/ransom-note/description/
 */
public class L383 {
    @Test
    public void test() {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    // 自己的思路
    public boolean canConstruct(String ransomNote, String magazine) {
        // 思路： ransomNote当做magazine子集
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // map存储数据，key是字母，val是字母出现次数
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        // 把magazine存入map
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        // 把ransomNote存入map
        for (int i = 0; i < ransomNote.length(); i++) {
            map2.put(ransomNote.charAt(i), map2.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        Set<Character> keySet = map2.keySet();

        for (Character key : keySet) {
            if (!(map.get(key) != null && map2.get(key) <= map.get(key))) {
                return false;
            }
        }
        return true;
    }

    // 参考题解思路
    public boolean canConstruct2(String ransomNote, String magazine) {
        // 思路： ransomNote当做magazine子集
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] count = new int[26];// 统计每个字母出现此处
        // 统计父集元素个数
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        // 遍历子集
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}

















