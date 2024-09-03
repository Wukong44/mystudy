package com.xsy.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/fizz-buzz/
 */
public class L412 {
    @Test
    public void test() {
        int n = 15;
        System.out.println(fizzBuzz(n));
        System.out.println(fizzBuzz2(n));
    }

    // 自己解法
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);
        String[] strings = {"FizzBuzz", "Fizz", "Buzz"};
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add(strings[0]);
            } else if (i % 3 == 0) {
                answer.add(strings[1]);
            } else if (i % 5 == 0) {
                answer.add(strings[2]);
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }

    // 官解
    public List<String> fizzBuzz2(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            // 这里的判断比我上面if else 更好 其实也判断了是3也是5的倍数的情况 学习了
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            answer.add(sb.toString());
        }
        return answer;
    }

}


