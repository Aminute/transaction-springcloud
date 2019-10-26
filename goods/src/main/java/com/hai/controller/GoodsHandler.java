package com.hai.controller;

import com.hai.entity.Goods;
import com.hai.entity.GoodsVO;
import com.hai.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/*
       这个类主要提供对外接口
 */
@RestController
@RequestMapping("/goods")
public class  GoodsHandler {
//    @Value("${server.port}")
//    private String port;

    @Autowired
    private GoodsRepository goodsRepository;

//    @GetMapping("/index")
//    public String index(){
//        return this.port;
//    }

    @DeleteMapping("/deleteById/{goods_id}")
    public void deleteById(@PathVariable("goods_id") String goods_id){
        goodsRepository.deleteById(goods_id);
    }
    @GetMapping("/findAll/{index}/{limit}")
    public GoodsVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return new GoodsVO(0,"",goodsRepository.count(),goodsRepository.findAll(index,limit));
    }

    @PostMapping("/save")
    public void save(@RequestBody Goods goods){
        goodsRepository.save(goods);
    }

    @GetMapping("/findById/{goods_id}")
    public Goods findById(@PathVariable("goods_id") String goods_id){
        return goodsRepository.findById(goods_id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Goods goods){
        goodsRepository.update(goods);
    }
}
