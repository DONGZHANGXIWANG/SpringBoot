package com.rainpen.example.com.rainpen.chapter2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义属性获取
 * Created by Administrator on 2018/4/27.
 */
@Component
public class CustomizeProperties {

    @Value("${com.rainpen.name}")
    private String name;

    @Value("${com.rainpen.height}")
    private String hight;

    @Value("${com.rainpen.desc}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
