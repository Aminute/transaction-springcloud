package com.hai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String user_id;
    private String user_name;
    private String user_pwd;
    private String user_mail;
    private String user_school;
    private String user_major;
    private String user_sid;
    private String user_res1;
    private String user_res2;
}
