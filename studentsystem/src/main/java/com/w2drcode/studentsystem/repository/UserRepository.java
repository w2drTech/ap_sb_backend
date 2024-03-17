package com.w2drcode.studentsystem.repository;

import com.w2drcode.studentsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
