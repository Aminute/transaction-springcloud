package com.hai.repository;

import com.hai.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index,int limit);
    public User findById(String user_id);
    public int count();
    public void save(User user);
    public void update(User user);
    public void deleteById(String user_id);
}
