package com.ly.bigProject.controller;


import com.ly.bigProject.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@RequestMapping("/test")
public class TestConteoller {



    @GetMapping("/get/{id}")
    @ResponseBody
    public  User login(@PathVariable MultipartFile file){
        User us=new User();
        us.setAge("sss");
        us.setHig("xxx");
        us.setName("ly");
            return us;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping( "/add")
    public String addUser(){
        System.out.println("用户添加");
        return "add";
    }

    @GetMapping("/update")
    public String update(){
        System.out.println("用户更新");

        return "update";
    }
    @GetMapping("/404")
    public String to404(){


        return "404";
    }
    @GetMapping("/tologin")
    public String tologin(){


        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","安全退出！");
        return "login";

    }



    @PostMapping("/login")
    public String login(String name , String pwd, Model model){
        System.out.println("xxxxxx");
        //1.获取Subject
        Subject sb= SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(name,pwd);

        //3执行登录方法
        try{
            sb.login(token);
            return "redirect:/test/index";

        }catch (UnknownAccountException e){
            //用户名不存在
            System.out.println("用户名不存在");
            model.addAttribute("msg","用户名不存在");
            return "login";

        }catch (IncorrectCredentialsException e){
            //密码错误
            System.out.println("密码错误");
            model.addAttribute("msg","密码错误");
            return "login";
        }
       // return "404";
    }


}
