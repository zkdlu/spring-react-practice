package com.zkdlu.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    public Team(String name) {
        this.name = name;
    }
}
