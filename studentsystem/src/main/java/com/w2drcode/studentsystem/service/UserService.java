package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.User;

public interface UserService {
    User registerUser(User user);
    User login(String username, String password);
}
