package com.example.springbootacg.model;

import com.example.springbootacg.repository.dataobject.BaseDO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserEntity extends BaseDO {
    private Long id;
    private String name;
    private String email;
    private String avatar;
    private String nikeName;
}
