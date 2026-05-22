package com.amit8085.testdb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositary extends JpaRepository<User,Long> {
  User findByNameAndAge(String name,int age);
}

