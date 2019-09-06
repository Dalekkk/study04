package com.wzx.mapper;

import com.wzx.dao.staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface staffMapper {
    int deleteByPrimaryKey(String usercode);

    int insert(staff record);

    int insertSelective(staff record);

    staff selectByPrimaryKey(String usercode);

    int updateByPrimaryKeySelective(staff record);

    int updateByPrimaryKey(staff record);

    List<staff> selectAll();


}