package com.hai.controller;

import com.hai.entity.Goods;
import com.hai.entity.GoodsVO;
import com.hai.feign.GoodsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/goods")
public class GoodsHandler {

    @Autowired
    private GoodsFeign goodsFeign;

    @GetMapping("/findAll")
    @ResponseBody//表示只返回数据，不返回视图
    public GoodsVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index =(page-1)*limit;
        return goodsFeign.findAll(index,limit);
    }
    @GetMapping("/redirect/{location}")//处理前端页面跳转
    public String redirect(@PathVariable("location") String location){
        //List<Goods> res = goodsFeign.findAll(0,10);
        return location;
    }

    @GetMapping("/deleteById/{goods_id}")
    public String deleteById(@PathVariable("goods_id") String goods_id){
        goodsFeign.deleteById(goods_id);
        return "redirect:/goods/redirect/goods_manage";
    }

    @PostMapping("/save")
    public String  save(Goods goods){
        goodsFeign.save(goods);
        return "redirect:/goods/redirect/goods_add";
    }

    @GetMapping("/findById/{goods_id}")
    public ModelAndView findById(@PathVariable("goods_id") String goods_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goods_update");
        modelAndView.addObject("goods",goodsFeign.findById(goods_id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String Update(Goods goods){
        goodsFeign.update(goods);
        return "redirect:/goods/redirect/goods_manage";
    }

}
