package com.rainpen.example.com.rainpen.chapter5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author laiyup-S9644
 * @date 2018年05月31日
 */
@Controller
@RequestMapping("/helloException")
public class HelloException {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws Exception {
        throw new JsonException("发生错误2");
    }
}
