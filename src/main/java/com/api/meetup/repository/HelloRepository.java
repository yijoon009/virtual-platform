package com.api.meetup.repository;

import com.api.meetup.entity.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<HelloEntity, Long> {
}
