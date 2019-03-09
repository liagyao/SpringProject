package com.ly.bigProject.controller;


import com.ly.bigProject.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/test")
public class TestConteoller {


    @GetMapping("/get/{id}")
    public  User login(@PathVariable MultipartFile file){
        try {
            InputStream in=file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            OutputStream outputStream=new FileOutputStream(new File(""));
            outputStream.write(file.getInputStream().read());

        } catch (Exception e) {

        } finally {
        }

        User us=new User();
        us.setAge("sss");
        us.setHig("xxx");
        us.setName("ly");
            return us;
    }
}
