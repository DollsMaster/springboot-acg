package com.example.springacg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String name;
    private String password;
    private String salt;
    private String email;
    private String cover;
    private int status;
    private String createTime;
}
