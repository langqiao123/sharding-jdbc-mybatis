package com.langqiao.sharding.jdbc.service;

import java.util.List;

import com.langqiao.sharding.jdbc.entity.User;

public interface UserService {
    
    public boolean insert(User u);
    
    public List<User> findAll();
    
    public List<User> findByUserIds(List<Integer> ids);
    
    public void transactionTestSucess();
    
    public void transactionTestFailure() throws IllegalAccessException;

}
