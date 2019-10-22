package com.hai.controller;

import com.hai.entity.Admin;
import com.hai.entity.User;
import com.hai.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @GetMapping("/redirect/{location}")//处理前端页面跳转
    public String redirect(@PathVariable("location") String location){
        //List<Goods> res = goodsFeign.findAll(0,10);
        return location;
    }

    @PostMapping("/login")
    public String login(@RequestParam("user_name") String user_name, @RequestParam("user_pwd") String user_pwd, @RequestParam("type") String type, HttpSession session  ){

        //object是hashmap形式，不能直接强制类型转换
        Object object = accountFeign.login(user_name,user_pwd,type);
        LinkedHashMap<String ,Object> hashMap = (LinkedHashMap)object;
            String result = null;
            if (object == null){
                result="login";
            }else{
                switch (type){
                    case "user":
                        User user = new User();
                        String user_id = (String)hashMap.get("user_id");
                        String user_name1 = (String)hashMap.get("user_name");
                        user.setUser_id(user_id);
                        user.setUser_name(user_name1);
                        session.setAttribute("user",user);
                        result = "index";
                        break;
                    case "admin":
                        Admin admin = (Admin)object;
                        session.setAttribute("admin",admin);
                        result = "";
                        break;
                }
            }
            return result;
    }
}
