package com.rainpen.example.com.rainpen.chapter9.datasource1;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring-data-jpa
 * 一大特性：通过解析方法名创建查询。
 * 除了通过解析方法名来创建查询外，它也提供通过使用@Query 注解来创建查询，您只需要编写JPQL语句
 * @author laiyup-S9644
 * @date 2018年06月06日
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
