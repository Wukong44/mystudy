package com.xsy.exercises;

import org.junit.jupiter.api.Test;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式
 * https://leetcode.cn/problems/add-strings/description/
 */
public class L415 {
    @Test
    public void test() {
        String num1 = "99";
        String num2 = "9";
        System.out.println(addStrings(num1, num2));
    }

    // 参考题解的做法 学习了
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int isUp = 0;
        while (i >= 0 || j >= 0 || isUp != 0) {
            // 获取对应位上的值
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = x + y + isUp; // 当前位的值
            sb.append(temp % 10);
            isUp = temp / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}





