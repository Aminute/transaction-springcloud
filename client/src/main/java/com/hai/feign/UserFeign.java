package com.hai.feign;

import com.hai.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")//这个user是进行关联的
public interface UserFeign {
    @GetMapping("/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit);

    @GetMapping("/user/findById/{user_id}")
    public User findById(@PathVariable("user_id") String user_id);

    @GetMapping("/user/count")
    public int count();

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @PutMapping("/user/update")
    public void update(@RequestBody User user);

    @DeleteMapping("/user/delete/{user_id}")
    public void deleteById(@PathVariable("user_id") String user_id);
}
