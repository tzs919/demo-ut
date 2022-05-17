package com.example.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@ActiveProfiles("ut2")
@SpringBootTest
public class DataSourceTest {

//    @Autowired
//    DataSource dataSource1;
//
//    @Test
//    public void contextDuridLoads() throws SQLException {
//        Connection con = dataSource1.getConnection();
//        System.err.println("**************");
//        System.err.println(dataSource1.getConnection());
//        DruidDataSource dss = (DruidDataSource) dataSource1;
//        System.err.println(dss.getName());
//        System.err.println(dss.getValidationQuery());
//        System.err.println(dss.getTimeBetweenEvictionRunsMillis());
//        System.err.println(dss.getMinEvictableIdleTimeMillis());
//        // 数据源例如：HikariDataSource(springboot2.x默认)，DruidDataSource，dbcp2DataSource
//        System.err.println(dataSource1.getClass().getName());
//        // 连接例如org.sqlite.SQLiteConnection
//        System.err.println(con);
//        System.err.println("**************");
//        con.close();
//    }

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Test
    public void testDataSource() throws Exception {
        // 获取配置的数据源
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 查看配置数据源信息
        System.out.println(dataSource);
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSourceProperties);
    }

}