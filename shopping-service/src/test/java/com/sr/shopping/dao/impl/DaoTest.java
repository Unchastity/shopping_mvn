package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.AdminUserDao;
import com.sr.shopping.entity.AdminUser;
import com.sr.shopping.service.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class DaoTest {

    @Test
    public void testAdminUser() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        AdminUserDao adminUserDao = (AdminUserDao) context.getBean("adminUserDao");
        AdminUser user = adminUserDao.get(1);
        System.out.println(user);
    }
}