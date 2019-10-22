package com.hai.repository;

import com.hai.entity.Admin;

public interface AdminRepository {
    public Admin login(String admin_name, String admin_pwd);
}
