package com.springboot.acg.infrastructure.app.impl;

import com.springboot.acg.infrastructure.api.dto.UserCmd;
import com.springboot.acg.infrastructure.app.UserService;
import com.springboot.acg.infrastructure.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserGateway userGateway;

    @Override
    public String getUserById(UserCmd userCmd) {

        return null;
    }

    @Override
    public Boolean createUser(UserCmd userCmd) {
        return null;
    }
}
