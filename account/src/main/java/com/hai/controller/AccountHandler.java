package com.hai.controller;

import com.hai.repository.AdminRepository;
import com.hai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    //使用多态返回数据，既可以返回User也可以返回Admin
    @GetMapping("/login/{user_name}/{pwd}/{type}")
    public Object login(@PathVariable("user_name") String user_name,@PathVariable("pwd") String user_pwd,@PathVariable("type") String type){
        Object object = new Object();
        switch (type){
            case "user":
                object = userRepository.login(user_name,user_pwd);
                break;
            case "admin":
                object = adminRepository.login(user_name,user_pwd);
                break;
        }
        return object;
    }
}
