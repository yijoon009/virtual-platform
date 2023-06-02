package com.virtual.meetup.repository;

import com.virtual.meetup.entity.TestDataTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<TestDataTable, Long> {
}
