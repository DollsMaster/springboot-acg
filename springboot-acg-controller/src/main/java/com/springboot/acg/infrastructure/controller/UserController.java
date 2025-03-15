package com.springboot.acg.infrastructure.controller;


import com.springboot.acg.infrastructure.app.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.acg.infrastructure.api.dto.UserCmd;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public Boolean createUser(@RequestBody UserCmd userCmd) {
        return userService.createUser(userCmd);
    }

    @PostMapping("getUserById")
    public String getUserById(@RequestBody UserCmd userCmd) {
        userService.getUserById(userCmd);
        return "success";
    }
}
