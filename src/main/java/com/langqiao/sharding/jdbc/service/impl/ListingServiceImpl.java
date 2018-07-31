package com.langqiao.sharding.jdbc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.langqiao.sharding.jdbc.entity.Student;
import com.langqiao.sharding.jdbc.mapper.StudentMapper;
import com.langqiao.sharding.jdbc.service.IListingService;

@Service
public class ListingServiceImpl implements IListingService{
    
    @Resource
    public StudentMapper studentMapper;

    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0 ? true : false;
    }

}
