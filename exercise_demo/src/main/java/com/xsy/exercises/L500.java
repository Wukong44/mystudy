package com.xsy.exercises;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 力扣第500题：键盘行
 * https://leetcode.cn/problems/keyboard-row/description/
 */
@SuppressWarnings("all")
public class L500 {

    // 下面是第一次自己做的题解
    public static void main(String[] args) {
        String[] words = {"asdfghjkl", "qwertyuiop", "zxcvbnm"};
        // String[] res = findWords(words);
        String[] res = test(words);
        System.out.println(Arrays.toString(res));
        for (String str : res) {
            System.out.println(str);
        }
    }

    public static String[] findWords(String[] words) {
        /*  索引对应字母
         0-9 对应 qwertyuiop 区间0
         10-18 对应 asdfghjkl 区间1
         19-25 对应 zxcvbnm 区间2
         */
        String str = "qwertyuiopasdfghjklzxcvbnm";
        List<String> resList = new ArrayList<>();
        int resIndex = 0;
        int scope; // 第一个记录字符所在区间
        int nextScope; // 后一个记录字符所在区间
        for (int i = 0; i < words.length; i++) {
            // 遍历每个元素
            char[] chars = words[i].toLowerCase().toCharArray();
            scope = getScope(str.indexOf(chars[0])); // 第一个字符对应区间
            int j; // 记录退出循环时候的位置
            // 判断某个单词的字符索引是否都在同一个区间即可
            for (j = 1; j < chars.length; j++) {
                nextScope = str.indexOf(chars[j]);
                nextScope = getScope(nextScope);
                if (nextScope != scope) break; // 如果后面的字符和第一个字符不在同一个区间则终止循环
            }
            if (j == chars.length) {
                resList.add(words[i]);
            }
        }
        // 把list转为字符串数组
        String[] res = resList.stream()
                .filter(Objects::nonNull) // 过滤null
                .toArray(String[]::new);// 转为数组
        return res;
    }

    public static int getScope(int nextScope) {
        if (nextScope >= 0 && nextScope <= 9) {
            nextScope = 0;
        } else if (nextScope >= 10 && nextScope <= 18) {
            nextScope = 1;
        } else if (nextScope >= 19 && nextScope <= 25) {
            nextScope = 2;
        }
        return nextScope;
    }

    ;

    /**
     * 学习别人的题解
     * 我们为每一个英文字母标记其对应键盘上的行号，然后检测字符串中所有字符对应的行号是否相同
     * (大体思路差不多，但是我的思路差在需要转换字符为对应行号)
     */
    @Test
    public static String[] test(String[] words) {
        List<String> list = new ArrayList<String>();
        String rowIdx = "12210111011122000010020202"; // 对应26个字母的行号
        // 获得每个字母的行号
        for (int i = 0; i < words.length; i++) {
            // 获取对应字符数组
            char[] chars = words[i].toLowerCase().toCharArray();
            boolean isValid = true;
            // 获取每个字符串第一个字符的行号
            int firstCharRow = rowIdx.charAt(words[i].toLowerCase().charAt(0) - 'a');
            for (int j = 0; j < chars.length; j++) {
                if (rowIdx.charAt(chars[j] - 'a') != firstCharRow) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(words[i]);
            }
        }
        String[] res = list.stream().toArray(String[]::new);
        return res;
    }
}
