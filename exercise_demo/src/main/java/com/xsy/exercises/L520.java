package com.xsy.exercises;

import org.junit.jupiter.api.Test;

/**
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * https://leetcode.cn/problems/detect-capital/description/
 */
public class L520 {
    @Test
    public void test() {
        String word = "FlaG";
        System.out.println(detectCapitalUse(word));
        System.out.println(detectCapitalUse2(word));
        System.out.println(detectCapitalUse3(word));
    }

    // 自解
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        if (Character.isUpperCase(word.charAt(0))) { // 全大写 || 大+全小写
            word = word.substring(1);
            if (word.length() != 0 && Character.isUpperCase(word.charAt(0))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
            if (word.length() != 0 && Character.isLowerCase(word.charAt(0))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
        } else { // 全小写
            for (int i = 0; i < length; i++) {
                if (!Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    // 官解 思路好 学习了
    // 先判断1和2个字符是否是同小写， 后面判断2和后面字符是否同大/小
    // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
    public boolean detectCapitalUse2(String word) {
        if (word.length() >= 2
                && Character.isLowerCase(word.charAt(0))
                && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        // 判断2和后面的字符是否同大小(所以至少3个字符)
        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(1)) ^ Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /*
    别人思路 这也不错好理解
    如果 cnt=0，说明所有字母均为小写，符合要求。
    如果 cnt=n，说明所有字母均为大写，符合要求。
    如果 cnt=1 且 word[0] 是大写字母，说明 word 只有首字母大写，符合要求。
    其余情况不符合要求
     */

    public boolean detectCapitalUse3(String word) {
        int cnt = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                cnt++;
            }
        }
        return cnt == 0 || cnt == word.length() || cnt == 1 && Character.isUpperCase(word.charAt(0));
    }

}






