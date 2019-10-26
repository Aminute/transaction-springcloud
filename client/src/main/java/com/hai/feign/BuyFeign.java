package com.hai.feign;

import com.hai.entity.Buy;
import com.hai.entity.BuyVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "buy")
public interface BuyFeign {

    @PostMapping("/buy/save")
    public void save(@RequestBody  Buy buy);

    @GetMapping("/buy/findAllById/{index}/{limit}/{user_id}")
    public BuyVO findAllById(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("user_id") String user_id);

    @GetMapping("/buy/findAllState/{index}/{limit}")
    public BuyVO findAllState(@PathVariable("index") int index,@PathVariable("limit") int limit);

    @GetMapping("/buy/updateState/{id}")
    public void updateState(@PathVariable("id") int id);
}
