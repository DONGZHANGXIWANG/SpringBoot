package com.rainpen.example.com.rainpen.chapter1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * hello controller
 * Created by Administrator on 2018/4/27.
 */
@ApiIgnore
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }

}
