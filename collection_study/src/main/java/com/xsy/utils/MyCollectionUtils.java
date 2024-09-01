package com.xsy.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyCollectionUtils {

    /**
     * 以下通过反射获取内部elementData的大小，不过不建议这么做，这里只是测试用一下
     */
    public static int getListCapacity(List list) {
        try {
            Field elementDataField = ArrayList.class.getDeclaredField("elementData");
            // 修改访问权限，暴力反射
            elementDataField.setAccessible(true);
            Object[] elementData = (Object[]) elementDataField.get(list);
            int capacity = elementData.length;
            return capacity;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
