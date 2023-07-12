package com.example.springacg.mapper;

import com.example.springacg.entity.PersonInfo;
import org.springframework.stereotype.Component;

@Component
public interface PersonInfoMapper {
    PersonInfo findPersonInfoByUserId(Integer userId);
    Integer insertPersonInfo(PersonInfo personInfo);
}
