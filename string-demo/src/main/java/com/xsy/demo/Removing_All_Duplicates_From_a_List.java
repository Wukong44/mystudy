package com.xsy.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Removing_All_Duplicates_From_a_List {

    /**
     * Removing All Duplicates From a List in Java
     * List去重
     * 1.Set去重
     *      1.1原生set
     *      1.2 Guava库set
     * 2.Stream流 + Lambdas
     * 3.手动迭代去重
     */
    List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);

    // 1.1 Set去重 list->set->list 就完成了去重
    @Test
    public void Java_HashSet() {
        List<Integer> listWithoutDuplicates  = new ArrayList<>(new HashSet<>(listWithDuplicates)); // HashSet不保证有序
        // List<Integer> listWithoutDuplicates2  = new ArrayList<>(new LinkedHashSet<>(listWithDuplicates)); // LinkedHashSet 保证插入和取出相同顺序
        System.out.println(listWithoutDuplicates);
    }

    // 1.2 Guava
    @Test
    public void Guava_newHashSet() {
        // Sets.newHashSet是google Guava库中的方法 (顺序问题如上)
        List<Integer> listWithoutDuplicates  = new ArrayList<>(Sets.newHashSet(listWithDuplicates));
        // List<Integer> listWithoutDuplicates  = new ArrayList<>(Sets.newLinkedHashSet(listWithDuplicates));
        System.out.println(listWithoutDuplicates);
    }

    // 2.Stream流的distinct
    @Test
    public void Stream_distinct() {
        List<Integer> listWithoutDuplicates = listWithDuplicates
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
    }

    /**
     * 手动迭代去重
     * 思路：
     * 1.创建一个新集合存放去重后的元素
     * 2.遍历旧集合把书籍add到新集合
     * 3.add之前判断元素是否存在，若存在则不add
      */
    @Test
    public void manual_Deduplication() {
        List<Integer> listWithoutDuplicates = Lists.newArrayList();
        for (Integer num : listWithDuplicates) {
            if (!listWithoutDuplicates.contains(num)) {
                listWithoutDuplicates.add(num);
            }
        }
        System.out.println(listWithoutDuplicates);
    }


}



