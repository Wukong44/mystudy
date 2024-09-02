package com.xsy.exercises;

import org.junit.jupiter.api.Test;

/**
 * 67T:二进制求和
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和
 * https://leetcode.cn/problems/add-binary/description/
 */
public class L67 {
    @Test
    public void test() {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(addBinary(a, b));
        // System.out.println(addBinary2(a, b)); // 这个方法Integer.valueOf超出范围时候就会报错了，还是第一种稳妥
    }

    // 自己解法
    public String addBinary(String a, String b) {
        /*
        先变为等长，不够长度的补0
        假设a存放长串，b存放短串
        eg: a="11", b = "1"
         */
        String temp;
        if (a.length() < b.length()) {  // 交换两串引用,确保a是长串
            temp = a;
            a = b;
            b = temp;
        }
        int aLength = a.length();
        int bLength = b.length();
        StringBuilder resBuilder = new StringBuilder();
        // 给短串长度不够的高位上补0
        int zeroNum = aLength - bLength; // 高位补0个数
        // 补0操作
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeroNum; i++) {
            sb.append("0");
        }
        b = sb.append(b).toString();
        // 从低位开始对位相加
        int isUp = 0; // 是否进位 1 代表进位  0 代表不进位
        int curNum; // 取值0 、 1
        for (int i = aLength - 1; i >= 0; i--) {
            curNum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + isUp; // 取值 0、1、2、3
            if (curNum == 0) {
                isUp = 0;
                resBuilder.insert(0, "0");
            } else if (curNum == 1) { // 不进位 当前位为1
                isUp = 0;
                resBuilder.insert(0, "1");
            } else if (curNum == 2) { // 进位,当前位为0
                isUp = 1;
                resBuilder.insert(0, "0");
            } else { //  curNum == 3 进位 当前位为1
                isUp = 1;
                resBuilder.insert(0, "1");

            }
        }
        if (isUp == 1) {
            resBuilder.insert(0, "1");
        }
        return resBuilder.toString();
    }


    // 参考题解：考虑一个最朴素的方法：先将 a 和 b 转化成十进制数，求和后再转化为二进制数
    public String addBinary2(String a, String b) {
        // radix代表第一个参数是几进制 方法返回十进制数
        return Integer.toBinaryString(Integer.valueOf(a,2) + Integer.valueOf(b,2));
    }



}









