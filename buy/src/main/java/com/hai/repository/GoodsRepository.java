package com.hai.repository;

import com.hai.entity.Goods;

import java.util.List;

public interface GoodsRepository {
    public Goods findById(String goods_id);

}