package com.langqiao.sharding.jdbc.service;

import java.util.List;

import com.langqiao.sharding.jdbc.entity.TUserDo;

public interface IUserService {
    
    public boolean insert(TUserDo u);
    
    public List<TUserDo> findAll();
    
    public List<TUserDo> findByUserIds(List<Long> ids);
    
    public void transactionTestSucess();
    
    public void transactionTestFailure() throws IllegalAccessException;

}
