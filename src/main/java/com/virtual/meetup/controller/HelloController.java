package com.virtual.meetup.controller;

import com.virtual.meetup.entity.TestTable;
import com.virtual.meetup.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello() {

        TestTable testTable = helloService.findAll();

        return "Hello World";
    }
}
