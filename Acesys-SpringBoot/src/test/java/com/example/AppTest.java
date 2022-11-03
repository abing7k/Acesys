package com.example;


import com.example.server.mapper.CanRegisteredMapper;
import com.example.server.mapper.UserRoleMapper;
import com.example.server.mapper.UsrMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest{
    @Autowired
    UsrMapper usrMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    CanRegisteredMapper canRegisteredMapper;
    @Test
    public void test01(){
        System.out.println(userRoleMapper.getRoleById(usrMapper.getSuperuserByUserName("admin")));
    }

    @Test
    public void test02(){
        System.out.println(canRegisteredMapper.CanRegistered(0));
    }
}
