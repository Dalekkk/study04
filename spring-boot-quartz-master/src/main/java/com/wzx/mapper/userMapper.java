package com.wzx.mapper;

import com.wzx.dao.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    int deleteByPrimaryKey(String userid);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(String userid);

    user selectByName(String username);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}