package com.xsy.json.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
//@NoArgsConstructor
public class Cat {
    /**
     * 如果您的类有一个无参构造函数，Jackson 会使用它来创建对象实例，然后通过反射设置字段。
     * 如果您的类没有无参构造函数，Jackson 会尝试使用带参数的构造函数。
     * 如果您指定了 @JsonCreator 注解，Jackson 会遵循该注解的指示来创建对象实例。
     * 如果没有任何合适的构造函数可用，Jackson 会抛出异常。
     */

    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //@JsonProperty 注解，以便 Jackson 知道如何将 JSON 字段映射到这些参数
//    @JsonCreator注解来指示 Jackson 使用哪个构造函数来创建对象实例
    public Cat(@JsonProperty("name") String name) {
        this.name = name;
    }


}
