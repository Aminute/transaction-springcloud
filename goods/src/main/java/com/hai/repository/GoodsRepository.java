package com.hai.repository;

import com.hai.entity.Goods;

import java.util.List;

public interface GoodsRepository {
    public List<Goods> findAll(int index, int limit);
    public int count();
    public Goods findById(String goods_id);
    public void save(Goods goods);
    public void update(Goods goods);
    public void deleteById(String goods_id);
}