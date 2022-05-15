package com.yang.swagger.controller;

import com.yang.swagger.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="HelloContraller",  description="ces ")
@RestController
public class HelloContraller {

    @ApiOperation("hello接口")
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("user接口")
    @PostMapping(value = "/user")
    public User user() {
        return new User();
    }

    @PostMapping(value = "/new/user")
    public User newuser(@ApiParam("user类") User user) {
        return user;
    }

}
