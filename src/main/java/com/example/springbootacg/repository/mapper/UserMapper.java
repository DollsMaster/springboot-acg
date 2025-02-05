package com.example.springbootacg.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootacg.model.UserEntity;
import com.example.springbootacg.repository.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BasedMapper<UserDO> {
}
