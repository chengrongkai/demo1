package com.example.demo;

import com.example.demo.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    TestMapper testMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        List<com.example.demo.entity.Test> tests = testMapper.selectList(null);
        for (com.example.demo.entity.Test test : tests) {
            System.out.println(test.toString());
        }
    }

}
