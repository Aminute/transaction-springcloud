package com.hai.controller;

import com.hai.entity.Buy;
import com.hai.entity.BuyVO;
import com.hai.entity.User;
import com.hai.feign.BuyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/buy")
public class BuyHandler {

    @Autowired
    private BuyFeign buyFeign;

    @GetMapping("/save/{goods_id}")
    public String save(@PathVariable("goods_id") String goods_id, HttpSession session){
        User user = (User)session.getAttribute("user");
        Buy buy = new Buy();
        buy.setUser_id(user.getUser_id());
        buy.setGoods_id(goods_id);
        buy.setDate("jjjj");
        buyFeign.save(buy);

        return "buy";
    }

    @GetMapping("/findAllById")
    @ResponseBody
    public BuyVO findAllById(@RequestParam("page") int page,@RequestParam("limit") int limit, HttpSession session){
        User user = (User)session.getAttribute("user");
        int index = (page-1)*limit;
        return buyFeign.findAllById(index,limit,user.getUser_id());
    }

    @GetMapping("/findAllState")
    @ResponseBody
    public BuyVO findAllState(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return buyFeign.findAllState(index,limit);
    }

    @GetMapping("/updateState/{id}")
    @ResponseBody
    public String  updateState(@PathVariable("id") int id){
        buyFeign.updateState(id);
        return "redirect:/goods/redirect/buyHandler";
    }
}
