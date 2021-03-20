package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("ut")
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Test
    public void testLog(){
        log.debug("====this is my debug======");
    }
}
