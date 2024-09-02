package com.xsy.exercises;

import org.junit.jupiter.api.Test;

/**
 * 力扣58t
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
 * https://leetcode.cn/problems/length-of-last-word/description/
 */
public class L58 {
    /*
    思路分析：不能单纯空格分割，因为有些单词之间有多个空格，分割会得到空格串
    从后往前便利得到第一个不是字母的索引，再截取后面的子串
     */
    @Test
    public void test() {
        // String s = "luffy is still joyboy";
        String s = "";
        // int i = lengthOfLastWord(s);
        int i = lengthOfLastWord2(s);
        System.out.println("最后一个单词长度" + i);
    }


    // 第一次自己做法
    public int lengthOfLastWord(String s) {
        char[] chars = s.trim().toLowerCase().toCharArray(); // 去除两端空格 忽略大小写
        int i;
        for (i = chars.length - 1; i >= 0; i--) {
            if (!(chars[i] >= 'a' && chars[i] <= 'z')) { // 如果不是字母则退出循环
                break;
            }
        }
        return chars.length - 1 - i; // 最后一个索引 - 倒数第一个不是字母的索引
    }

    // 参考题解后解法
    public int lengthOfLastWord2(String s) {
        String trimmed = s.trim();
        int index = trimmed.length() - 1;
        while (index >= 0 && trimmed.charAt(index) != ' ') {
            index--;
        }
        return trimmed.length() - 1 - index;
    }
}









