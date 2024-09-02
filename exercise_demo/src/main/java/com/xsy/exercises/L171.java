package com.xsy.exercises;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/excel-sheet-column-number/description/
 */
public class L171 {
    @Test
    public void test() {
        String columnTitle = "ZY";
        System.out.println(titleToNumber(columnTitle));
    }

    public int titleToNumber(String columnTitle) {
        int res = 0;
        int multiple = 1; // 乘数
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            // res += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
            res += (columnTitle.charAt(i) - 'A' + 1) * multiple;
            multiple *= 26;
        }
        return res;
    }
}
