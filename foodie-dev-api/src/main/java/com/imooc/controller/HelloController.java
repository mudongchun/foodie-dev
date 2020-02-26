package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Object hello(){
        System.out.println("hello world");
        return "hello world";
    }
}
