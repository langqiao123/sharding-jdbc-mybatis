package com.langqiao.sharding.jdbc;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
import com.langqiao.sharding.jdbc.entity.Student;
import com.langqiao.sharding.jdbc.entity.User;
import com.langqiao.sharding.jdbc.service.IListingService;
import com.langqiao.sharding.jdbc.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath*:config/spring/spring-database.xml",
        "classpath*:config/spring/spring-sharding.xml" })
public class ShardingJdbcMybatisTest {

    @Resource
    public IUserService userService;
    
    @Resource
    public IListingService studentService;

    @Test
    public void testUserInsert() {
		User u = new User();
		u.setAge(25);
		u.setName("war3");
		Assert.assertEquals(userService.insert(u), true);
    }
    
    @Test
    public void testUserBatchInsert() {
    	for(int i=0;i<100;i++) {
    		User u = new User();
//    		u.setUserId(20);
    		u.setAge(25);
    		u.setName("war3");
    		Assert.assertEquals(userService.insert(u), true);
    	}
    	try {
    		Thread.sleep(30000);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    @Test
    public void testStudentInsert() {
    	DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();
        Integer id = keyGenerator.generateKey().intValue();
        Student student = new Student();
        student.setId(id);
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe");
        Assert.assertEquals(studentService.insert(student), true);
    }

    @Test
    public void testFindAll(){
        List<User> users = userService.findAll();
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }
    
    @Test
    public void testSQLIN(){
        List<User> users = userService.findByUserIds(Arrays.asList(12L,14L,17L));
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }
    
    @Test
    public void testTransactionTestSucess(){
        userService.transactionTestSucess();
    }
    
    @Test(expected = IllegalAccessException.class)
    public void testTransactionTestFailure() throws IllegalAccessException{
        userService.transactionTestFailure();
    }
    
    
    @Test
    public void testGenerateKey() {
    	for(int i=0;i<100;i++) {
    		DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();
    		Integer id = keyGenerator.generateKey().intValue();
    		Long id_long = keyGenerator.generateKey().longValue();
    		System.out.println(id_long);
    	}
    }
    
}
