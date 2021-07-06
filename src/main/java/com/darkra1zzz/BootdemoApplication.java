package com.darkra1zzz;

import com.darkra1zzz.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class BootdemoApplication {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello SpringBoot";
    }

    @RequestMapping("/")
    public String tohello2(Model model){
        model.addAttribute("msg","我是后端发送的数据");
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        model.addAttribute("list",list);

        List<User> userList=new ArrayList<>();
        userList.add(new User("妙蛙种子",10));
        userList.add(new User("小火龙",20));
        userList.add(new User("杰尼龟",30));
        model.addAttribute("userList",userList);

        User user=new User("达克雷伊",1000);
        model.addAttribute("user",user);
        return "hello2";
    }

    @RequestMapping("/*")
    public String toAnywhere(HttpServletRequest request){
        return request.getServletPath();
    }

    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);
    }

}
