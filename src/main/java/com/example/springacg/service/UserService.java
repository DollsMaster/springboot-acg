package com.example.springacg.service;

import com.example.springacg.entity.User;
import com.example.springacg.mapper.UserMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Value("${securityConfig.saltConfigName}")
    private String saltConfigName;
    @Value("${securityConfig.saltConfigNum}")
    private int saltConfigNum;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public User login(User user) {
        String password = user.getPassword().toString();
        User userInfo = userMapper.getUserByEmail(user.getEmail().toString());
        if (userInfo == null) {
            throw new RuntimeException("没有找到账号...");
        }

        String salt = userInfo.getSalt();
        String encodePassword = new SimpleHash(saltConfigName, password, salt, saltConfigNum).toString();

        if (!userInfo.getPassword().toString().equals(encodePassword)) {
            throw new RuntimeException("账号是找到了,但是密码是错的...");
        }
        return userInfo;
    }

    public User getUserByAccount(String email, String password) {
        User user = userMapper.getUserByAccount(email, password);
        System.out.println(user);
        return user;
    }

    public Integer registerUser(User user) {
        String password = user.getPassword();
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encodePassword = new SimpleHash(saltConfigName, password, salt, saltConfigNum).toString();
        user.setSalt(salt);
        user.setPassword(encodePassword);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = simpleDateFormat.format(date);
        user.setCreateTime(time);
        return userMapper.registerUser(user);
    }

}
