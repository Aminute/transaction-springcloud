package com.hai.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.DatagramSocket;

@Data
public class Buy {

    private int id ;
    private String  user_id;
    private User user;
    private String goods_id;
    private String  date;
    private Goods goods;
}
