package com.hao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //set,get方法
@AllArgsConstructor //所有参数构造器
@NoArgsConstructor  //无参构造器
public class User {
    private int userId;
    private String userName;
    private int userAge;
    private String userAddress;
}
