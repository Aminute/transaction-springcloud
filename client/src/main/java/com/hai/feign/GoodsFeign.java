package com.hai.feign;

import com.hai.entity.Goods;
import com.hai.entity.GoodsVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/*
    调用服务提供者的handler
 */
@FeignClient(value = "goods") //关联到微服务
public interface GoodsFeign {
    @GetMapping("/goods/findAll/{index}/{limit}")
    public GoodsVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit );

//    @DeleteMapping("/goods/deleteById/{good_id}")
////    public void deleteById(@PathVariable("goods_id") String goods_id);

    @DeleteMapping("goods/deleteById/{goods_id}")
    public void deleteById(@PathVariable("goods_id") String goods_id);

    @PostMapping("/goods/save")
    public ModelAndView save (Goods goods);

    @GetMapping("/goods/findById/{goods_id}")
    public Goods findById(@PathVariable("goods_id") String goods_id);

    @PutMapping("/goods/update")
    public void update(Goods goods);
}
