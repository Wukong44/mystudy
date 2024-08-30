package com.xsy.demo;

import com.xsy.comm.dto.User;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void t1() {
        User user = new User("sisi", 25);
        System.out.println(user);
    }


}
