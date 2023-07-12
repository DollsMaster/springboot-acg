package com.example.springacg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonInfo {
    private Integer id;
    private Integer userId;
    private String description;
    private Integer integral;
    private String articles;
    private String comments;
    private String fans;
    private String attentions;
}
