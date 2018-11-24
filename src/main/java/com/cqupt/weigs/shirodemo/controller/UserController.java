package com.cqupt.weigs.shirodemo.controller;

import com.cqupt.weigs.shirodemo.common.Result;
import com.cqupt.weigs.shirodemo.entity.User;
import com.cqupt.weigs.shirodemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weigs
 * @date 2018/11/11 0011
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<String> login(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);
        return Result.success("登录成功");
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<String> register(User user) {
        return userService.insertUser(user);
    }
}
