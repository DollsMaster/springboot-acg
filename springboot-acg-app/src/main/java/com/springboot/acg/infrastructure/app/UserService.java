package com.springboot.acg.infrastructure.app;

import com.springboot.acg.infrastructure.api.dto.UserCmd;


public interface UserService {
    String getUserById(UserCmd userCmd);
    Boolean createUser(UserCmd userCmd);
}
