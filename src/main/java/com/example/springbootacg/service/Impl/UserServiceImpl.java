package com.example.springbootacg.service.Impl;

import com.example.springbootacg.cmd.UserCmd;
import com.example.springbootacg.model.UserEntity;
import com.example.springbootacg.repository.dataobject.UserDO;
import com.example.springbootacg.repository.mapper.UserMapper;
import com.example.springbootacg.service.UserService;
import com.example.springbootacg.utils.ConvertorUtils;
import com.example.springbootacg.utils.ResultHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Long createUser(UserCmd userCmd) {
        UserDO userDO = ConvertorUtils.convert(userCmd, UserDO.class);
        Integer result = userMapper.insert(userDO);
        return userDO.getId();
    }

    public UserCmd getUserById(UserCmd userCmd) {
        Object userResult = userMapper.selectById(userCmd.getId());
        return ConvertorUtils.convert(userResult, UserCmd.class);
    }

    @Override
    public Integer updateUser(UserCmd userCmd) {
        return userMapper.updateById(userCmd);
    }

    @Override
    public Integer deleteUserById(UserCmd userCmd) {
        return userMapper.deleteById(userCmd.getId());
    }

}
