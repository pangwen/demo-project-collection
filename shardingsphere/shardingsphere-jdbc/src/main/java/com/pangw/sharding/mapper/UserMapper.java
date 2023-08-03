package com.pangw.sharding.mapper;

import com.pangw.sharding.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    void insert(UserEntity user);

    void insertBatch(List<UserEntity> list);

    List<UserEntity> list();
}
