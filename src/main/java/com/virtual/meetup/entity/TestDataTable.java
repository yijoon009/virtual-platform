package com.virtual.meetup.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TEST_TABLE", schema = "MEETUPDB")
public class TestDataTable {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

}
