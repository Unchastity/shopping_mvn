package com.sr.shopping.service.impl;

import com.sr.shopping.dao.AdminUserDao;
import com.sr.shopping.entity.AdminUser;
import com.sr.shopping.service.AdminUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    @Resource private AdminUserDao adminUserDao;

    @Override
    public AdminUser checkAdminUser(AdminUser adminUser) {
        return adminUserDao.findByUserNameAndPwd(adminUser.getUserName(), adminUser.getPassword());
    }
}
