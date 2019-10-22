package com.hai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVO {
    private int code;
    private String msg;
    private int count;
    private List<Goods> data;
}
