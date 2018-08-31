package com.rainpen.example.com.rainpen.chapter3;

import com.rainpen.example.DdspringbootApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2018/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DdspringbootApplication.class)
public class RestfulControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new RestfulController()).build();
    }

    @Test
    public void userRestTest() throws Exception {
        RequestBuilder requestBuilder = null;

        //1.get一下users，应该为null
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        //2.post提交一个user
        requestBuilder = post("/users/")
                .param("id", "1")
                .param("name","rainpen")
                .param("age","23");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        //3.get获取列表
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"rainpen\",\"age\":23}]")));

        //4.修改
        requestBuilder = put("/users/1")
                .param("name","oldrainpen")
                .param("age","88");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        //5.get id
        requestBuilder = get("/users/1");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"oldrainpen\",\"age\":88}")));

        //6.删除
        requestBuilder = delete("/users/1");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        //7.删除是否成功
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("[]")));
    }
}