package com.virtual.meetup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TEST_TABLE", schema = "MEETUPDB")
public class TestTable {

    @Id @GeneratedValue
    private Long id;

    private String name;

}
