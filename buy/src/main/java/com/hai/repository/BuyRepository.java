package com.hai.repository;

import com.hai.entity.Buy;

import java.util.List;

public interface BuyRepository {
    public void save(Buy buy);
    public List<Buy> findAllById(int index,int limit,String  user_id);
    public int countById(String user_id);
    public List<Buy> findAllState(int index,int limit);
    public void updateState(int id);
    public int countState();
}
