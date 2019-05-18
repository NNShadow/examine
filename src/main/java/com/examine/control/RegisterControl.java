package com.examine.control;

import com.examine.model.User;
import com.examine.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RegisterControl {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/insertUser")
    public String userRegister(User user){
        if(!userService.isEmpty(user.getUsername()))
            return "用户名已存在";
        userService.insertUser(user);
        return "注册成功";
    }

}
