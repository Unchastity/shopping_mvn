package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.AdminUserDao;
import com.sr.shopping.entity.AdminUser;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class DaoTest {


    @Test
    public void testAdminUser() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        AdminUserDao adminUserDao = (AdminUserDao) context.getBean("adminUserDao");
        AdminUser user = adminUserDao.get(1);
        System.out.println(user);
    }
}