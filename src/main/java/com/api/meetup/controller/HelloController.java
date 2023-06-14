package com.api.meetup.controller;

import com.api.meetup.entity.HelloEntity;
import com.api.meetup.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    final HelloRepository helloRepository;

    @GetMapping("hello")
    public String hello() {
        HelloEntity entity = helloRepository.findAll().get(0);
        log.info("entity={}", entity);
        return "hello. world";
    }

}
