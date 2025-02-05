package com.example.springbootacg.repository.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class UserDO extends BaseDO {
    private Long id;
    private String name;
    private String email;
    private String avatar;
    private String password;
    private String nikeName;
}
