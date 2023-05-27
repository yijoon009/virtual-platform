package com.virtual.meetup.repository;

import com.virtual.meetup.entity.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<TestTable, Long> {
}
