package com.virtual.meetup.service;


import com.virtual.meetup.entity.TestDataTable;
import com.virtual.meetup.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public TestDataTable findAll() {
        return helloRepository.findAll().get(0);
    }

}
