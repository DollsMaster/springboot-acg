package com.example.springacg.mapper;

import com.example.springacg.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    User getUserById(Integer id);
    User getUserByEmail(String email);
    User getUserByAccount(String email, String password);
    List<User> getUserList();
    Integer registerUser(User user);

}
