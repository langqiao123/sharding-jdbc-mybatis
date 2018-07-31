package com.langqiao.sharding.jdbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.langqiao.sharding.jdbc.entity.Student;
import com.langqiao.sharding.jdbc.entity.User;
import com.langqiao.sharding.jdbc.mapper.StudentMapper;
import com.langqiao.sharding.jdbc.mapper.UserMapper;
import com.langqiao.sharding.jdbc.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    public UserMapper userMapper;
    
    @Resource
    public StudentMapper studentMapper;

    public boolean insert(User u) {
        return userMapper.insert(u) > 0 ? true :false;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> findByUserIds(List<Long> ids) {
        return userMapper.findByUserIds(ids);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void transactionTestSucess() {
        User u = new User();
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
        User u = new User();
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
