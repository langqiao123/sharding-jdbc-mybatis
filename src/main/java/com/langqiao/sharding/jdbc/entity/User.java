package com.langqiao.sharding.jdbc.entity;

import java.io.Serializable;

public class User implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    

    private Long id;
    
    private Long userId;
    
    private String name;
    
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userId=" + userId + ", name=" + name + ", age=" + age + "]";
    }
    
}
