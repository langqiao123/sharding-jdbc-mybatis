package com.langqiao.sharding.jdbc.service;

import java.util.List;

import com.langqiao.sharding.jdbc.entity.User;

public interface IUserService {
    
    public boolean insert(User u);
    
    public List<User> findAll();
    
    public List<User> findByUserIds(List<Long> ids);
    
    public void transactionTestSucess();
    
    public void transactionTestFailure() throws IllegalAccessException;

}
