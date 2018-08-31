package com.rainpen.example.com.rainpen.chapter4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Spring Boot开发Web应用-thymeleaf
 * @author: laiyup-S9644
 * @create: 2018-05-21 16:06
 **/
@Controller
@RequestMapping("/chapter4")
@ApiIgnore
public class Chapter4Controller {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("host", "http://rainpenisking.com");
        return "index";
    }

}
