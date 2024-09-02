package com.xsy.exercises;

import org.junit.jupiter.api.Test;

/**
 * 168T：Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * https://leetcode.cn/problems/excel-sheet-column-title/description/
 */
public class L168 {
    @Test
    public void test() {
        int columnNumber = 28;
        System.out.println(convertToTitle(columnNumber));
    }

    // 参考+自己的题解
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        // A-Z 索引就是 1-26
        // char[] alphabetArray = {
        //         ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        //         'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        //         'U', 'V', 'W', 'X', 'Y', 'Z'
        // };
        int t;
        while (columnNumber > 0) {
            t = (columnNumber - 1) % 26 + 1; // 余数
            res.append(t + 'A' - 1);
            // res.append(alphabetArray[t]);
            columnNumber = (columnNumber - t) / 26; // 商
        }
        return res.reverse().toString();
    }
}
