package com.hai.controller;

import com.hai.entity.Buy;
import com.hai.entity.BuyVO;
import com.hai.repository.BuyRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyHandler {
    @Autowired
    private BuyRepository buyRepository;

    @PostMapping("/save")
    public void save(@RequestBody Buy buy){
        buyRepository.save(buy);
    }

    @GetMapping("/findAllById/{index}/{limit}/{user_id}")
    public BuyVO findAllById(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("user_id") String user_id){
        BuyVO buyVO = new BuyVO();
        buyVO.setCode(0);
        buyVO.setCount(buyRepository.countById(user_id));
        buyVO.setMsg("");
        buyVO.setData(buyRepository.findAllById(index,limit,user_id));
        return buyVO;
    }

    @GetMapping("/countById/{user_id}")
    public int countById(@PathVariable("user_id") String user_id){
        return buyRepository.countById(user_id);
    }

    @GetMapping("/findAllState/{index}/{limit}")
    public BuyVO findAllState(@PathVariable("index") int index,@PathVariable("limit") int limit){
        BuyVO buyVO = new BuyVO();
        buyVO.setCode(0);
        buyVO.setCount(buyRepository.countState());
        buyVO.setMsg("");
        buyVO.setData(buyRepository.findAllState(index,limit));
        return buyVO;
    }

    @GetMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") int id){
        buyRepository.updateState(id);
    }
}
