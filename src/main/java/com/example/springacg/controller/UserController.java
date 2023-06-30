package com.example.springacg.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.springacg.config.MyException;
import com.example.springacg.entity.User;
import com.example.springacg.service.UserService;
import com.example.springacg.utils.ResponseStatus;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseStatus login(@RequestBody User user) {
        User userResult;
        try {
            userResult = userService.login(user);
        } catch (RuntimeException runtimeException) {
            throw new MyException(runtimeException.getMessage());
        }
        StpUtil.login(userResult.getId());
        return ResponseStatus.ok("success", userResult);
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    public ResponseStatus loginOut(@RequestBody User user) {
        try {
            StpUtil.logout(user.getId());
            return ResponseStatus.ok("success");
        } catch (Exception e) {
            return ResponseStatus.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/getUserByToken/{token}", method = RequestMethod.GET)
    public ResponseStatus getUserByToken(@PathVariable String token) {
        Object loginId = StpUtil.getTokenInfo().loginId;
        Integer id = Integer.parseInt(loginId.toString());
        User result = userService.getUserByToken(id);
        return ResponseStatus.ok("success", result);
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public ResponseStatus getUserList(@RequestParam(defaultValue = "0") int pageNo,
                                      @RequestParam(defaultValue = "30") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> result = userService.getUserList();
        PageInfo helper = new PageInfo(result);
        return ResponseStatus.ok(result, helper);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseStatus registerAccount(@RequestBody User user) {
        Integer result = userService.registerUser(user);
        if (result == 1) {
            return ResponseStatus.ok("success");
        }
        return ResponseStatus.error("error");
    }
}
