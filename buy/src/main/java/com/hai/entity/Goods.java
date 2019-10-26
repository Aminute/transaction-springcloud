package com.hai.entity;

import lombok.Data;

@Data
public class Goods {
    private String goods_id;
    private String user_id;
    private double goods_price;
    private String goods_class;//这里是分类type
    private String goods_comment;
    private String goods_picture;
    private String goods_name;
    private String goods_res1;
    private String goods_res2;
}
