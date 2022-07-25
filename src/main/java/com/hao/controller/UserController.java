package com.hao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hao.pojo.User;
import com.hao.service.UserServiceImp;
import com.mysql.cj.xdevapi.JsonParser;
import com.mysql.cj.xdevapi.JsonString;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@Controller
public class UserController {
//controller层调service层
    @Autowired
    @Qualifier(value = "userServiceImp")
    private UserServiceImp userServiceImp;

    //跳转到登录页面
    @RequestMapping("/toLoginPage")
    public String toLoginPage(HttpSession session){
        //保持会话的session，不用重复登录，注销便移除
        if(session.getAttribute("userLoginInfo")!=null){
            return "root";
        }
        return "login";
    }
    //阿贾克斯请求返回输入的实时响应
    @PostMapping(value = "/umWarn",produces = {"text/html;charset=UTF-8","application/json;charset=UTF-8"})
    @ResponseBody
    public String umWarn(String userName, String age){   //post请求提交的参数自动按名就位，input的name属性--->参数user的属性名字
        List<User> list=userServiceImp.queryAllUser();
        String msg="error";
        if(userName!=null){
            for(User u:list){
                if(u.getUserName().equals(userName)){
                    msg= "ok";
                }
            }
            if(msg.equals("error")){
                msg="用户名不存在";
            }
        }else msg="请输入用户名";
        return msg;
    }
    @PostMapping(value = "/ageWarn",produces = {"text/html;charset=UTF-8","application/json;charset=UTF-8"})
    @ResponseBody
    public String ageWarn(String userName, String userAge){   //post请求提交的参数自动按名就位，input的name属性--->参数user的属性名字
        List<User> list=userServiceImp.queryAllUser();
        String msg="error";
        if(userName==null){
            return "请输入用户名";
        }
        if(userAge!=null){
            int Age;
            try{
                Age=Integer.parseInt(userAge);
            } catch (NumberFormatException e) {
                return "请输入真实年龄";
            }
            for(User u:list){
                if(u.getUserName().equals(userName)&&u.getUserAge()==Integer.parseInt(userAge)){
                    msg= "ok";
                }
            }
            if(msg.equals("error")){
                msg="年龄不对应";
            }
        }
        return msg;
    }
    //按下登录的验证
    @PostMapping(value = "/login" ,produces = {"text/html;charset=UTF-8","application/json;charset=UTF-8"})
    public String login(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        for (User u : userServiceImp.queryAllUser()) {
            if (u.getUserName().equals(request.getParameter("username"))) {
                if (String.valueOf(u.getUserAge()).equals(request.getParameter("age"))) {
                    session.setAttribute("userLoginInfo",u);
                    return "root";
                }
            }
        }
        //response.getWriter().write("<script>alert(\"用户名或密码错误\")</script>");
        return "login";
    }
    @RequestMapping("root/reLogin")
    public String reLogin(HttpSession session){
        session.removeAttribute("userLoginInfo");
        return "redirect:/toLoginPage";
    }
    //跳转到展示所有用户页面
    @RequestMapping("/root/allUser")
    public String allUser(Model model  ){
        List<User> list=new LinkedList<>();
        list=userServiceImp.queryAllUser();
        model.addAttribute("list",list);
        return "allUser";
    }
    //跳转到增加用户页面
    @RequestMapping("/root/toAddPage")
    public String toAddUser(){
        return "addUser";
    }
    //表单提交请求实现参数传递增加用户,后跳转回展示页
    @RequestMapping("/root/addUser")
    public String addUser(User user){
        userServiceImp.addUser(user);
        return "redirect:/root/allUser";
    }

    //跳转请求时携带用户id参数，找出用户对象附到页面的model中
    @RequestMapping("/root/toUpdateUser")
    public String toUpdateUser(@RequestParam("id") int id,Model model){
        User user=userServiceImp.queryUserById(id);
        model.addAttribute("queryUsers",user);
        return "updateUser";
    }
    @RequestMapping("/root/updateUser")
    public String updateUser(User user){
        userServiceImp.updateUser(user);
        return "redirect:/root/allUser";
    }
    @RequestMapping("/root/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int userId){
        userServiceImp.deleteUser(userId);
        return "redirect:/root/allUser";
    }

    @RequestMapping( value = "/root/searchUser",method = RequestMethod.POST,produces = {"text/html;charset=UTF-8","application/json;charset=UTF-8"})
    @ResponseBody
    public String search(@Param("keyword") String keyword  ) throws JsonProcessingException {
        List<User> list=userServiceImp.queryAllUser();
        List<User> list1=new LinkedList<>();
        for (User user:list) {
            if(user.getUserName().contains(keyword)||String.valueOf(user.getUserAge()).contains(keyword)||user.getUserAddress().contains(keyword)){
                list1.add(user);
            }
        }
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(list1);
        return json;
    }
}