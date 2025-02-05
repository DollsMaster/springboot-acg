package com.example.springbootacg.cmd;

import com.example.springbootacg.repository.dataobject.BaseDO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserCmd extends BaseDO {

    private Long id;
    private String name;
    private String email;
    private String avatar;
    private String password;
    private String nikeName;
}
