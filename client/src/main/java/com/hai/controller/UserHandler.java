package com.hai.controller;

import com.hai.entity.User;
import com.hai.entity.UserVO;
import com.hai.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index=(page-1)*limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userFeign.count());
        userVO.setData(userFeign.findAll(index,limit));
        return userVO;
    }

    @GetMapping("/findById/{user_id}")
    public User findById(@PathVariable("user_id") String user_id){
        return userFeign.findById(user_id);
    }

    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    }

    @PostMapping("/save")
    public String  save(User user){

        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userFeign.update(user);
    }

    @GetMapping("/deleteById/{user_id}")
    public String  deleteById(@PathVariable("user_id") String user_id){

        userFeign.deleteById(user_id);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/redirect/{location}")//处理前端页面跳转
    public String redirect(@PathVariable("location") String location){
        //List<Goods> res = goodsFeign.findAll(0,10);
        return location;
    }
}
