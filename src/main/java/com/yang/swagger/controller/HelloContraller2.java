package com.yang.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="HelloContraller2",  description="测试多个contraller")
@RestController
public class HelloContraller2 {
    @ApiOperation("hello接口")
    @GetMapping(value = "/hhello")
    public String hello() {
        return "hello";
    }
}

