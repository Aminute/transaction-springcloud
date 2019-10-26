package com.hai.entity;

import lombok.Data;
import org.bouncycastle.cms.PasswordRecipientId;

import java.util.List;

@Data
public class BuyVO {
    private int code;
    private String msg;
    private int count;
    private List<Buy> data;
}
