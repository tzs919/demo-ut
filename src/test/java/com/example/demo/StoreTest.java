package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("ut2")
public class StoreTest {
    private MockMvc mockMvc;

    /**
     * web上下文
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * 所有测试方法执行之前执行该方法
     */
    @Before
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testFindAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/store"))
                .andDo(print())
                .andExpect(jsonPath("$.store.book[*].author", hasSize(4)))//所有book的author节点
                .andExpect(jsonPath("$.store.book[*].author", hasItem("Nigel Rees")))//所有book的author节点
                .andExpect(jsonPath("$..author", hasSize(4)))//所有author节点
                .andExpect(jsonPath("$..author", hasItem("Nigel Rees")))//所有author节点
                .andExpect(jsonPath("$.store.*", hasSize(2)))//store下的所有节点，book数组和bicycle节点
                .andExpect(jsonPath("$.store..price", hasSize(5)))//store下的所有price节点
                .andExpect(jsonPath("$..book[2].isbn", hasItem("0-553-21311-3")))//匹配第3个book节点
//                .andExpect(jsonPath("$..book[(@.length-1)].isbn", is("0-395-19395-8")))//匹配倒数第1个book节点
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

}
