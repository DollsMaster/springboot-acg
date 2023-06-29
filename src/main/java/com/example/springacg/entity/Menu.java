package com.example.springacg.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class Menu {
    private Long id;
    private String url;
    private String name;
    private String sort;
    private Long parentId;
    private String parentName;
    private String timestamp;
    private ArrayList children = new ArrayList();
}
