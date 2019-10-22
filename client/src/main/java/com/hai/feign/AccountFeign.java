package com.hai.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "account")
public interface AccountFeign {
    @GetMapping("/account/login/{user_name}/{user_pwd}/{type}")
    public Object login(@PathVariable("user_name") String user_name,@PathVariable("user_pwd") String user_pwd,@PathVariable("type") String type);
}
