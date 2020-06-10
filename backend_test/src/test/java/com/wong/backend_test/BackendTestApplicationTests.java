package com.wong.backend_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public  class BackendTestApplicationTests {

    @Test
    void contextLoads() {

    }
    @Test
    public void test(){
        String str = "wong";
        str = String.format("hi,%s","你好");
        System.out.println(str);
    }

}
