package com.xsy.demo;

import com.xsy.comm.dto.User;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class MapDemo {

    @Test
    public void test() {
        Map map = new HashMap();

        User user1 = new User("sisi", 26);
        User user2 = new User("sisi", 33);
        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        map.put(user2, "456");
        map.put(user1, "123");
        map.forEach((k, v) -> System.out.println(k + "=" + v));
        

    }
}
