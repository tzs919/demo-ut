package com.example.demo;

import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("ut")
public class ControllerTest {

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
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("[{\"id\":1,\"username\":\"tzs\",\"password\":\"112233\"},{\"id\":2,\"username\":\"laoli\",\"password\":\"123456\"}]", content);

    }

    @Test
    public void testFindOne() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(jsonPath("$.username", is("tzs")))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("{\"id\":1,\"username\":\"tzs\",\"password\":\"112233\"}", content);
    }


    @Test
    public void testInsert() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setId(3L);
        user.setUsername("new Name");
        user.setPassword("pw");

        System.out.println(mapper.writeValueAsString(user));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("1", content);
    }
}