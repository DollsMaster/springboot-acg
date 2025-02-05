package com.example.springbootacg.service;

import com.example.springbootacg.cmd.UserCmd;

public interface UserService {
    Long createUser(UserCmd userCmd);
    UserCmd getUserById(UserCmd userCmd);
    Integer updateUser(UserCmd userCmd);
    Integer deleteUserById(UserCmd userCmd);
}
