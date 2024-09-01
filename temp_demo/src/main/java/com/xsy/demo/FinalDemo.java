package com.xsy.demo;

import org.junit.jupiter.api.Test;

public class FinalDemo {
    /**
     * final 关键字可以修饰： 类、方法、属性、局部变量
     */
    final String TEST = "HelloWorld"; // final修饰则不能更改了

    @Test
    public void test() {
        // d d = new d();
        // d.hi();
        // TEST = "123";
        // System.out.println(TEST);
    }
}

// 如果希望A类不能被其他类继承，可以使用final修饰A类
final class A {
}
// class B extends A {}

class c {
    // public void hi() {};
    public final void hi() {
        final int num = 1; // final修饰局部变量让其不能被修改
        // num = 2;
    }

    ; // 如果不希望被重写，可以用final修饰方法
}

// class d extends c {
//     @Override
//     public void hi() {
//         System.out.println("重写hi方法");
//     }
// }

class e {
    public int age = 1;
    // age =2; // 编译报错 类体是用来定义方法和变量的，不能执行代码，代码执行要放到方法或者代码块中执行
    {
        age =2; // 放代码块中没问题
    }
}