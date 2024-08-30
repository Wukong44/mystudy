package com.xsy.demo;

import com.xsy.comm.dto.User;
import org.junit.jupiter.api.Test;

public class Test1 {

    /**
     * 零散的不好归类的知识点
     */
    @Test
    void t1() {
        // 三元运算符是一个整体，这里最高精度为double，所以会把1自动精度提升
        System.out.println(true ? new Integer(1) : new Double(3.0)); // 1.0 不是 1
        // 下面输出 1 和上面不同在于下面不是一个整体了，所以不会精度自动提升
        if (true) {
            System.out.println(new Integer(1));
        } else {
            System.out.println(new Double(3.0));
        }
    }

    @Test
    void t2() {

    }

}
