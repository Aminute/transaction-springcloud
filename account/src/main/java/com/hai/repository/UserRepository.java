package com.hai.repository;

import com.hai.entity.User;

public interface UserRepository {
    public User login(String user_name,String user_pwd);
}
