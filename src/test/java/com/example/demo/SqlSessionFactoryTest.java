package com.example.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

//@RunWith(SpringRunner.class)
//@SpringBootTest
class SqlSessionFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void showDefaultCacheConfiguration() {
        SqlSessionFactory factory;
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);

        System.out.println("一级缓存范围: " + factory.getConfiguration().getLocalCacheScope());
        System.out.println("二级缓存是否被启用: " + factory.getConfiguration().isCacheEnabled());
    }
}
