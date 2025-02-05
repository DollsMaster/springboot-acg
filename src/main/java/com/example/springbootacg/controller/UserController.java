package com.example.springbootacg.controller;

import com.example.springbootacg.cmd.UserCmd;
import com.example.springbootacg.dto.Result;
import com.example.springbootacg.model.UserEntity;
import com.example.springbootacg.service.UserService;
import com.example.springbootacg.utils.ResultHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/createUser")
    public Result<Long> createUser(@RequestBody UserCmd userCmd) {
        Long result = userService.createUser(userCmd);
        return ResultHelper.success(result);
    }

    @PostMapping("/user/getUserById")
    public Result<UserCmd> getUserById(@RequestBody UserCmd userCmd) {
        UserCmd userResult = userService.getUserById(userCmd);
        return ResultHelper.success(userResult);
    }

    @PostMapping("/user/updateUser")
    public Result<Integer> updateUser(@RequestBody UserCmd userCmd) {
        Integer result = userService.updateUser(userCmd);
        return ResultHelper.success(result);
    }

    @PostMapping("/user/deleteUserById")
    public Result<Integer> deleteUserById(@RequestBody UserCmd userCmd) {
        Integer result = userService.deleteUserById(userCmd);
        return ResultHelper.success(result);
    }
}
