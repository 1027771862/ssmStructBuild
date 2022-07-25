package com.hao.service;

import com.hao.dao.UserMapper;
import com.hao.pojo.User;

import java.util.List;

public class UserServiceImp implements UserService {
    //服务层service调用dao层
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int queryExist(User user) {
        return userMapper.queryExist(user);
    }
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }
}
