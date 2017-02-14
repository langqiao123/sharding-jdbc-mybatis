package com.study.dangdang.sharding.jdbc.mapper;

import java.util.List;

import com.study.dangdang.sharding.jdbc.entity.User;

public interface UserMapper {
    
    Integer insert(User u);
    
    List<User> findAll();
    
    List<User> findByUserIds(List<Integer> userIds);
    

}
