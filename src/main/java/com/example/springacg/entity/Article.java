package com.example.springacg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Article {
    private long id;
    private String name;
    private String cover;
    private String content;
    private String menus;
    private String tags;
    private String downloads;
    private String createTime;
    private String file;
    private int status;
}
