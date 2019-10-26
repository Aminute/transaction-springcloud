package com.hai.entity;

import lombok.Data;

@Data
public class Buy {

    private int id;
    private String user_id;
    private User user;
    private String goods_id;
    private String date;
    private Goods goods;
}
