package com.xsy.demo;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.xsy.comm.dto.Animal;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public class How_to_Convert_List_to_Map {

    /**
     * https://www.baeldung.com/java-list-to-map
     * How to Convert List to Map
     * list转map
     * 1.手动转换
     * 2.Stream流 (推荐)
     * 3.Maps.uniqueIndex()
     */

    List<Animal> animals = newArrayList(
            new Animal(001, "大象"),
            // new Animal(001, "长颈鹿"),
            new Animal(002, "猴子"),
            new Animal(003, "小猫"),
            new Animal(004, "小狗")
    );

    // 手动转换
    @Test
    public void test() {
        Map<Integer, Animal> map = newHashMap();
        for (Animal animal : animals) {
            map.put(animal.getId(), animal);
        }
        System.out.println(map);
    }

    // stream流
    @Test
    public void test2() {
        Map<Integer, Animal> map = animals
                .stream()
                .collect(Collectors.toMap(Animal::getId, animal -> animal, (a, b) -> b));
        System.out.println(map);
    }
    // 3. Guava Maps.uniqueIndex()
    @Test
    public void test3() {
        Map<Integer, Animal> map = Maps.uniqueIndex(animals, Animal::getId);
        System.out.println(map);
    }


}







