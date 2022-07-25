package com.hao;

import com.hao.pojo.User;
import com.hao.service.UserService;
import com.hao.service.UserServiceImp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    @Test
    public void test1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        for(String obj:ac.getBeanDefinitionNames()){
            System.out.println(obj);
        }

    }
}
