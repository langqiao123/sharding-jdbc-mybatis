package com.langqiao.sharding.jdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.langqiao.sharding.jdbc.entity.Student;
import com.langqiao.sharding.jdbc.entity.TUserDo;
import com.langqiao.sharding.jdbc.entity.User;
import com.langqiao.sharding.jdbc.mapper.StudentMapper;
import com.langqiao.sharding.jdbc.mapper.TUserDoMapper;
import com.langqiao.sharding.jdbc.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    public TUserDoMapper userMapper;
    
    @Resource
    public StudentMapper studentMapper;

    public boolean insert(TUserDo u) {
        return userMapper.insert(u) > 0 ? true :false;
    }

    public List<TUserDo> findAll() {
        return userMapper.findAll();
    }

    public List<TUserDo> findByUserIds(List<Long> ids) {
        return userMapper.findByUserIds(ids);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void transactionTestSucess() {
    	TUserDo u = new TUserDo();
        u.setUserId(13L);
        u.setAge(25);
        u.setName("war3 1.27");
        userMapper.insert(u);
        
        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe");
        studentMapper.insert(student);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void transactionTestFailure() throws IllegalAccessException {
    	TUserDo u = new TUserDo();
        u.setUserId(13L);
        u.setAge(25);
        u.setName("war3 1.27 good");
        userMapper.insert(u);
        
        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe1");
        studentMapper.insert(student);
        throw new IllegalAccessException();
    }
    
}
