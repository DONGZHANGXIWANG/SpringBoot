package com.rainpen.example.com.rainpen.chapter9.datasource2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}