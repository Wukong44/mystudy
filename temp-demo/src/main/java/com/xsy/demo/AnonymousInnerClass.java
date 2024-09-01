package com.xsy.demo;

import org.junit.jupiter.api.Test;

@SuppressWarnings("all")
public class AnonymousInnerClass {
    /**
     * 匿名内部类：本质是类、同时还是一个对象 定义在外部类的局部位置（比如方法中）
     * 基本语法：
     * new 类/接口(参数列表) {
     * 类体
     * }
     */
    @Test
    public void test() {
        /**
         *  传统想调用hi方法操作如下
         *  1.创建一个实现了IA接口的对象实例，那首先需要一个实现了IA接口的类
         *  匿名内部类使用过一次就没了，只能使用一次
         *  如果我们只想调用一次hi方法，还要创建一个类再实现接口，非常繁琐和麻烦，可以用匿名内部类来简化接口
         *  AA a = new AA();
         *  a.hi();
         */

        // 1.基于接口的匿名内部类
        IA ia = new IA() { // 这个new 实际上是jdk底层在创建匿名内部类后立马就创建了一个对象实例并且把地址返回给ia
            @Override
            public void hi() {
                System.out.println("重写Hi方法");
            }
        };
        /*
        底层实际上是这样
          class AnonymousInnerClass$1 implements AA {
            @Override
            public void hi() {
                System.out.println("重写Hi方法");
            }
        }
         */
        // 运行类型就是匿名内部类的名称 外部类名$1nonymousInnerClass$1
        System.out.println(ia.getClass()); // A
        // 下面是Lambda表达式简化匿名内部类(必须是函数式接口才能用Lambda表达式)
        IA ia1 = () -> {
            System.out.println("重写Hi方法");
        };
        ia.hi(); // 下面的AA类就不需要了

        // 2.基于类的匿名内部类
        Fathear fathear = new Fathear("Jack") {
            @Override
            public void test() {
                System.out.println("重写了test方法");
            }
        };
        System.out.println(fathear.getClass()); // 运行类型 AnonymousInnerClass$2
        // 不能用Lambda简写，这个只能用于函数式接口的匿名内部类简写，下面编译报错
        // Fathear fathear2 = ("jack") -> {
        //     System.out.println("重写了test方法");
        // }
    }

    ;


    // 匿名内部类 作为参数使用
    @Test
    public void test2() {
        /*
            传统使用 1.创建一个类实现IA接口 2.创建一个实现该接口的对象 再传进去
            这里创建了AA类实现IA接口
            我只需要使用一次该对象作为参数来传递，
            问题在于会去创建一个AA类，这个过程实际上是很繁琐的，且取名也非常麻烦
         */
        test3(new AA());

        // 使用匿名内部类简化
        test3(new IA() {
            @Override
            public void hi() {
                System.out.println("使用匿名内部类简化。。。");
            }
        });
        // 使用Lambda还可以简化
        test3(() -> {
            System.out.println("使用Lambda简化。。。");
        });
    }

    // 定义一个参数为接口类型的方法
    public void test3(IA ia) {
        ia.hi();
    }
}


// @FunctionalInterface
interface IA {
    void hi();

    /*
    Lambda表达式只能用来表示函数式接口
    一个函数式接口是指一个具有单个抽象方法的接口
    因为Lambda表达式省略了方法名，如果有多个抽象方法，它就不知道要调用哪个，所以只能有一个抽象方法
    加上下面的代码后就不能使用Lambda表达式了，因为就有两个抽象方法了
    但是可以有默认方法
     */
    // void hi3() {}; // 编译报错
    default void hi4() {
        System.out.println("Hello World");
    }
}

class AA implements IA {
    @Override
    public void hi() {
        System.out.println("重写Hi方法");
    }
}

class Fathear {
    Fathear(String name) {
    } // 构造器

    public void test() {
    }
}

















