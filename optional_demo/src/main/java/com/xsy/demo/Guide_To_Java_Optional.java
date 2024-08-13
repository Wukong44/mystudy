package com.xsy.demo;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Guide_To_Java_Optional {
    /**
     * https://www.baeldung.com/java-optional
     * Guide To Java Optional
     * 官网API：https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
     * Optional指南
     */
    @Test
    public void test() {
        // Creating Optional Objects
        Optional<String> optional = Optional.empty();
        System.out.println(optional.isPresent()); // false
    }

    @Test
    public void test2() {
        String name = "baeldung";
        /**
         * 注意Optional.of()方法必须接受一个存在的，且不为null的值
         * Optional.of(): Returns an Optional with the specified present non-null value.
         * 否则运行时NullPointerException
         */
        // Optional<String> opt = Optional.of(null); // NullPointerException
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.isPresent()); // true

        Optional<Object> opt1 = Optional.ofNullable(null);
        System.out.println(opt1.isPresent()); // false
    }

    // optional.ifPresent()
    @Test
    public void test3() {
        /**
         * if(name != null) {
         *     System.out.println(name.length());
         * }
         * 转换为用Optional判断 逻辑如下
         */
        Optional<String> optional = Optional.of("baeldung");
        // 多行代码的时候，在{ 后换行 模仿超哥的写法 一行代码可以省略花括号
        optional.ifPresent(name -> {
            System.out.println(name.length());
        });
    }

    // orElse()
    @Test
    public void test4() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        System.out.println(name); // john
    }

    // orElseGet()
    @Test
    public void test5() {
        String nullName = null;
        /**
         * Supplier接口 则表达式不需要参数，() -> "jack"一定是这么写，前面没有参数固定的
         */
        String name = Optional.ofNullable(nullName).orElseGet(() -> "jack");
        System.out.println(name); // jack
    }

    /**
     * Difference Between orElse() and orElseGet()
     * orElse() 和 orElseGet()的不同
     * 总结：
     * orElse() 立即计算其参数，并返回Optional中的值或提供的具体备选值。
     * orElseGet() 延迟计算备选值，直到确认Optional为空时才会调用Supplier来获取备选值，这通常更高效。
     * 说直白一点就是：orElse()就是不管是否有值，都会执行其中的计算，而orElseGet()是有值则不计算，无值才计算
     * 选择：
     * 在选择使用orElse还是orElseGet时，你应该考虑备选值的计算成本。
     * 如果备选值是一个简单且即时的值，使用orElse可能更直接。但如果备选值需要通过计算获得，
     * 尤其是当计算成本较高时，使用orElseGet可以避免不必要的计算，提高性能
     */
    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }
    // orElse() 和 orElseGet()的不同
    @Test
    public void test6() {
        System.out.println("以下是Optional值为null的情况");
        String text = null;
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        // 输出：
        // Getting Default Value
        // Getting Default Value

        System.out.println("以下是Optional值不为null的情况");
        String text1 = "Text present";
        System.out.println("Using orElseGet:");
        String defaultText1 = Optional.ofNullable(text1).orElseGet(this::getMyDefault);
        System.out.println("Using orElse:");
        defaultText1 = Optional.ofNullable(text1).orElse(getMyDefault());
        // 输出：
        // Using orElseGet:
        // Using orElse:
        // Getting Default Value

         // orElse()在 Optional值为null 和 Optional值不为null 两种情况下都调用了获取默认值的方法，
         // orElseGet() 只在Optional值为null 的时候才调用
  // 这是一行测试代码
    }


}
