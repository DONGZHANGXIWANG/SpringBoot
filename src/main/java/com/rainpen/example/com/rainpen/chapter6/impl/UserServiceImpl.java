package com.rainpen.example.com.rainpen.chapter6.impl;

import com.rainpen.example.com.rainpen.chapter6.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 通过JdbcTemplate实现UserService中定义的数据访问操作
 * Spring的JdbcTemplate是自动配置的，你可以直接使用@Autowired来注入到你自己的bean中来使用。
 * @author laiyup-S9644
 * @date 2018年06月06日
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO User(name,age) VALUES (?,?)", name, age);
    }

    @Override public void deleteByName(String name) {
        jdbcTemplate.update("delete from User where NAME = ?", name);
    }

    @Override public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from User", Integer.class);
    }

    @Override public void deleteAllUsers() {
        jdbcTemplate.update("delete from User");
    }
}
