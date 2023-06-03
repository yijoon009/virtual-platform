package com.api.meetup.controller;

import com.api.meetup.entity.HelloEntity;
import com.api.meetup.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    final HelloRepository helloRepository;

    @GetMapping("hello")
    public String hello() {
        HelloEntity entity = helloRepository.findAll().get(0);
        return "hello. world";
    }

}
