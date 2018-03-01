package com.sr.shopping.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class ServiceTest {

    @Resource private UserService userService;

    @Test
    public void getUser() {

        Integer size = userService.totalPageWithSize(5);
        System.out.println(size);
    }

}