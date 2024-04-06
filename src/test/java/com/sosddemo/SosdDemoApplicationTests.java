package com.sosddemo;

import com.sosddemo.service.impl.TestServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SosdDemoApplicationTests {
@Autowired
    TestServiceImpl testService;
    @Test
    void contextLoads() {
        testService.tt(1);

    }

}
