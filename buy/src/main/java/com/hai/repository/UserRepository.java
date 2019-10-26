package com.hai.repository;

import com.hai.entity.User;

import java.util.List;

public interface UserRepository {
    public User findById(String user_id);

}
