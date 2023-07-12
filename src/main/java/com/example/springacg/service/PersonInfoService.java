package com.example.springacg.service;

import com.example.springacg.entity.PersonInfo;
import com.example.springacg.entity.User;
import com.example.springacg.mapper.PersonInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoService {
    @Autowired
    PersonInfoMapper personInfoMapper;
    public PersonInfo findPersonInfoByUserId(Integer userId) {
        return personInfoMapper.findPersonInfoByUserId(userId);
    }

    public Integer insertPersonInfo(PersonInfo personInfo) {
        return personInfoMapper.insertPersonInfo(personInfo);
    }

    public Integer initPersonInfo(User user) {
        Long userId = user.getId();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(Integer.parseInt(userId.toString()));
        personInfo.setIntegral(0);
        return this.insertPersonInfo(personInfo);
    }
}
