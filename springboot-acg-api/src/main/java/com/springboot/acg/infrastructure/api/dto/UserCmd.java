package com.springboot.acg.infrastructure.api.dto;

import lombok.Data;

@Data
public class UserCmd extends DTO {

    private Long id;

    private String name;

    private String nickName;

    private String password;

    private String email;
}
