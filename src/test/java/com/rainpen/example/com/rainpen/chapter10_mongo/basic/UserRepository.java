package com.rainpen.example.com.rainpen.chapter10_mongo.basic;

import com.rainpen.example.com.rainpen.chapter10_mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author laiyup-S9644
 * @date 2018年08月31日
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByName(String name);

}
