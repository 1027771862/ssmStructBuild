package com.hao.dao;
import com.hao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //新增一个人
    int addUser(User user);
    //伤处一个人
    int deleteUser(@Param("userid") int id);
    //更新一个人
    int updateUser(User user);
    //查询一个人
    int queryExist(User user);
    //在方法参数的前面写上@Param("参数名")，表示给参数命名，名称就是括号中的内容
    //给入参 String name 命名为aaaa，然后sql语句....where  s_name= #{aaaa} 中就可以根据aaaa得到参数值了。
    User queryUserById(@Param("userId") int id);
    //查询全部人
    List<User> queryAllUser();
}
