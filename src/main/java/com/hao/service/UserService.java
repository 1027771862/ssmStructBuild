package com.hao.service;

import com.hao.pojo.User;

import java.util.List;

public interface UserService {
    //新增一个用户
    int addUser(User user);
    //删除一个用户
    int deleteUser(int id);
    //更新用户
    int updateUser(User user);
    //查询用户是否存在
    int queryExist(User user);
    //id查询用户
    User queryUserById(int id);
    //查询所有用户
    List<User> queryAllUser();
}
